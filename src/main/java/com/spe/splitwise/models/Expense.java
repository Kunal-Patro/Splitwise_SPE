package com.spe.splitwise.models;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "expenses")
public class Expense extends Base{

    @JoinColumn(name = "createdBy")
    @ManyToOne
    private User user;

    @Column(name = "amount")
    private long amount;

    @Column(name = "description")
    private String description;

    @JoinColumn(name = "paidBy")
    @ElementCollection
    Map<User,Long> paidBy;

    @JoinColumn(name = "owedBy")
    @ElementCollection
    Map<User,Long> owedBy;

    public Expense(User user, long amount, String description, Map<User, Long> paidBy, Map<User, Long> owedBy) {
        this.user = user;
        this.amount = amount;
        this.description = description;
        this.paidBy = paidBy;
        this.owedBy = owedBy;
    }

    public Expense() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<User, Long> getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(Map<User, Long> paidBy) {
        this.paidBy = paidBy;
    }

    public Map<User, Long> getOwedBy() {
        return owedBy;
    }

    public void setOwedBy(Map<User, Long> owedBy) {
        this.owedBy = owedBy;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "user=" + user +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", paidBy=" + paidBy +
                ", owedBy=" + owedBy +
                '}';
    }
}
