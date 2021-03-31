package com.example.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.example.covid.entity.Color;
import com.example.covid.exception.ServiceException;
import com.example.covid.service.ColorService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/color")
public class ColorController 
{
	@Autowired
	private ColorService colorService;
	
	@PostMapping("/addColor")
	public ResponseEntity<Boolean> addColor(@RequestBody Color color)
	{
		boolean op = false;
		try 
		{
			op = colorService.addColor(color);
			HttpHeaders header = new HttpHeaders();
			header.add("Description", "Adding color success");
			return ResponseEntity.status(HttpStatus.OK).headers(header).body(op);
		} 
		catch (ServiceException e) 
		{
			op = false;
			HttpHeaders header = new HttpHeaders();
			header.add("Description", "Adding color failed");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(op);
		}
	}
	
	@GetMapping("/getAllColors")
	public ResponseEntity<List<Color>> getAllColors()
	{
		List<Color> colors = null;
		try 
		{
			colors = colorService.getAllColors();
			HttpHeaders header = new HttpHeaders();
			header.add("Description", "Getting all colors success");
			return ResponseEntity.status(HttpStatus.OK).headers(header).body(colors);
		} 
		catch (ServiceException e) 
		{
			colors = null;
			HttpHeaders header = new HttpHeaders();
			header.add("Description", "Getting all colors failed");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(colors);
		}
	}
}
