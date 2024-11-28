package cc.elvea.boot.system.message.sender;

import cc.elvea.boot.system.message.model.dto.SendMessageDto;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface MessageSender {

    void send(SendMessageDto message);

}
