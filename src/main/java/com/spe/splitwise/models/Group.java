package com.spe.splitwise.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group extends Base {
    @Column(name = "groupName")
    private String name;

    @JoinColumn
    @ManyToOne
    private User admin;

    @ManyToMany
    private List<User> members;

    @JoinColumn
    @OneToMany
    private List<Expense> expenses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public Group(String name, User admin, List<User> members, List<Expense> expenses) {
        this.name = name;
        this.admin = admin;
        this.members = members;
        this.expenses = expenses;
    }

    public Group() {
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", admin=" + admin +
                ", members=" + members +
                ", expenses=" + expenses +
                '}';
    }
}
