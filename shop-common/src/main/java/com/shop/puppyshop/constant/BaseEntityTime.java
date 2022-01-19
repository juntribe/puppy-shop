package com.shop.puppyshop.constant;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
@Setter
public abstract class BaseEntityTime {

    @CreatedDate
    @Column(name = "regtime", updatable = false)
    private LocalDateTime regTime;

    @LastModifiedDate
    @Column(name = "updatetime")
    private LocalDateTime updateTime;
}
