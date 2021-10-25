package tn.esprit.spring;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/project/cars")
public class VoituresRestApi {
	
	@Autowired
	VoituresService voituresService;
	@Autowired
	VoituresRepository voituresRepository;

	@PostMapping(value="/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Voitures> addCar(@RequestBody Voitures voiture){
		return new ResponseEntity<>(voituresService.addVoitures(voiture),HttpStatus.OK);
	}
	@PutMapping(value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Voitures> updateCar(@RequestBody Voitures newcar,@PathVariable(value="id")int id){
		return new ResponseEntity<>(voituresService.updateVoiture(id, newcar),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteCar(@PathVariable(value="id")int id){
		return new ResponseEntity<>(voituresService.deleteCar(id),HttpStatus.OK);	
		}
	
	@GetMapping(value="/getallcars")
	@ResponseBody
	public ResponseEntity<List<Voitures>> getAllCars(){
		List<Voitures> voitures = voituresRepository.findAll();
		if (voitures.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else 
			return new ResponseEntity<>(voitures,HttpStatus.OK);
	}
	@GetMapping(value="/{marque}")
	@ResponseBody
	public Page<Voitures> getCar(@PathVariable(value="marque")String marque,Pageable pageable){
		return voituresRepository.voitureByMarque(marque, pageable);
	}
	
	@GetMapping(value="/{min}/{max}")
	@ResponseBody
	public Page<Voitures> getByPrice(@PathVariable(value="min")float min,@PathVariable(value="max")float max,Pageable pageable){
	return voituresRepository.voitureByRange(max, min, pageable);
	}
	
	//@GetMapping(value="/{dt}")
	//@ResponseBody
	//public Page<Voitures> getByDate(@PathVariable(value="dt")Date dt,Pageable pageable) {
	//return voituresRepository.voitureBydate(dt, pageable);
	//}
}
