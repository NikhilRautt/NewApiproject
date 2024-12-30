package com.atmsite_approval.service;

import com.atmsite_approval.entity.Atmsite;
import com.atmsite_approval.repository.AtmRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtmService {

    private static AtmRepository atmRepository;
    public AtmService(AtmRepository atmRepository) {
        this.atmRepository = atmRepository;
    }

    public  String saveUser(String frId) {

        Optional<Atmsite> existingAtmSite = atmRepository.findByFrId(frId);

        if (existingAtmSite.isPresent()) {
            // If frId exists, return a message indicating it's a duplicate
            return "frId already exists, cannot insert duplicate.";
}
            //    Atmsite atmntity = new Atmsite();
        Atmsite atmsite = new Atmsite();

            atmsite.setFrId((frId));

            Atmsite saved = atmRepository.save(atmsite);
            System.out.println("saved:" + saved);
            return "user saved successfully";
    }

    public String updateAtm(String frId, String frLat,String frlong, String isatmnear,String isAtmSuccessful){
        Optional<Atmsite> existingAtmSite = atmRepository.findByFrId(frId);

        if(existingAtmSite.isPresent()){
            Atmsite atm = existingAtmSite.get();
            atm.setFrlat(frLat);
            atm.setFrlong(frlong);
            atm.setIsatmnear(isatmnear);
            atm.setIsatmsuccessfull(isAtmSuccessful);
            Atmsite saved = atmRepository.save(atm);
            return "Atm updated successfully";
        }
        return "Atm not found";
    }

}
