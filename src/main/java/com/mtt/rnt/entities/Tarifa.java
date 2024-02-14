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
@Table(name = "RNT_TARIFA")
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATION")
    private Timestamp creation;

    @Column(name = "MODIFIED")
    private Timestamp modified;

    @Column(name = "MONTO_FIJO")
    private Double montoFijo;

    @Column(name = "MONTO_MAXIMO")
    private Double montoMaximo;

    @Column(name = "MONTO_MINIMO")
    private Double montoMinimo;

    @Column(name = "TIPO_TARIFA", length = 255)
    private String tipoTarifa;

    @Column(name = "ID_USER_CREATION")
    private Long idUserCreation;

    @Column(name = "ID_USER_MODIFIED")
    private Long idUserModified;

    @Column(name = "ID_SERVICIO_RECORRIDO_OLD")
    private Long idServicioRecorridoOld;

    @Column(name = "ID_SERVICIO_OLD")
    private Long idServicioOld;

}
