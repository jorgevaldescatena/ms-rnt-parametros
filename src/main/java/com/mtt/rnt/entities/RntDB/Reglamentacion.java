package com.mtt.rnt.entities.RntDB;

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
@Table(name = "RNT_REGLAMENTACION", schema = "NULLID")
public class Reglamentacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATION")
    private Date creation;

    @Column(name = "MODIFIED")
    private Date modified;

    @Column(name = "APLICA_VEHICULOS")
    private String aplicaVehiculos;

    @Column(name = "ESPECIFICADO_SOBRE_EXISTENTE")
    private Integer especificadoSobreExistente;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "LINK_DOCUMENTO")
    private String linkDocumento;

    @Column(name = "MATERIA")
    private String materia;

    @Column(name = "MOTIVO_CAMBIO")
    private String motivoCambio;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "NOMBRE_DOCUMENTO")
    private String nombreDocumento;

    @Column(name = "VIGENCIA_DESDE")
    private Date vigenciaDesde;

    @Column(name = "VIGENCIA_HASTA")
    private Date vigenciaHasta;

    @Column(name = "VISIBLE_ENCARGADO")
    private Integer visibleEncargado;

    @Column(name = "SELECCIONABLE_VEHICULO")
    private Integer seleccionableVehiculo;

    @Column(name = "SELECCIONABLE_SERVICIO")
    private Integer seleccionableServicio;

    @Column(name = "ID_USER_CREATION")
    private Long idUserCreation;

    @Column(name = "ID_USER_MODIFIED")
    private Long idUserModified;

    @Column(name = "ID_MARCO_GEOGRAFICO")
    private Long idMarcoGeografico;

    @Column(name = "ID_REGLAMENTACION_DE_QUE_DEPENDE")
    private Long idReglamentacionDeQueDepende;

    @Column(name = "ID_TIPO_DOCUMENTO")
    private Long idTipoDocumento;

    @Column(name = "ID_TIPO_REGLAMENTACION")
    private Long idTipoReglamentacion;

    @Column(name = "ID_DOCUMENTO_BIBLIOTECA")
    private Long idDocumentoBiblioteca;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "ID_GLOSA_VEHICULO")
    private Long idGlosaVehiculo;

    @Column(name = "ID_GLOSA_CERTIFICADO")
    private Long idGlosaCertificado;

}
