package fr.eni.pocSpringVote.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VotantEtranger extends Votant {

    private String nationalite;

    public VotantEtranger(String nom, String prenom, LocalDate ddn, String nationalite) {
        super(nom, prenom, ddn);
        this.nationalite = nationalite;
    }

    @Override
    public String toString() {
        return "VotantEtranger{" +
                "nationalite='" + nationalite + '\'' +
                "} " + super.toString();
    }
}
