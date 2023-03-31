package com.weatherforecast.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RapidApiServiceImpl implements RapidApiService {
	
	
	@Autowired
	private RestTemplate restTemplate;



	@Override
	public ResponseEntity<String> RapidApiGetForecastSummaryByLocationName(String name) {
		String baseurl = "https://forecast9.p.rapidapi.com/rapidapi/forecast/{name}/summary/";
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-RapidAPI-Host", "forecast9.p.rapidapi.com");
		headers.set("X-RapidAPI-Key", "08cfedb55dmshe52a7681a390f1ep12d1d1jsnf907489c6c45");

		Map<String, String> urlParams = new HashMap<>();
		urlParams.put("name", name);
		HttpEntity<?> entity = new HttpEntity<>(headers);

		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseurl);

		System.out.println(builder.buildAndExpand(urlParams).toUri());


		return restTemplate.exchange(builder.buildAndExpand(urlParams).toUri(), HttpMethod.GET, entity, String.class);
	}

	@Override
	public ResponseEntity<String> RapidApiGetHourlyForecastByLocationName(String name) {
		String baseurl = "https://forecast9.p.rapidapi.com/rapidapi/forecast/{name}/hourly/";
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-RapidAPI-Host", "forecast9.p.rapidapi.com");
		headers.set("X-RapidAPI-Key", "08cfedb55dmshe52a7681a390f1ep12d1d1jsnf907489c6c45");

		Map<String, String> urlParams = new HashMap<>();
		urlParams.put("name", name);
		HttpEntity<?> entity = new HttpEntity<>(headers);

		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseurl);

		System.out.println(builder.buildAndExpand(urlParams).toUri());

		

		return restTemplate.exchange(builder.buildAndExpand(urlParams).toUri(), HttpMethod.GET, entity, String.class);
		
	}
	
	
	
	
//	public ResponseEntity<String> makeApiRequest(String name) {
//
//		String baseurl = "https://forecast9.p.rapidapi.com/rapidapi/forecast/{name}/summary/";
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("X-RapidAPI-Host", "forecast9.p.rapidapi.com");
//		headers.set("X-RapidAPI-Key", "924a1345a0msh8426929db40350ap106533jsnfc1bf8fe1af7");
//
//		Map<String, String> urlParams = new HashMap<>();
//		urlParams.put("name", name);
//		HttpEntity<?> entity = new HttpEntity<>(headers);
//
//		
//		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseurl).path("/{name}").path("/summary/");
//
//		System.out.println(builder.buildAndExpand(urlParams).toUri());
//
//		// String user =
//		// restTemplate.getForObject(builder.buildAndExpand(urlParams).toUri(),
//		// String.class);
//
//		return restTemplate.exchange(builder.buildAndExpand(urlParams).toUri(), HttpMethod.GET, entity, String.class);
//
//	}

}
