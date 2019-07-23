package com.p5.flightmanager.repository.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@EntityListeners({BaseModel.EntityListener.class})
public abstract class BaseModel implements Serializable {

    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Type(type = "pg-uuid")
    @Column(name = "id", updatable = false, unique = true)
    private UUID id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "date_created")
    @Type(type = "date")
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_update")
    @Type(type = "date")
    private Date updateDate;

    @Column(nullable = false, name = "deleted")
    @Type(type = "boolean")
    private Boolean deleted = Boolean.FALSE;

    public BaseModel() {
        //default constructor
    }

    public BaseModel(BaseModel source) {
        this.createdDate = source.createdDate;
        this.updateDate = source.updateDate;
        this.deleted = source.deleted;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public static class EntityListener {

        @PrePersist
        public void onPrePersist(BaseModel baseModel) {
            baseModel.setCreatedDate(new Date());
        }

        @PreUpdate
        public void onPreUpdate(BaseModel baseModel) {
            baseModel.setUpdateDate(new Date());
        }
    }
}