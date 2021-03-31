package com.example.covid.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.covid.entity.Color;
import com.example.covid.entity.Zone;
import com.example.covid.exception.ServiceException;
import com.example.covid.exception.ZoneNotFoundException;
import com.example.covid.repository.ColorRepository;
import com.example.covid.repository.ZoneRepository;
import com.example.covid.service.ZoneService;

@Service
public class ZoneServiceImpl implements ZoneService
{
	@Autowired
	private ZoneRepository zoneRepo;
	
	@Autowired
	private ColorRepository colorRepo;

	@Override
	public int addZone(Map<String,String> map) throws ServiceException 
	{
		Zone zone = new Zone();
		try
		{
			zone.setZoneName(map.get("zoneName"));
			
			String population = map.get("zonePop");
			zone.setPopulation(Integer.valueOf(population));
			
			String colorName = map.get("colorName");
			Color color = colorRepo.findByColorName(colorName);
			zone.setColor(color);
			
			zoneRepo.save(zone);
			return zone.getZoneId();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ServiceException("Error! Something went wrong.",e);
		}
	}

	@Override
	public int updateZone(Map<String, String> map) throws ServiceException 
	{
		Zone zone = new Zone();
		int op = 0;
		int zoneId = 0;
		try
		{
			zoneId = Integer.parseInt(map.get("zoneId"));
			zone = zoneRepo.findById(zoneId).orElse(null);
			if(zone == null)
			{
				op = -1;
				throw new ZoneNotFoundException();
			}
			else
			{
				op = 1;
			}
			int zonePop = Integer.parseInt(map.get("zonePop"));
			String colorName = map.get("colorName");
			Color color = colorRepo.findByColorName(colorName);
			
			zone.setPopulation(zonePop);
			zone.setColor(color);
			
			zoneRepo.save(zone);
			return op;
		}
		catch(ZoneNotFoundException e)
		{
			return op;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ServiceException("Error! Something went wrong.",e);
		}
	}

	@Override
	public int deleteZone(int zoneId) throws ServiceException 
	{
		int op = 0;
		Zone zone = new Zone();
		zone = zoneRepo.findById(zoneId).orElse(null);
		if(zone == null)
		{
			op = -1;
			return op;
		}
		else
		{
			op = 1;
			try
			{
				zoneRepo.delete(zone);
				return op;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw new ServiceException("Error! Something went wrong.",e);
			}
		}
		
	}

	@Override
	public Zone getZoneById(int zoneId) throws ServiceException 
	{
		Zone zone = new Zone();
		try
		{
			zone = zoneRepo.findById(zoneId).orElse(null);
			int colorId = zone.getColor().getColorId();
			Color color = colorRepo.findById(colorId).orElse(null);
			zone.setColor(color);
			return zone;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ServiceException("Error! Something went wrong.",e);
		}
	}
	
}
