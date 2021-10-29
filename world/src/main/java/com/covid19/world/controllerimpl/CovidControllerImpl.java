package com.covid19.world.controllerimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.covid19.world.controller.CovidController;
import com.covid19.world.response.DailyReportByCountry;
import com.covid19.world.response.LatestReportByCountry;
import com.covid19.world.response.LatestTotalsReport;
import com.covid19.world.serviceimpl.CovidServiceImpl;

@RestController
@RequestMapping("/api")
public class CovidControllerImpl implements CovidController{

	@Autowired
	CovidServiceImpl covidService;

	@Override
	@PostMapping("/dailyByCountry")
	public List<DailyReportByCountry> dailyByCountry(@RequestParam String countryName, 
			@RequestParam String date) {

		try {
			return covidService.dailyByCountry(countryName,date);
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	@PostMapping("/latestByCountry")
	public List<LatestReportByCountry> latestByCountry(@RequestParam String countryName) {

		try {
			return covidService.latestByCountry(countryName);
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	@GetMapping("/latestTotals")
	public List<LatestTotalsReport> latestTotals() {

		try {
			return covidService.latestTotals();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
