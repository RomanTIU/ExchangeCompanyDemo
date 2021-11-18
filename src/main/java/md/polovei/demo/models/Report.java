package md.polovei.demo.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reportID", nullable = false)
    private Long reportID;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private ExchangeSection section;

    @ManyToOne
    @JoinColumn(name = "currency_code")
    private CurrencyDictionary currency;

    @Column(name = "num_exchange")
    private int numExchanges;

    @Column(name = "sum_in_cash")
    private double sumInCash;

    @Column(name="report_date")
    private Date reportDate;

    public Long getReportID() {
        return reportID;
    }

    public void setReportID(Long reportID) {
        this.reportID = reportID;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ExchangeSection getSection() {
        return section;
    }

    public void setSection(ExchangeSection section) {
        this.section = section;
    }

    public CurrencyDictionary getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyDictionary currency) {
        this.currency = currency;
    }

    public int getNumExchanges() {
        return numExchanges;
    }

    public void setNumExchanges(int numExchanges) {
        this.numExchanges = numExchanges;
    }

    public double getSumInCash() {
        return sumInCash;
    }

    public void setSumInCash(double sumInCash) {
        this.sumInCash = sumInCash;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }
}
