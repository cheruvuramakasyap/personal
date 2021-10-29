package com.covid19.world.service;

import java.util.List;

import com.covid19.world.response.DailyReportByCountry;
import com.covid19.world.response.LatestReportByCountry;
import com.covid19.world.response.LatestTotalsReport;

public interface CovidService {

	public List<DailyReportByCountry> dailyByCountry(String countryName, String date) throws Exception;

	public List<LatestReportByCountry> latestByCountry(String countryName);

	public List<LatestTotalsReport> latestTotals();
}
