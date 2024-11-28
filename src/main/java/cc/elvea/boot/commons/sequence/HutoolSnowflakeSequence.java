package cc.elvea.boot.commons.sequence;

import cn.hutool.core.lang.Snowflake;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
public class HutoolSnowflakeSequence implements Sequence {

    private final Snowflake snowflake;

    public HutoolSnowflakeSequence(long epoch, long workerId, long dataCenterId) {
        this.snowflake = new Snowflake(new Date(epoch), workerId, dataCenterId, false);
    }

    @Override
    public long nextId() {
        return this.snowflake.nextId();
    }

    public static void main(String[] args) {
        Sequence sequence = SequenceManager.getSequence();
        for (int i = 0; i < 100; i++) {
            System.out.println(sequence.nextId());
        }
    }

}
