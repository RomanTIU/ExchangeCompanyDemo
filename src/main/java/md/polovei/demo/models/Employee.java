package md.polovei.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeID", nullable = false)
    private Long employeeID;

    private String name;

    @Column(name="sur_name")
    private String surName;

    private String sex;

    private String telephone;

    private String email;

    private int age;

    @ManyToOne
    @JoinColumn(name = "employee_section")
    private ExchangeSection section;

    @ManyToOne
    @JoinColumn(name = "employee_function")
    private EmployeeFunction function;

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ExchangeSection getSection() {
        return section;
    }

    public void setSection(ExchangeSection section) {
        this.section = section;
    }

    public EmployeeFunction getFunction() {
        return function;
    }

    public void setFunction(EmployeeFunction function) {
        this.function = function;
    }
}
