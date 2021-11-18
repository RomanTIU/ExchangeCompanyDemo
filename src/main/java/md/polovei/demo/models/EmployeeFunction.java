package md.polovei.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "employee_function")
public class EmployeeFunction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "functionID", nullable = false)
    private Long functionID;

    private String name;

    private String description;

    public Long getFunctionID() {
        return functionID;
    }

    public void setFunctionID(Long functionID) {
        this.functionID = functionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
