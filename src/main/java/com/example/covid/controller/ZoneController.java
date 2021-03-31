package com.example.covid.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.covid.entity.Zone;
import com.example.covid.exception.ServiceException;
import com.example.covid.service.ZoneService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/zone")
public class ZoneController 
{
	@Autowired
	private ZoneService zoneService;
	
	@PostMapping("/addZone")
	public ResponseEntity<Integer> addZone(@RequestBody Map<String,String> map)
	{
		int id = 0;
		try 
		{
			id = zoneService.addZone(map);
			HttpHeaders header = new HttpHeaders();
			header.add("Description", "Adding zone success");
			return ResponseEntity.status(HttpStatus.OK).headers(header).body(id);
		} 
		catch (ServiceException e) 
		{
			id = -1;
			HttpHeaders header = new HttpHeaders();
			header.add("Description", "Adding zone failed");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(header).body(id);
		}
	}
	
	@PutMapping("/updateZone")
	public ResponseEntity<Integer> updateZone(@RequestBody Map<String,String> map)
	{
		int op = 0;
		try
		{
			op = zoneService.updateZone(map);
			if(op == -1)
			{
				HttpHeaders header = new HttpHeaders();
				header.add("Description", "Updating zone failed");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(op);
			}
			else
			{
				HttpHeaders header = new HttpHeaders();
				header.add("Description", "Updating zone success");
				return ResponseEntity.status(HttpStatus.OK).headers(header).body(op);
			}
		}
		catch(ServiceException e)
		{
			op = -2;
			HttpHeaders header = new HttpHeaders();
			header.add("Description", "Updating zone failed");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(header).body(op);
		}
	}
	
	@DeleteMapping("/deleteZone/{zoneId}")
	public ResponseEntity<Integer> deleteZone(@PathVariable int zoneId)
	{
		int op = 0;
		try
		{
			op = zoneService.deleteZone(zoneId);
			if(op == 1)
			{
				HttpHeaders header = new HttpHeaders();
				header.add("Description", "Deleting zone success");
				return ResponseEntity.status(HttpStatus.OK).headers(header).body(op);
			}
			else
			{
				HttpHeaders header = new HttpHeaders();
				header.add("Description", "Deleting zone failed");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(op);
			}
		}
		catch(ServiceException e)
		{
			op = -2;
			HttpHeaders header = new HttpHeaders();
			header.add("Description", "Updating zone failed");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(header).body(op);
		}
	}
	
	@GetMapping("/getZone/{zoneId}")
	public ResponseEntity<Zone> getZoneById(@PathVariable(value="zoneId") int zoneId)
	{
		Zone zone = new Zone();
		try
		{
			zone = zoneService.getZoneById(zoneId);
			HttpHeaders header = new HttpHeaders();
			header.add("Description", "Getting zone by ID success");
			return ResponseEntity.status(HttpStatus.OK).headers(header).body(zone);
		}
		catch(ServiceException e)
		{
			HttpHeaders header = new HttpHeaders();
			header.add("Description", "Getting zone by ID failed");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(null);
		}
	}
}
