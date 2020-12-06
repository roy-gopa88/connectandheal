package be.axa.connectandheal.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import be.axa.connectandheal.model.Doctor;

@Repository
public class PractitionerDao {
	
    public List<Doctor> getPractitioner(String latitude, String longitude, String radius, String specialization) 
    {
    	List<Doctor> doctorList = new ArrayList<Doctor>();
    	Doctor doctor = new Doctor();
    	doctor.setFirstName("AAA");
    	doctor.setId("1");
    	doctor.setIdCard("QBC012");
    	doctor.setLastName("BBB");
    	doctorList.add(doctor);
		return doctorList;

    	
    	
    }
     
}