package com.mtt.rnt.entities.RntDB;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "RNT_CONTACTO", schema = "NULLID")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATION")
    private Timestamp creation;

    @Column(name = "MODIFIED")
    private Timestamp modified;

    @Column(name = "CARGO")
    private String cargo;

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

}
