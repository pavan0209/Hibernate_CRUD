package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "workstations")
public class Workstation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deskNumber;

    private String pcSerialNumber;

    @OneToOne(mappedBy = "workstation")
    private Employee employee;

    public Long getId() {
        return id;
    }

    public String getDeskNumber() {
        return deskNumber;
    }

    public void setDeskNumber(String deskNumber) {
        this.deskNumber = deskNumber;
    }

    public String getPcSerialNumber() {
        return pcSerialNumber;
    }

    public void setPcSerialNumber(String pcSerialNumber) {
        this.pcSerialNumber = pcSerialNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Workstation{" +
                "id=" + id +
                ", deskNumber='" + deskNumber + '\'' +
                ", pcSerialNumber='" + pcSerialNumber + '\'' +
                '}';
    }
}