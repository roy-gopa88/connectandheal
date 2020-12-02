package be.axa.connectandheal.dao;

import org.springframework.stereotype.Repository;

import be.axa.connectandheal.model.Appointment;
import be.axa.connectandheal.model.Appointments;

@Repository
public class AppointmentDao {
	private static Appointments list = new Appointments();
    
    static
    {
        list.getAppointmentList().add(new Appointment(1, 111, "groy@gmail.com", "12-Dec-2020", "Dentist"));
        list.getAppointmentList().add(new Appointment(2, 222, "abc@gmail.com", "11-Dec-2020", "Physician"));
        list.getAppointmentList().add(new Appointment(3, 333, "ss@gmail.com", "10-Dec-2020", "Dietician"));
    }
     
    public Appointments getAllAppointments() 
    {
        return list;
    }
     
    public void addAppointments(Appointment appointment) {
        list.getAppointmentList().add(appointment);
    }
}