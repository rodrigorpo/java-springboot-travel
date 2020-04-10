package com.rpolnx.travel.domain.entity;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;

public abstract class BaseEntity {
    protected LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
