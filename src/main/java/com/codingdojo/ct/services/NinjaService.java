package com.codingdojo.ct.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.ct.models.Ninja;
import com.codingdojo.ct.repositories.NinjaRepository;

@Service
public class NinjaService {
private final NinjaRepository ninjaRepository;
    
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
    // returns all the Ninjas
    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }
    // creates a ninjas
    public Ninja createNinja(Ninja b) {
        return ninjaRepository.save(b);
    }
    
    // Updates a ninja
    public Ninja updateNinja(Ninja b) {
        return ninjaRepository.save(b);
    }
    
    // retrieves a ninja
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalBook = ninjaRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    //Deletes a Ninja
    
	public void deleteNinja(long id) {
		ninjaRepository.deleteById(id);
	  }
}
