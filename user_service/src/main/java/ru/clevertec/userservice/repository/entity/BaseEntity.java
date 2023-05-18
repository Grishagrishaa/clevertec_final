package ru.clevertec.userservice.repository.entity;

import java.io.Serializable;

public interface BaseEntity<T extends Serializable> {

    T getUuid();

    void setUuid(T id);
}