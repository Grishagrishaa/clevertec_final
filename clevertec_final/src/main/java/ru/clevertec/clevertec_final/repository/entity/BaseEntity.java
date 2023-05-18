package ru.clevertec.clevertec_final.repository.entity;

import java.io.Serializable;

public interface BaseEntity<T extends Serializable> {

    T getUuid();

    void setUuid(T id);
}