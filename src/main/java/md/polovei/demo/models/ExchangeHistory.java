package md.polovei.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "exchange_hist")
public class ExchangeHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long iD;

    @ManyToOne
    @JoinColumn(name = "currency_code_in")
    private CurrencyDictionary currencyIn;

    @ManyToOne
    @JoinColumn(name = "currency_code_out")
    private CurrencyDictionary currencyOut;

    @ManyToOne
    @JoinColumn(name = "exchange")
    private Exchange exchange;

    private double sumIn;

    private double sumOut;

    @ManyToOne
    @JoinColumn(name = "employee")
    private Employee employee;

    public Long getID() {
        return iD;
    }

    public void setID(Long iD) {
        this.iD = iD;
    }

    public CurrencyDictionary getCurrencyIn() {
        return currencyIn;
    }

    public void setCurrencyIn(CurrencyDictionary currencyIn) {
        this.currencyIn = currencyIn;
    }

    public CurrencyDictionary getCurrencyOut() {
        return currencyOut;
    }

    public void setCurrencyOut(CurrencyDictionary currencyOut) {
        this.currencyOut = currencyOut;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

    public double getSumIn() {
        return sumIn;
    }

    public void setSumIn(double sumIn) {
        this.sumIn = sumIn;
    }

    public double getSumOut() {
        return sumOut;
    }

    public void setSumOut(double sumOut) {
        this.sumOut = sumOut;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
