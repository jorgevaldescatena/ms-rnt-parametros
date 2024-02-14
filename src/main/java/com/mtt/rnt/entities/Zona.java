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
@Table(name = "RNT_ZONA")
public class Zona {

    @Id
    @Column(name = "ZONA_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPTOR")
    private String descriptor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPO_ZONA")
    private TipoZona tipoZona;

    @Column(name = "ID_REGION")
    private String idRegion;

    @Column(name = "ID_OLD")
    private Long idOld;

    @Column(name = "ACTIVA")
    private Boolean activa;

    @OneToMany(mappedBy = "zona", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ZonaRegion> zonaRegiones;

    @OneToMany(mappedBy = "zona", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ZonaComuna> zonaComunas;

    @OneToMany(mappedBy = "zona", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ZonaLocalidad> zonaLocalidades;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPO_SUBSIDIO")
    private TipoSubsidio tipoSubsidio;

    @ManyToMany(mappedBy = "zonas")
    private List<Servicio> servicios;

}
