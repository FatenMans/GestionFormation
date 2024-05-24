package com.example.jwtauth.Entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String theme;
    private int nbrCandidat;
    private int nbrGroupes;
    private String nGroupe;
    private int duree;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private  String TypeTheme;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;

}


