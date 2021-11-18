package md.polovei.demo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exchange")
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exchangeID", nullable = false)
    private Long exchangeID;

    @ManyToOne
    @JoinColumn(name = "currency_code_main")
    private CurrencyDictionary currencyMain;

    @ManyToOne
    @JoinColumn(name = "currency_code_sec")
    private CurrencyDictionary currencySec;

    private double price;

    private long rate;

    @Column(name = "date_exchange")
    private Date exchangeDate;

    public long getRate() {
        return rate;
    }

    public void setRate(long rate) {
        this.rate = rate;
    }

    public Long getExchangeID() {
        return exchangeID;
    }

    public void setExchangeID(Long exchangeID) {
        this.exchangeID = exchangeID;
    }

    public CurrencyDictionary getCurrencyMain() {
        return currencyMain;
    }

    public void setCurrencyMain(CurrencyDictionary currencyMain) {
        this.currencyMain = currencyMain;
    }

    public CurrencyDictionary getCurrencySec() {
        return currencySec;
    }

    public void setCurrencySec(CurrencyDictionary currencySec) {
        this.currencySec = currencySec;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(Date exchangeDate) {
        this.exchangeDate = exchangeDate;
    }
}
