package be.axa.connectandheal.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;
import be.axa.connectandheal.model.Doctor;

@Repository
public class PractitionerDao {
	
    public List<Doctor> getPractitioner(String latitude, String longitude, String radius, String specialization) 
    {
    	
    	//JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        JSONArray doctorList = null;
        try (FileReader reader = new FileReader(new File("").getAbsolutePath() +"//src//main//resources//doctors.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            doctorList = (JSONArray) obj;
            System.out.println(doctorList);
             
            //Iterate over employee array
            doctorList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    	
		return doctorList;

    }
    
    private Doctor parseEmployeeObject(JSONObject employee) 
    {
    	Doctor doctor = new Doctor();
        String id = (String) employee.get("id");    
        doctor.setId(id);
         
        String firstName = (String) employee.get("firstName");  
        doctor.setFirstName(firstName);;
         
        String lastName = (String) employee.get("lastName");    
        doctor.setLastName(lastName);
        
        String idCard = (String) employee.get("idCard");    
        doctor.setIdCard(idCard);
		return doctor;
        
        
    }
     
}