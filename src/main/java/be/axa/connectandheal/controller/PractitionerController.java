package be.axa.connectandheal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import be.axa.connectandheal.dao.PractitionerDao;
import be.axa.connectandheal.model.Doctor;


@RestController
public class PractitionerController {
	@Autowired
    private PractitionerDao practitionerDao;
     
    @GetMapping(path="/getPractitioner", produces = "application/json")
    public List<Doctor> getPractitioner(String latitude, String longitude, String radius, String specialization) 
    {
    	System.out.println("getPractitioner");
        return practitionerDao.getPractitioner( latitude,  longitude,  radius,  specialization);
    }
     
}