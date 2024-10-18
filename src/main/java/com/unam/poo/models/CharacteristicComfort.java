package com.unam.poo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "characteristic_comfort", schema = "public", catalog = "playground")

public class CharacteristicComfort {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_characteristic")
    private Integer idCharacteristic;
    @Basic
    @Column(name = "characteristic_name")
    private String characteristicName;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_comfort", nullable = false)
    private Comfort idComfort;


}
