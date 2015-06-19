package com.pluralsight.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name="activities")
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Activity {

    @Id
    @GeneratedValue
    @XmlElement
    private long id;

    @XmlElement
    @Column(name="description", nullable = false)
    private String desc;

    public Activity(){
    }

    public Activity(String desc){
        this.desc = desc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
