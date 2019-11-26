/*
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
    @JoinColumn(name = "debtor_id")
    private Debtor debtor;

    public Debt(Float price, String comment, Debtor debtor, boolean active) {
        this.price = price;
        this.comment = comment;
        this.debtor = debtor;
        this.active = active;
    }

    public Debt() {
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
*/
