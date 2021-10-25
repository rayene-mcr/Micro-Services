package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoituresService {
	
	@Autowired
	public VoituresRepository voituresRepository;
	
	public Voitures addVoitures(Voitures voiture){
		return voituresRepository.save(voiture);
	}
	
	public Voitures updateVoiture(int id,Voitures newCar){
		if(voituresRepository.findById(id).isPresent()){
			Voitures existingCar = voituresRepository.findById(id).get();
			existingCar.setMarque(newCar.getMarque());
			existingCar.setAnnee(newCar.getAnnee());
			existingCar.setCarburant(newCar.getCarburant());
			existingCar.setCylindree(newCar.getCylindree());
			existingCar.setDescription(newCar.getDescription());
			existingCar.setImmatriculation(newCar.getImmatriculation());
			existingCar.setKilometrage(newCar.getKilometrage());
			existingCar.setPrix(newCar.getPrix());
			existingCar.setPuissance(newCar.getPuissance());
			existingCar.setQuantite(newCar.getQuantite());
			return voituresRepository.save(newCar);
		} else return null;
	}
	public String deleteCar(int id){
		if (voituresRepository.findById(id).isPresent()){
			 voituresRepository.deleteById(id);
			 return "Car is deleted";
		} else 
			return "There was a problem treating this request";
			
	}

}
