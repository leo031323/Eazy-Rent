package com.unam.poo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "feature_comfort", schema = "public", catalog = "playground")

public class FeatureComfort {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_feature")
    private Integer idFeature;
    @Basic
    @Column(name = "feature_name")
    private String featureName;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_comfort", nullable = false)
    private Comodidad idComfort;


}
