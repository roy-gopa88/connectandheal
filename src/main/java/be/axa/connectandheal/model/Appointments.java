package be.axa.connectandheal.model;

import java.util.ArrayList;
import java.util.List;

public class Appointments {
	private List<Appointment> appointmentList;
    
    public List<Appointment> getAppointmentList() {
        if(appointmentList == null) {
        	appointmentList = new ArrayList<>();
        }
        return appointmentList;
    }
  
    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }
}
