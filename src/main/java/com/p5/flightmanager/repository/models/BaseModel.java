package com.p5.flightmanager.repository.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
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

    @Column(name = "date_created", nullable = false)
    @Type(type = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "date_update")
    @Type(type = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @Column(name = "deleted", nullable = false)
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

    public static class EntityListener{

        @PrePersist
        public void onRepersist(BaseModel baseModel){
            baseModel.setCreatedDate(new Date());
        }

        @PreUpdate
        public void onPreUpdate(BaseModel baseModel){
            baseModel.setUpdateDate(new Date());
        }
    }
}
