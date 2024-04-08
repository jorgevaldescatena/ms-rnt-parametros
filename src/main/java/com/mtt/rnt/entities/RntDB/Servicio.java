package com.mtt.rnt.entities.RntDB;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "RNT_SERVICIO")
public class Servicio {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATION")
    private Date creation;

    @Column(name = "MODIFIED")
    private Date modified;

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

    @Column(name = "IDENT_SERVICIO")
    private Long identServicio;

    @Column(name = "VIGENCIA_DESDE")
    private Date vigenciaDesde;

    @Temporal(TemporalType.DATE)
    @Column(name = "VIGENCIA_HASTA")
    private Date vigenciaHasta;

    @Column(name = "ID_USER_CREATION")
    private Long idUserCreation;

    @Column(name = "ID_USER_MODIFIED")
    private Long idUserModified;

    @Column(name = "ID_TIPO_CANCELACION")
    private Long idTipoCancelacion;

    @Column(name = "TIPOSERVICIOSALIENTE_ID")
    private Long tipoServicioSalienteId;

    @Column(name = "ID_MOTIVO_MOD_SERVICIO")
    private Long idMotivoModServicio;

    @Column(name = "ACTIVO")
    private Integer activo;

    @Column(name = "CODIGO_REGION")
    private String codigoRegion;

    @Column(name = "ID_OLD")
    private Long idOld;

    @Column(name = "OBSERVACION")
    private String observaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPO_SERVICIO")
    private TipoServicio tipoServicio;

    @Column(name = "ID_ZONA")
    private Long idZona;

    @Column(name = "ID_TIPO_SUBSIDIO")
    private Long idTipoSubsidio;

    @Column(name = "CANTIDAD_REPRESENTANTES_ACTUAN")
    private Integer cantidadRepresentantesActuan;

    @Column(name = "ESPECIFICADOS_FORMA_ACTUAN")
    private String especificadosFormaActuan;

    @Column(name = "ID_DOCUMENTO_BIBLIOTECA_CANCELACION")
    private Long idDocumentoBibliotecaCancelacion;

    @Column(name = "ID_DOCUMENTO_BIBLIOTECA_INSCRIPCION")
    private Long idDocumentoBibliotecaInscripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_REGLAMENTACION")
    private Reglamentacion reglamentacion;

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recorrido> recorridos;

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VehiculoServicio> vehiculos;

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConductorServicio> conductoresServicio;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_TARIFA")
    private Tarifa tarifa;

    @Column(name = "ID_TIPO_CONTRATO")
    private Long idTipoContrato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_RESPONSABLE_SERVICIO")
    private ResponsableServicio responsable;

    @ManyToMany
    @JoinTable(name = "RNT_SERVICIO_REPRESENTANTE",
            joinColumns = @JoinColumn(name = "ID_SERVICIO"),
            inverseJoinColumns = @JoinColumn(name = "ID_REPRESENTANTE_SERVICIO"))
    private List<RepresentanteLegal> representantesLegales;

    @ManyToMany
    @JoinTable(name = "RNT_SERVICIO_CONTACTO",
            joinColumns = @JoinColumn(name = "ID_SERVICIO"),
            inverseJoinColumns = @JoinColumn(name = "ID_CONTACTO"))
    private List<Contacto> contactos;

    @ManyToMany
    @JoinTable(
            name = "RNT_ZONA",
            joinColumns = @JoinColumn(name = "ID_SERVICIO", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_ZONA", referencedColumnName = "ID")
    )
    private List<Zona> zonas;

}
