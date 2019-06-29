package org.ang;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="notification")
public class Notification {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private Calendar notificationDay;
	
	@OneToOne
	private Bill bill;

	public Calendar getNotificationDay() {
		return notificationDay;
	}

	public void setNotificationDay(Calendar notificationDay) {
		this.notificationDay = notificationDay;
	}
	
	
}
