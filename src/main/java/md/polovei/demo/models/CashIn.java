package md.polovei.demo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cash_in")
public class CashIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long iD;

    @ManyToOne
    @JoinColumn(name = "currency_code")
    private CurrencyDictionary currency;

    private double sum;

    @ManyToOne
    @JoinColumn(name = "employee")
    private Employee employee;

    @Column(name = "in_date")
    private Date inDate;

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Long getID() {
        return iD;
    }

    public void setID(Long iD) {
        this.iD = iD;
    }

    public CurrencyDictionary getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyDictionary currency) {
        this.currency = currency;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }
}
