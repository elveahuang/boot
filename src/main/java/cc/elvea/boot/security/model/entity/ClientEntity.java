package cc.elvea.boot.security.model.entity;

import cc.elvea.boot.commons.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * @author elvea
 * @since 24.1.0
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys_client")
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class ClientEntity extends BaseEntity {
    private String clientId;
    private LocalDateTime clientIdIssuedAt;
    private String clientSecret;
    private LocalDateTime clientSecretExpiresAt;
    private String clientName;
    private String clientAuthenticationMethods;
    private String authorizationGrantTypes;
    private String postLogoutRedirectUris;
    private String redirectUris;
    private String scopes;
    private String clientSettings;
    private String tokenSettings;
    private String description;
}
