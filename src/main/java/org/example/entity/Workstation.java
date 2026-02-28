package org.example.entity;

import jakarta.persistence.*;

@Entity
public class Workstation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String deskNumber;
    private String pcSerialNumber;
    @OneToOne(mappedBy = "workstation")
    private Employee employee;

    public String getDeskNumber() {
        return deskNumber;
    }

    public void setDeskNumber(String deskNumber) {
        this.deskNumber = deskNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
