package com.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends Person {

    @Column(name = "univercity")
    private String univercity;

    public String getUnivercity() {
	return univercity;
    }

    public void setUnivercity(String univercity) {
	this.univercity = univercity;
    }

}
