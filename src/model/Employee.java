package model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee extends Person {
    @OneToMany(
        mappedBy = "employee",
        cascade = jakarta.persistence.CascadeType.ALL
    )
    private List<ServiceOrder> serviceOrders;

    public Employee() {
    }

    public Employee(String name, String document, String phone) {
        super(name, document, phone);
        this.serviceOrders = new ArrayList<ServiceOrder>();
    }

    public void addServiceOrder(ServiceOrder serviceOrder) {
        serviceOrders.add(serviceOrder);
    }

    public List<ServiceOrder> getServiceOrders() {
        return serviceOrders;
    }

    @Override
    public String toString() {
        return "Employee [name=" + getName() + ", document=" + getDocument() + ", phone=" + getPhone() + "]";
    }
}
