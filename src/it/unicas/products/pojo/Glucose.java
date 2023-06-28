package it.unicas.products.pojo;

import java.sql.Timestamp;

public class Glucose {
	private Integer measurement;
	private String createdDate;

	private Integer user_id;

	private Timestamp timestamp;
	private Integer id;


	public Glucose() {
		// TODO Auto-generated constructor stub
	}

	public Glucose(Integer measurement, String createdDate) {
		super();
		this.measurement = measurement;
		this.createdDate = createdDate;
	}

	public Integer getMeasurement() {
		return measurement;
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

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Glucose{" +
				"measurement=" + measurement +
				", createdDate='" + createdDate + '\'' +
				", user_id=" + user_id +
				", timestamp=" + timestamp +
				", id=" + id +
				'}';
	}
}
