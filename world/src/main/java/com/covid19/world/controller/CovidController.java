package com.covid19.world.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.covid19.world.response.DailyReportByCountry;
import com.covid19.world.response.LatestReportByCountry;
import com.covid19.world.response.LatestTotalsReport;

public interface CovidController {

	public List<DailyReportByCountry> dailyByCountry(@RequestParam String countryName, 
			@RequestParam String date);
	public List<LatestReportByCountry> latestByCountry(@RequestParam String countryName);
	public List<LatestTotalsReport> latestTotals();
}
