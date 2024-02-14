package com.mtt.rnt.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.security.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "RNT_REPRESENTATE_LEGAL")
public class RepresentanteLegal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATION", nullable = false)
    private Timestamp creation;

    @Column(name = "MODIFIED")
    private Timestamp modified;

    @Column(name = "AUTORIZADO_TRAMITES")
    private Boolean autorizadoTramites;

    @Column(name = "CODIGO_COMUNA")
    private String codigoComuna;

    @Column(name = "CODIGO_REGION")
    private String codigoRegion;

    @Column(name = "DOMICILIO")
    private String domicilio;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FAX")
    private String fax;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "ID_USER_CREATION")
    private Long idUserCreation;

    @Column(name = "ID_USER_MODIFIED")
    private Long idUserModified;

    @Column(name = "ID_PERSONA")
    private Long idPersona;

    @Column(name = "ID_TIPO_REPRESENTANTE_LEGAL")
    private Long idTipoRepresentanteLegal;

    @Column(name = "REQUERIDO_FORMA_ACTUAN")
    private Short requeridoFormaActuan;

}
