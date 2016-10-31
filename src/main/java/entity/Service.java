/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 *
 * @author Ivan Moscovic
 */
@Entity
public class Service extends Product {

    @NotNull
    @Column(nullable = false)
    private int duration;

    @NotNull
    @Column(nullable = false)
    private boolean ownParts;

    @NotNull
    @Column(nullable = false)
    private String nameOfService;

    public boolean hasOwnParts() {
        return ownParts;
    }

    public void setOwnParts(boolean ownParts) {
        this.ownParts = ownParts;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getNameOfService() {
        return nameOfService;
    }

    public void setNameOfService(String nameOfService) {
        this.nameOfService = nameOfService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Service service = (Service) o;

        if (!Objects.equals(this.nameOfService, service.getNameOfService())) {
            return false;
        }
        if (!Objects.equals(this.duration, service.getDuration())) {
            return false;
        }
        if (!Objects.equals(this.ownParts, service.hasOwnParts())) {
            return false;
        }
        if (!Objects.equals(super.getId(), service.getId())){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.duration);
        hash = 89 * hash + Objects.hashCode(this.ownParts);
        hash = 89 * hash + Objects.hashCode(this.nameOfService);
        hash = 89 * hash + Objects.hashCode(super.getId());

        return hash;
    }
}
