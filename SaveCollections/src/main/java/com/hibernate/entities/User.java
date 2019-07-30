package com.hibernate.entities;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.hibernate.model.Account;

@Entity
@Table(name = "user_table")
@DynamicUpdate
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "account_table", joinColumns = @JoinColumn(name = "user_id"))
    @GenericGenerator(name = "sequence_gen", strategy = "sequence")
    @CollectionId(columns = { @Column(name = "account_id") }, generator = "sequence_gen", type = @Type(type = "long"))
    private Collection<Account> userAccounts = new HashSet<Account>();

    public int getUserId() {
	return userId;
    }

    public void setUserId(int userId) {
	this.userId = userId;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public Collection<Account> getUserAccounts() {
	return userAccounts;
    }

    public void setUserAccounts(Collection<Account> userAccounts) {
	this.userAccounts = userAccounts;
    }

}
