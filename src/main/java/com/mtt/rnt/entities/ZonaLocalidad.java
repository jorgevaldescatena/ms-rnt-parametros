package com.mtt.rnt.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "RNT_ZONA_LOCALIDAD")
public class ZonaLocalidad {

    @Id
    @Column(name = "ID_ZONA_LOCALIDAD")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ZONA")
    private Zona zona;

    @Column(name = "ID_LOCALIDAD", nullable = false)
    private Integer idLocalidad;


}
