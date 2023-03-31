package com.weatherforecast.service;

import org.springframework.http.ResponseEntity;

public interface RapidApiService {
	

	public ResponseEntity<String> RapidApiGetForecastSummaryByLocationName(String name);
	
	public ResponseEntity<String> RapidApiGetHourlyForecastByLocationName(String Name);
	
	
//	public ResponseEntity<String> makeApiRequest(String name);

}
