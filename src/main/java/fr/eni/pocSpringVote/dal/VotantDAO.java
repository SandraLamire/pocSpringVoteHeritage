package fr.eni.pocSpringVote.dal;

import fr.eni.pocSpringVote.entity.Votant;
import fr.eni.pocSpringVote.entity.VotantEtranger;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VotantDAO extends CrudRepository<Votant, Integer> {
    @Query("SELECT ve FROM VotantEtranger ve")
    List<VotantEtranger> findAllVotantsEtrangers();
}
