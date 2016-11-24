/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.pneuservis.entity;

import cz.fi.muni.pa165.pneuservis.enums.PaymentType;

import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author xbonco1 Order class
 */
@Entity
@Table(name = "PROJECT_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Long clientId;

    @NotNull
    @OneToMany(targetEntity = Service.class, cascade = {CascadeType.ALL})
    private List<Service> listOfServices;

    @NotNull
    @OneToMany(targetEntity = Tire.class, cascade = {CascadeType.ALL})
    private List<Tire> listOfTires;

    @Basic(optional = true)
    private String note;

    private boolean paymentConfirmed;

    private boolean shipped;

    private PaymentType paymentType;

    public Order(Long clientId, String note, List<Service> listOfServices, List<Tire> listOfTires, boolean paymentConfirmed, boolean shipped, PaymentType paymentType) {
        this.clientId = clientId;
        this.listOfServices = listOfServices;
        this.listOfTires = listOfTires;
        this.note = note;
        this.paymentConfirmed = paymentConfirmed;
        this.shipped = shipped;
        this.paymentType = paymentType;
    }

    public Order() { }

    public Long getId() {
        return id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void addService(Service service) {
        listOfServices.add(service);
    }

    public void addTire(Tire tire) {
        listOfTires.add(tire);
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isPaymentConfirmed() {
        return paymentConfirmed;
    }

    public void setPaymentConfirmed(boolean paymentConfirmed) {
        this.paymentConfirmed = paymentConfirmed;
    }

    public boolean isShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public void setListOfServices(List<Service> listOfServices) {
        this.listOfServices = listOfServices;
    }

    public List<Service> getListOfServices() {
        return this.listOfServices;
    }

    public void setListOfTires(List<Tire> listOfTires) {
        this.listOfTires = listOfTires;
    }

    public List<Tire> getListOfTires() {
        return this.listOfTires;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return isPaymentConfirmed() == order.isPaymentConfirmed() &&
                isShipped() == order.isShipped() &&
                Objects.equals(getId(), order.getId()) &&
                Objects.equals(getClientId(), order.getClientId()) &&
                Objects.equals(listOfServices, order.listOfServices) &&
                Objects.equals(listOfTires, order.listOfTires) &&
                Objects.equals(getNote(), order.getNote()) &&
                getPaymentType() == order.getPaymentType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getClientId(), listOfServices, listOfTires, getNote(), isPaymentConfirmed(), isShipped(), getPaymentType());
    }
}
