package com.example.jwtauth.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Formateur {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String nom;
    private String prenom;
    private String cin;
    private String matricule;
    private String tel;
    private String etatique_privé;
    private Integer montant;
    private Double moyenne;
    private Double rang;
    private String autorisation;
    private  String typeFormateur;


    @OneToMany(mappedBy = "formateur", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Theme> themes;
}
