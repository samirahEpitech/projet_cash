package eu.epitech.cashmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    private float total;
    private boolean status;

    @Enumerated(EnumType.STRING)
    @Column(length = 6)
    private PaymentType paymentType;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "bill")
    private Set<BillContent> billContents;

    public Bill() {
        this.createdAt = LocalDateTime.now();
    }

    public Bill(int id, float total, boolean status, PaymentType paymentType, int userId) {
        super();
        this.id = id;
        this.total = total;
        this.status = status;
        this.paymentType = paymentType;
        this.user = new User(userId, "", "", "");
        this.createdAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<BillContent> getBillContents() {
        return billContents;
    }
}
