package cc.elvea.boot.commons.sequence;

import cc.elvea.boot.commons.constants.DateTimeConstants;

/**
 * @author elvea
 * @since 24.1.0
 */
public class SequenceManager {

    private static volatile Sequence globalSequence = new HutoolSnowflakeSequence(DateTimeConstants.EPOCH, 1, 1);

    public static Sequence getSequence() {
        return globalSequence;
    }

    public static void setSequence(Sequence sequence) {
        globalSequence = sequence;
    }

}
