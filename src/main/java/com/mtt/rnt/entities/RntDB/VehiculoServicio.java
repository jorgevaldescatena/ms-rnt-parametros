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
@Table(name = "RNT_VEHICULO_SERVICIO")
public class VehiculoServicio {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATION")
    private Timestamp creation;

    @Column(name = "MODIFIED")
    private Timestamp modified;

    @Column(name = "REGION_DESTINO")
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

    @Column(name = "FECHA_INGRESO_SERVICIO")
    private Timestamp fechaIngresoServicio;

    @Column(name = "FECHA_INGRESO")
    private Timestamp fechaIngreso;

    @Column(name = "FECHA_VENCIMIENTO")
    private Timestamp fechaVencimiento;

    @Column(name = "FECHA_LOGO")
    private Timestamp fechaLogo;

    @Column(name = "OBSERVACION")
    private String observacion;

    @Column(name = "TIENE_CERTIFICADO_PROVISORIO")
    private Boolean tieneCertificadoProvisorio;

    @Column(name = "ID_USER_CREATION")
    private Long idUserCreation;

    @Column(name = "ID_USER_MODIFIED")
    private Long idUserModified;

    @Column(name = "ID_TIPO_CANCELACION")
    private Long idTipoCancelacion;

    @Column(name = "TIPOSERVICIOSALIENTE_ID")
    private Long tiposervicioSalienteId;

    @Column(name = "ID_VEHICULO_REEMPLAZA")
    private Long idVehiculoReemplaza;

    @Column(name = "ID_VEHICULO_REEMPLAZADO")
    private Long idVehiculoReemplazado;

    @Column(name = "ID_TIPO_INGRESO")
    private Integer idTipoIngreso;

    @Column(name = "ID_VEHICULO")
    private Long idVehiculo;

    @Column(name = "RESPUESTA_FIRMADOR")
    private Integer respuestaFirmador;

    @Column(name = "MENSAJE_FIRMADOR")
    private String mensajeFirmador;

    @Column(name = "GLOSA")
    private String glosa;

    @Column(name = "ID_REGLAMENTACION")
    private Long idReglamentacion;

    @Column(name = "ID_ZONA")
    private Long idZona;

    @Column(name = "ID_DOCUMENTO_BIBLIOTECA_CANCELACION")
    private Long idDocumentoBibliotecaCancelacion;

    @Column(name = "ID_DOCUMENTO_BIBLIOTECA_INSCRIPCION")
    private Long idDocumentoBibliotecaInscripcion;

    @Column(name = "ID_DOCUMENTO_BIBLIOTECA_REVERSION")
    private Long idDocumentoBibliotecaReversion;

    @Column(name = "FECHA_OTORGAMIENTO_BENEFICIO")
    private Timestamp fechaOtorgamientoBeneficio;

    @Column(name = "FECHA_POSTULACION")
    private Timestamp fechaPostulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SERVICIO")
    private Servicio servicio;

}
