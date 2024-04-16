package com.mtt.rnt.entities.utilsDB;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "TIPOVEHICULO", schema = "NULLID")
public class TipoVehiculo {

    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

}
