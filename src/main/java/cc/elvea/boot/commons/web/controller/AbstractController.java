package cc.elvea.boot.commons.web.controller;

/**
 * @author elvea
 * @since 24.1.0
 */
public abstract class AbstractController {

    protected String redirect(String url) {
        return String.format("redirect:%s", url);
    }

    protected String forward(String url) {
        return String.format("forward:%s", url);
    }

}
