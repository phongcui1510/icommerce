package com.icommerce.product.repository.entity;


import com.icommerce.product.service.shared.CommonUtils;
import com.icommerce.product.service.shared.LocalProfile;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.UUID;

public class AuditListener<T extends AbstractBaseEntity> {

    @PrePersist
    public void prePersist(T entity) {
        entity.setCreatedOn(LocalDateTime.now());
        entity.setId(UUID.randomUUID().toString());
        entity.setCreatedBy(CommonUtils.isNullOrEmpty(LocalProfile.getUserId()) ? "SYS" : LocalProfile.getUserId());
    }

    @PreUpdate
    public void preUpdate(T entity) {
        entity.setUpdatedOn(LocalDateTime.now());
        entity.setUpdatedBy(CommonUtils.isNullOrEmpty(LocalProfile.getUserId()) ? "SYS" : LocalProfile.getUserId());
    }
}
