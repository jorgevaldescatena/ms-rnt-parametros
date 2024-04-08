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
@Table(name = "RNT_TIPO_SERVICIO")
public class TipoServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATION")
    private Timestamp creation;

    @Column(name = "MODIFIED")
    private Timestamp modified;

    @Column(name = "PASAJEROS_POR_SERVICIO")
    private Integer pasajerosPorServicio;

    @Column(name = "AUXILIARES_POR_SERVICIO")
    private Integer auxiliaresPorServicio;

    @Column(name = "CONDUCTORES_POR_SERVICIO")
    private Integer conductoresPorServicio;

    @Column(name = "DOCUMENTO_ASOCIADO")
    private String documentoAsociado;

    @Column(name = "GLOSA")
    private String glosa;

    @Column(name = "GLOSA_AL_VEHICULO")
    private Integer glosaAlVehiculo;

    @Column(name = "GLOSA_EN_CERTIFICADO")
    private Integer glosaEnCertificado;

    @Column(name = "GLOSA_POR_SERVICIO")
    private Integer glosaPorServicio;

    @Column(name = "HABILITAR_AUXILIAR")
    private Integer habilitarAuxiliar;

    @Column(name = "HABILITAR_CONDUCTOR")
    private Integer habilitarConductor;

    @Column(name = "HABILITAR_PASAJERO")
    private Integer habilitarPasajero;

    @Column(name = "ID_OLD")
    private Long idOld;

    @Column(name = "PERMITE_RECORRIDO")
    private Integer permiteRecorrido;

    @Column(name = "ID_USER_CREATION")
    private Long idUserCreation;

    @Column(name = "ID_USER_MODIFIED")
    private Long idUserModified;

    @Column(name = "ID_CATEGORIA_TRANSPORTE")
    private Long idCategoriaTransporte;

    @Column(name = "ID_GLOSA_AUXILIAR")
    private Long idGlosaAuxiliar;

    @Column(name = "ID_MEDIO_TRANSPORTE")
    private Long idMedioTransporte;

    @Column(name = "ID_MODALIDAD")
    private Long idModalidad;

    @Column(name = "ID_TIPO_SERVICIO_AREA")
    private Long idTipoServicioArea;

    @Column(name = "ID_TIPO_TRANSPORTE")
    private Long idTipoTransporte;

    @Column(name = "ID_TIPO_VEHICULO_SERVICIO")
    private Long idTipoVehiculoServicio;

    @Column(name = "PERMITE_INGRESO_VIG_PERIODO")
    private Integer permiteIngresoVigPeriodo;

    @Column(name = "PERMITE_OFICINA_VENTA")
    private Integer permiteOficinaVenta;

    @Column(name = "CONDUCTORES_POR_AMBOS")
    private Integer conductoresPorAmbos;

}
