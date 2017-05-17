package com.breedish.ses.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "id_generator")
    protected Long id;

    @Column(updatable = false)
    @CreationTimestamp
    protected Instant created;

    @UpdateTimestamp
    protected Instant updated;

    @Version
    protected int version;

}
