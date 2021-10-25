package tn.esprit.spring;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VoituresRepository extends JpaRepository<Voitures,Integer> {
	
	@Query("select v from Voitures v where v.marque like :marque OR  v.prenom like :marque OR v.adresse like :marque OR v.nom like :marque OR v.carburant like :marque")
	public Page<Voitures> voitureByMarque(@Param("marque")String m,Pageable pageable);
	
	@Query("select v from Voitures v where v.prix >= :min AND v.prix <= :max")
	public Page<Voitures> voitureByRange(@Param("min")float m,@Param("max")float x,Pageable pageable);
	
	//@Query("select v from Voitures v where v.du <= dt AND v.à >= dt ")
	//public Page<Voitures> voitureBydate(@Param("dt")Date dt,Pageable pageable);
	
}
