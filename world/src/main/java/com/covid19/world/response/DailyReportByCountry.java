package com.covid19.world.response;

import java.util.ArrayList;

public class DailyReportByCountry {

	private String country;
	private ArrayList<Provinces> provinces;
	private String Latitude;
	private String Longitude;
	private String Date;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public ArrayList<Provinces> getProvinces() {
		return provinces;
	}

	public void setProvinces(ArrayList<Provinces> provinces) {
		this.provinces = provinces;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

}
