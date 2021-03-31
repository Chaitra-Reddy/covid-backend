package com.example.covid.service;

import java.util.List;

import com.example.covid.entity.Color;
import com.example.covid.exception.ServiceException;

public interface ColorService 
{
	public boolean addColor(Color color) throws ServiceException;
	public List<Color> getAllColors() throws ServiceException;
}
