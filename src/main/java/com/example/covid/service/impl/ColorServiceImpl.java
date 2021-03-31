package com.example.covid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.covid.entity.Color;
import com.example.covid.exception.DuplicateEntryException;
import com.example.covid.exception.ServiceException;
import com.example.covid.repository.ColorRepository;
import com.example.covid.service.ColorService;

@Service
public class ColorServiceImpl implements ColorService
{
	@Autowired
	private ColorRepository colorRepo;

	@Override
	public boolean addColor(Color color) throws ServiceException 
	{
		Color color1 = null;
		try
		{
			color1 = colorRepo.findByColorName(color.getColorName());
			if(color1 != null)
			{
				throw new DuplicateEntryException();
			}
			else
			{
				colorRepo.save(color);
				return true;
			}
		}
		catch(DuplicateEntryException e)
		{
			throw new ServiceException("Error! Color already exists.",e);
		}
		catch(Exception e)
		{
			throw new ServiceException("Error! Something went wrong.",e);
		}
	}

	@Override
	public List<Color> getAllColors() throws ServiceException 
	{
		try
		{
			return colorRepo.findAll();
		}
		catch(Exception e)
		{
			throw new ServiceException("Error! Something went wrong.",e);
		}
	}

}
