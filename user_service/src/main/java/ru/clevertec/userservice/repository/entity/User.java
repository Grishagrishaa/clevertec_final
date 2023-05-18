package ru.clevertec.userservice.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.clevertec.userservice.repository.entity.enums.ERole;
import ru.clevertec.userservice.repository.entity.enums.EStatus;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "users", schema = "signed", uniqueConstraints = {
        @UniqueConstraint(columnNames = "nick", name = "nickConstraint"),
        @UniqueConstraint(columnNames = "mail", name = "emailConstraint")
})
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode
@FieldNameConstants
@Data @NoArgsConstructor
public class User implements BaseEntity<UUID>{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID uuid;

    @CreatedDate
    private Instant createDate;

    @Version
    private Instant updateDate;

    private String mail;
    private String nick;

    @Enumerated(EnumType.STRING)
    private ERole role;

    @Enumerated(value = EnumType.STRING)
    private EStatus status;

    private String password;
}
