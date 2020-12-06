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
        List<Doctor> doctorsList = new ArrayList<Doctor>();
        try (FileReader reader = new FileReader(new File("").getAbsolutePath() +"//src//main//resources//doctors.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            doctorList = (JSONArray) obj;
            System.out.println(doctorList);
             
            //Iterate over employee array
            //doctorList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
            for (Object object : doctorList) {
				String latitudeVal = (String)((JSONObject) object).get("latitude");
				String longitudeVal = (String)((JSONObject) object).get("longitude");
				String keywordVal = (String)((JSONObject) object).get("keyword");
				String radiusVal = (String)((JSONObject) object).get("radius");
				
				if(latitude.equals(latitudeVal) && longitudeVal.equals(longitude) && specialization.equals(keywordVal) && radius.equals(radiusVal)) {
					Doctor doctor = new Doctor();
					doctor.setFirstName((String)((JSONObject) object).get("firstName"));
					doctor.setLastName((String)((JSONObject) object).get("lastName"));
					doctor.setId((String)((JSONObject) object).get("id"));
					doctor.setIdCard((String)((JSONObject) object).get("idCard"));
					doctorsList.add(doctor);
				}
			}
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    	
		return doctorsList;

    }
    
     
}