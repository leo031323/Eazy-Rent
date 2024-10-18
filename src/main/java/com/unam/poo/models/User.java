package com.unam.poo.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.unam.poo.security.modelo.Role;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
//import org.hibernate.validator.constraints.NotBlank;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "mail")
    @NotBlank(message = "Mail can not be empty")
    private String mail;

    @Basic
    @Column(name = "telephone")
    @NotBlank(message = "The phone cannot be empty")
    private String telephone;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "dni")
    @NotNull
    private Long dni;   

    @Basic
    @Column(name = "name")
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Basic
    @Column(name = "last_name")
    @NotBlank(message = "The last name cannot be empty")
    private String lastName;

    @Basic
    @Column(name = "password")
    @NotBlank(message = "Password cannot be empty")
    private String password;

    /* For low logic */
    private Boolean active = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<Role> roles = new HashSet<>();

    @ManyToOne()
    @JoinColumn(name = "city_id")
    @JsonBackReference
    //@NotBlank(message = "The city cannot be empty")
    private City city;

//    add to favorites
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_publication", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_publication"))
    @JsonManagedReference
    private Set<Publication> favorites = new HashSet<>();

    @OneToOne(mappedBy = "user")
    private Mail post;

    @OneToOne(mappedBy = "user")
    private Photo photo;

}