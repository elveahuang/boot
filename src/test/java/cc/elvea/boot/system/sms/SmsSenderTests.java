package cc.elvea.boot.system.sms;

import cc.elvea.boot.BaseTests;
import cc.elvea.boot.configuration.properties.TestProperties;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class SmsSenderTests extends BaseTests {

    @Autowired
    private SmsSender smsSender;

    @Autowired
    private TestProperties testProperties;

    @Test
    void baseTest() throws Exception {
        Map<String, Object> params = Maps.newHashMap();
        params.put("code", "123456");

        SmsBody body = SmsBody.builder().mobileNumber(testProperties.getMobile()).params(params).build();
        this.smsSender.send(body);
    }

}
