package be.axa.connectandheal.model;

import lombok.Data;

@Data
public class Appointment {
	
	private Integer doctorId;
	private Integer userId;
	private String userEmail;
	private String dateTime;
	private String summary;
	
	public Appointment(int doctorId, int userId, String userEmail, String dateTime, String summary) {
		this.doctorId = doctorId;
		this.userId = userId;
		this.userEmail = userEmail;
		this.dateTime = dateTime;
		this.summary = summary;
	}
}
