package com.mtt.rnt.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PROVINCIA")
public class Provincia {

    @Id
    @Column(name = "ID", nullable = false, columnDefinition = "char")
    private String codigo;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDREGION")
    private Region region;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "provincia")
    private List<Comuna> comunas;

}
