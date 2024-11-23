package cc.elvea.boot.system.cache.service;

import cc.elvea.boot.BaseTests;
import cc.elvea.boot.system.cache.CacheService;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CacheServiceTests extends BaseTests {

    @Autowired
    private CacheService cacheService;

    @Test
    void contextTest() {
        Assertions.assertNotNull(cacheService);
    }

    @Test
    void baseTest() {
        this.cacheService.set("A", "ABC");
        this.cacheService.set("B", Lists.newArrayList("A", "B"));
    }

}
