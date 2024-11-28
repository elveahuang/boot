package cc.elvea.boot.commons.enums;

import lombok.Getter;

/**
 * @author elvea
 * @since 24.1.0
 */
@Getter
public enum ActionTypeEnum implements BaseEnum<String> {
    SAVE("SAVE", "保存"),
    DELETE("DELETE", "删除");

    private final static String LABEL_PREFIX = "label_action_type__";
    private final String action;
    private final String description;

    ActionTypeEnum(final String action, final String description) {
        this.action = action;
        this.description = description;
    }

    @Override
    public String getValue() {
        return this.action;
    }

    @Override
    public String getLabel() {
        return LABEL_PREFIX.concat(this.action.toLowerCase());
    }

}
