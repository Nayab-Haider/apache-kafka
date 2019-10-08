package com.kafka.shipping.config;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    protected Date creationDate;

    @LastModifiedDate
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastModifiedDate;
}
