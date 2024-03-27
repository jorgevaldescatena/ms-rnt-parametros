package com.mtt.rnt.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "RNT_RECORRIDO")
public class Recorrido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATION")
    private String creation;

    @Column(name = "MODIFIED")
    private String modified;

    @Column(name = "REGION_DESTINO")
    private String regionDestino;

    @Column(name = "ESTADO")
    private Integer estado;

    @Column(name = "FECHA_ESTADO")
    private Date fechaEstado;

    @Column(name = "RESOLUCION_CANCELACION_FECHA")
    private Date resolucionCancelacionFecha;

    @Column(name = "RESOLUCION_CANCELACION_LINK")
    private String resolucionCancelacionLink;

    @Column(name = "NUMERO_RESOLUCION")
    private String numeroResolucion;

    @Column(name = "OBSERVACION_CANCELACION")
    private String observacionCancelacion;

    @Column(name = "LONGITUD")
    private Double longitud;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "ID_USER_CREATION")
    private Long idUserCreation;

    @Column(name = "ID_USER_MODIFIED")
    private Long idUserModified;

    @Column(name = "ID_TIPO_CANCELACION")
    private Long idTipoCancelacion;

    @Column(name = "TIPOSERVICIOSALIENTE_ID")
    private Long tipoServicioSalienteId;

    @Column(name = "ID_DESTINO")
    private Long idDestino;

    @Column(name = "ID_ORIGEN")
    private Long idOrigen;

    @Column(name = "ID_TARIFA")
    private Long idTarifa;

    @Column(name = "RESPUESTA_FIRMADOR")
    private Integer respuestaFirmador;

    @Column(name = "MENSAJE_FIRMADOR")
    private String mensajeFirmador;

    @Column(name = "ID_SERVICIO_RECORRIDO_OLD")
    private Long idServicioRecorridoOld;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SERVICIO")
    private Servicio servicio;

}
