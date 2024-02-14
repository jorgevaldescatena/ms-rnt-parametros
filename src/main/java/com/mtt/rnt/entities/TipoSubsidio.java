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
@Table(name = "RNT_TIPO_SUBSIDIO")
public class TipoSubsidio {

    @Id
    @Column(name = "ID_TIPO_SUBSIDIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPTOR")
    private String descriptor;

    @Column(name = "REQUIERE_ZONAS")
    private Boolean requiereZonas;

}
