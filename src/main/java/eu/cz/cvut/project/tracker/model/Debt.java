package eu.cz.cvut.project.tracker.model;

import javax.persistence.*;

@Entity
@Table(name = "debt_d")
public class Debt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private float price;
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "acc_id")
    private Account account;

    public Debt() {
    }

    public Debt(float price, String comment, Account account, boolean active) {
        this.price = price;
        this.comment = comment;
        this.account = account;
        this.active = active;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private boolean active;
}
