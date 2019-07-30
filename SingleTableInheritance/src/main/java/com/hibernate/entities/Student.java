package com.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@DiscriminatorValue(value = "student_type")
public class Student extends Person {

    @Column(name = "univercity")
    private String univercity;

    public String getUnivercity() {
	return univercity;
    }

    public void setUnivercity(String univercity) {
	this.univercity = univercity;
    }

    @Override
    public String toString() {
	return "Student " + super.toString() + "univercity= " + univercity;
    }

}
