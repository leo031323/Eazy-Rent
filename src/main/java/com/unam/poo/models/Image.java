package com.unam.poo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_image")
    private Integer idImage;

    @Basic
    @Column(name = "url_image")
    private String urlImage;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_publication", nullable = false)
    private Publication idPublication;
}
