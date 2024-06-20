package com.mtt.rnt.entities.utilsDB;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "LOCALIDAD", schema = "NULLID")
public class Localidad {

    @Id
    @Column(name = "ID", nullable = false)
    private Long codigo;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @ManyToOne(targetEntity = Comuna.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "IDCOMUNA", nullable = true)
    private Comuna comuna;

    @Transient
    public String getRegionIdentifier() {
        return comuna != null ? comuna.getRegionIdentifier() : null;
    }

    @Transient
    public String getIdentifier() {
        return String.valueOf(codigo);
    }

    @Transient
    public String getLabel() {
        return nombre;
    }

    @Transient
    public String getLabelLarge() {
        return nombre;
    }

}
