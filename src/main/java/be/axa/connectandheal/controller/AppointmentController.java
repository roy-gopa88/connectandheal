package be.axa.connectandheal.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import be.axa.connectandheal.dao.AppointmentDao;
import be.axa.connectandheal.model.Appointment;
import be.axa.connectandheal.model.Appointments;

@RestController
public class AppointmentController {
	@Autowired
    private AppointmentDao appointmentDao;
     
    @GetMapping(path="/getAppointments", produces = "application/json")
    public Appointments getAppointments() 
    {
    	System.out.println("getAppointments");
        return appointmentDao.getAllAppointments();
    }
     
    @PostMapping(path= "/saveAppointment", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addAppointment(@RequestBody Appointment appointment) 
    {
    	System.out.println("addAppointment");
        Integer id = appointmentDao.getAllAppointments().getAppointmentList().size() + 1;
        appointment.setUserId(id);
         
        appointmentDao.addAppointments(appointment);
         
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(appointment.getUserId())
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }
}
