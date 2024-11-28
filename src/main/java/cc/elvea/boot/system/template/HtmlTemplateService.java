package cc.elvea.boot.system.template;

import java.util.Map;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface HtmlTemplateService {

    String toHtml(String template, Map<String, Object> params);

}
