package fr.eni.pocSpringVote;

import fr.eni.pocSpringVote.dal.VotantDAO;
import fr.eni.pocSpringVote.entity.VotantEtranger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.pocSpringVote.entity.Votant;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@SpringBootApplication
@AllArgsConstructor
public class PocSpringVoteApplication implements CommandLineRunner {

	@Autowired
	VotantDAO dao;
	
	public static void main(String[] args) {
		SpringApplication.run(PocSpringVoteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dao.save(new Votant("Simon", "Menfout", (LocalDate.now().minusYears(21))));
		dao.save(new Votant("Michelle", "Porc", (LocalDate.now().minusYears(19))));
		dao.save(new VotantEtranger("Memelle", "Isham", (LocalDate.now().minusYears(19)), "Marocain"));

		System.out.println("Liste des votants :");
		dao.findAll().forEach(System.out::println);

		System.out.println("Liste des votants étrangers :");
		dao.findAllVotantsEtrangers().forEach(System.out::println);
	}

}
