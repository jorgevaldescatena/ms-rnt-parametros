package com.mtt.rnt.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "REGION")
public class Region {

    @Id
    @Column(name = "ID", columnDefinition = "char")
    private String codigo;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "PREFIJO", nullable = false)
    private String prefijo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "region")
    private List<Provincia> provincias;

    @Transient
    public String getRegionIdentifier() {
        return codigo;
    }

    @Transient
    public String getIdentifier() {
        return codigo;
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
