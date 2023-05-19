package ru.clevertec.clevertec_final.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;

/**
 * Abstract base class for entities with auditing fields.
 *
 * @param <T> the type of the entity's identifier
 */
@Getter
@Setter
@SuperBuilder(setterPrefix = "set")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class AuditingEntity<T extends Serializable> implements BaseEntity<T> {

    /**
     * The date and time when the entity was created.
     */
    @CreatedDate
    private Instant createdDate;

    /**
     * The date and time when the entity was last updated.
     */
    @LastModifiedDate
    private Instant updatedDate;

    /**
     * The username of the creator.
     */
    @CreatedBy
    private String username;

    /**
     * The username of the modifier.
     */
    @LastModifiedBy
    private String modifiedBy;
}