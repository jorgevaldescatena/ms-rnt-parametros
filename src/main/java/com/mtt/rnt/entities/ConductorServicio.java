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
@Table(name = "RNT_CONDUCTOR_SERVICIO")
public class ConductorServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATION", nullable = false)
    private Timestamp creation;

    @Column(name = "MODIFIED")
    private Timestamp modified;

    @Column(name = "REGION_DESTINO", length = 255)
    private String regionDestino;

    @Column(name = "ESTADO")
    private Integer estado;

    @Column(name = "FECHA_ESTADO")
    private Timestamp fechaEstado;

    @Column(name = "RESOLUCION_CANCELACION_FECHA")
    private Timestamp resolucionCancelacionFecha;

    @Column(name = "RESOLUCION_CANCELACION_LINK")
    private String resolucionCancelacionLink;

    @Column(name = "NUMERO_RESOLUCION")
    private String numeroResolucion;

    @Column(name = "OBSERVACION_CANCELACION")
    private String observacionCancelacion;

    @Column(name = "ORIGEN_CONDUCTOR")
    private String origenConductor;

    @Column(name = "ID_USER_CREATION")
    private Long idUserCreation;

    @Column(name = "ID_USER_MODIFIED")
    private Long idUserModified;

    @Column(name = "ID_TIPO_CANCELACION")
    private Long idTipoCancelacion;

    @Column(name = "TIPOSERVICIOSALIENTE_ID")
    private Long tiposervicioSalienteId;

    @Column(name = "ID_CONDUCTOR")
    private Long idConductor;

    @Column(name = "ID_SERVICIO")
    private Long idServicio;

}
