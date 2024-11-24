package cc.elvea.boot.system.commons.aspect;

import cc.elvea.boot.commons.annotations.RateLimiter;
import cc.elvea.boot.commons.enums.RateLimitTypeEnum;
import cc.elvea.boot.commons.enums.ResponseCodeEnum;
import cc.elvea.boot.commons.exception.ServiceException;
import cc.elvea.boot.commons.utils.ServletUtils;
import cc.elvea.boot.system.cache.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@Aspect
@Component
public class RateLimitAspect {

    private final static String RATE_LIMIT_KEY = "RateLimiter";

    private final ExpressionParser expressionParser = new SpelExpressionParser();

    private final ParserContext parserContext = new TemplateParserContext();

    private final EvaluationContext evaluationContext = new StandardEvaluationContext();

    private final ParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();

    private final CacheService cacheService;

    public RateLimitAspect(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Before("@annotation(rateLimiter)")
    public void doBefore(JoinPoint point, RateLimiter rateLimiter) {
        int time = rateLimiter.time();
        int limit = rateLimiter.limit();
        String key = getKey(rateLimiter, point);
        RateLimitTypeEnum type = rateLimiter.type();
        try {
            long number = cacheService.rateLimiter(key, type, limit, time);
            if (number == -1) {
                throw new ServiceException(ResponseCodeEnum.RATE_LIMIT_ERROR);
            }
        } catch (Exception e) {
            log.error("Rate Limit Error.", e);
            if (e instanceof ServiceException) {
                throw e;
            } else {
                throw new ServiceException(ResponseCodeEnum.RATE_LIMIT_ERROR);
            }
        }
    }

    private String getKey(RateLimiter rateLimiter, JoinPoint point) {
        String key = rateLimiter.key();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        if (org.apache.commons.lang3.StringUtils.containsAny(key, "#")) {
            Object[] args = point.getArgs();
            String[] parameterNames = parameterNameDiscoverer.getParameterNames(method);
            if (parameterNames == null || parameterNames.length == 0) {
                throw new ServiceException();
            }
            for (int i = 0; i < parameterNames.length; i++) {
                evaluationContext.setVariable(parameterNames[i], args[i]);
            }
            try {
                Expression expression;
                if (org.apache.commons.lang3.StringUtils.startsWith(key, parserContext.getExpressionPrefix()) &&
                        org.apache.commons.lang3.StringUtils.endsWith(key, parserContext.getExpressionSuffix())) {
                    expression = expressionParser.parseExpression(key, parserContext);
                } else {
                    expression = expressionParser.parseExpression(key);
                }
                key = expression.getValue(evaluationContext, String.class) + ":";
            } catch (Exception e) {
                log.error("Rate Limit Error.", e);
                throw new ServiceException(ResponseCodeEnum.RATE_LIMIT_ERROR);
            }
        }
        StringBuilder sb = new StringBuilder(RATE_LIMIT_KEY);
        sb.append(":").append(ServletUtils.getRequest().getRequestURI()).append(":");
        if (rateLimiter.type() == RateLimitTypeEnum.IP) {
            sb.append(ServletUtils.getHost());
        } else {
            sb.append(cacheService.getClientId());
        }
        return sb.append(key).toString();
    }

}
