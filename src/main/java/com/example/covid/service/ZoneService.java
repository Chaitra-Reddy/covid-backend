package com.example.covid.service;

import java.util.Map;

import com.example.covid.entity.Zone;
import com.example.covid.exception.ServiceException;

public interface ZoneService 
{
	public int addZone(Map<String,String> map) throws ServiceException;
	public int updateZone(Map<String,String> map) throws ServiceException;
	public int deleteZone(int zoneId) throws ServiceException;
	public Zone getZoneById(int zoneId) throws ServiceException;
}
