package com.covid19.world.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.covid19.world.response.DailyReportByCountry;
import com.covid19.world.response.LatestReportByCountry;
import com.covid19.world.response.LatestTotalsReport;
import com.covid19.world.service.CovidService;

@Service
public class CovidServiceImpl implements CovidService{
	
	@Autowired
	Environment env;

	@Override
	public List<DailyReportByCountry> dailyByCountry(String countryName, String date) throws Exception {

		HttpHeaders headers = new HttpHeaders();

		headers.set("X-RapidAPI-Host","covid-19-data.p.rapidapi.com");
		headers.set("X-RapidAPI-Key", env.getProperty("rapidApiKey"));
		HttpEntity request = new HttpEntity(headers);
		String url = "https://covid-19-data.p.rapidapi.com/report/country/name?name="+countryName+"&date="+date;
		
		//Date sendDate = new SimpleDateFormat("YYYY-MM-DD").parse(date);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<DailyReportByCountry>> response = restTemplate.exchange(url,HttpMethod.GET,request,new ParameterizedTypeReference<List<DailyReportByCountry>>() {});
		return response.getBody();
	}

	@Override
	public List<LatestReportByCountry> latestByCountry(String countryName) {
		
		HttpHeaders headers = new HttpHeaders();

		headers.set("X-RapidAPI-Host","covid-19-data.p.rapidapi.com");
		headers.set("X-RapidAPI-Key", env.getProperty("rapidApiKey"));
		HttpEntity request = new HttpEntity(headers);
		String url = "https://covid-19-data.p.rapidapi.com/country?name="+countryName;
		
		//Date sendDate = new SimpleDateFormat("YYYY-MM-DD").parse(date);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<LatestReportByCountry>> response = restTemplate.exchange(url,HttpMethod.GET,request,new ParameterizedTypeReference<List<LatestReportByCountry>>() {});
		return response.getBody();
	}

	@Override
	public List<LatestTotalsReport> latestTotals() {
		
		HttpHeaders headers = new HttpHeaders();

		headers.set("X-RapidAPI-Host","covid-19-data.p.rapidapi.com");
		headers.set("X-RapidAPI-Key", env.getProperty("rapidApiKey"));
		HttpEntity request = new HttpEntity(headers);
		String url = "https://covid-19-data.p.rapidapi.com/totals";
		
		//Date sendDate = new SimpleDateFormat("YYYY-MM-DD").parse(date);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<LatestTotalsReport>> response = restTemplate.exchange(url,HttpMethod.GET,request,new ParameterizedTypeReference<List<LatestTotalsReport>>() {});
		return response.getBody();
	}

}
