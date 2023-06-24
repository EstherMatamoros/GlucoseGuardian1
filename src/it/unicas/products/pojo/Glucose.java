package it.unicas.products.pojo;

import java.sql.Timestamp;

public class Glucose {
	private Integer user_id;
	private Integer measurement;
	private String createdDate;
	private Timestamp timestamp;

	public Glucose() {
		// TODO Auto-generated constructor stub
	}

	public Glucose(Integer measurement, String createdDate) {
		super();
		this.measurement = measurement;
		this.createdDate = createdDate;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getMeasurement() {
		return measurement != null ? measurement : 0; // Return 0 if measurement is null
	}

	public void setMeasurement(Integer measurement) {
		this.measurement = measurement;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Glucose{" +
				"user_id=" + user_id +
				", measurement=" + measurement +
				", createdDate='" + createdDate + '\'' +
				", timestamp=" + timestamp +
				'}';
	}
}
