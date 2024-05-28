package fr.eni.pocSpringVote.entity;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Inheritance
public class Votant {
    @Id
    @GeneratedValue
    private Integer idVotant;
    private String nom;
    private String prenom;
    private LocalDate ddn;

    // A remplacer par relationnel
    // private String candidat;

    // Un candidat a plusieurs votants
    @ManyToOne
    private Candidat candidat;

    @ManyToOne
    private Bureau bureau;

    // Attribut virtuel
    public Integer getAge() {
        return Period.between(ddn, LocalDate.now()).getYears();
    }

    public Votant(String nom, String prenom, LocalDate ddn) {
        super();
        this.nom = nom;
        this.prenom = prenom;
    }
}
