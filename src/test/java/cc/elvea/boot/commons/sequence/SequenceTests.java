package cc.elvea.boot.commons.sequence;

import cc.elvea.boot.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SequenceTests extends BaseTests {

    @Autowired
    private Sequence sequence;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(sequence);
        Assertions.assertTrue(sequence.nextId() > 0);
    }

}
