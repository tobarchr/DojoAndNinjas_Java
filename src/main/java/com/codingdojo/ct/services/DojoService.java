package com.codingdojo.ct.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.ct.models.Dojo;
import com.codingdojo.ct.repositories.DojoRepository;

@Service
public class DojoService {
 	private final DojoRepository dojoRepository;
    
    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }
    // returns all the Dojos
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
    // creates a dojo
    public Dojo createDojo(Dojo b) {
        return dojoRepository.save(b);
    }
    
    // Updates a dojo
    public Dojo updateDojo(Dojo b) {
        return dojoRepository.save(b);
    }
    
    // retrieves a dojo
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalBook = dojoRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    //Deletes a dojo
    
	public void deleteLicense(long id) {
		dojoRepository.deleteById(id);
	  }
}



