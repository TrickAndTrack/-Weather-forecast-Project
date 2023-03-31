package com.weatherforecast.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.*;

import com.weatherforecast.service.RapidApiServiceImpl;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private RapidApiServiceImpl rapidApiService;


	@GetMapping("/{name}")
    public ResponseEntity<String> GetForecastSummaryByLocationName(@PathVariable("name") String name) {
    	try {
        return rapidApiService.RapidApiGetForecastSummaryByLocationName(name);
        
    	} catch (HttpClientErrorException ex) {
           
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
          } catch (HttpServerErrorException ex) {
           
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
          } catch (Exception ex) {
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
          }
    }
	
	@GetMapping("/hourly/{name}")
    public ResponseEntity<String> GetHourlyForecastByLocationName(@PathVariable("name") String name) {
    	try {
        return rapidApiService.RapidApiGetHourlyForecastByLocationName(name);
        
    	} catch (HttpClientErrorException ex) {
            // Handle 4xx client errors
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
          } catch (HttpServerErrorException ex) {
            // Handle 5xx server errors
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
          } catch (Exception ex) {
            // Handle other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
          }
    }
	
	
//	@GetMapping("/location/{name}")
//  public ResponseEntity<String> getData(@PathVariable("name") String name) {
//  	try {
//      return rapidApiService.makeApiRequest(name);
//      
//  	} catch (HttpClientErrorException ex) {
//         
//          return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
//        } catch (HttpServerErrorException ex) {
//          
//          return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
//        } catch (Exception ex) {
//         
//          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
//        }
//  }
	
    

}
