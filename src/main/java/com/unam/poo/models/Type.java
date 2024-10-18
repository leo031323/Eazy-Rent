package com.unam.poo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tipo")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "type", length = 50)
    private String type;
}