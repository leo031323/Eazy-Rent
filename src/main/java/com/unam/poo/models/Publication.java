package com.unam.poo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "publication")

public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publication", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "state_publication", length = 20)
    private String statePublication = "active";
    @Basic
    @Column(name = "date_time_publication")
    private LocalDateTime DateTimePublication = LocalDateTime.now();
    @Basic
    @NotBlank(message = "The Street field is required")
    @Column(name = "street_publication", length = 100)
    private String streetPublication;
    //    @NotBlank(message = "The Height field is required")
    @Basic
    @Column(name = "height_publicacion")
    private Integer heightPublication;
    //    @NotBlank(message = "The Bedrooms field is required")
    @Basic
    @Column(name = "bedrooms_publication")
    private Integer bedroomsPublication;
    //    @NotBlank(message = "The Bathrooms field is required")
    @Basic
    @Column(name = "baths_publication")
    private Integer bathsPublication;
    //    @NotBlank(message = "The Garages field is required")
    @Basic
    @Column(name = "garage_publication")
    private Integer garagePublication;
    //    @NotBlank(message = "The Environments field is mandatory")
    @Basic
    @Column(name = "environments_publication")
    private Integer environmentsPublication;

    //    @NotBlank(message = "The Covered Area field is required")
    @Basic
    @Column(name = "surface_deck_home")
    private Double surfaceDeckHome;

    //    @NotBlank(message = "The Total Area field is required")
    @Basic
    @Column(name = "surface_total_land")
    private Double surfaceToalLand;
    //    @NotBlank(message = "The Price field is required")
    @Basic
    @Column(name = "price_publication")
    private Double pricePublication;
    @Basic
    @Column(name = "qualification_publication")
    private String qualificationPublication;
    @Basic
    @Column(name = "description_publication", length = 500)
    private String descriptionPublication;

//   create longitude and latitude for location on map
    @Basic
    @Column(name = "length_publication")
    private Double lengthPublication;

    @Basic
    @Column(name = "latitude_publication")
    private Double latitudePublication;

//    image may be optional
    @Basic
    @Column(name = "image1")
    private String image1;

//    validate the idType
//    @NotEmpty(groups = {Publication.class}, message = "The Type field is required")
    @NotNull(message = "The type field is mandatory")
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_type", nullable = false)
    private Type idType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_city", nullable = false)
    private City idCity;


    @ManyToMany
    @JoinTable(name = "publication_has_feature",
            joinColumns = @JoinColumn(name = "id_publication"),
            inverseJoinColumns = @JoinColumn(name = "id_feature"))
    private List<FeatureComfort> caracteristicasComodidades;

//    list de images
    @OneToMany(mappedBy = "idPublication", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhotoPublication> imagenes;
}