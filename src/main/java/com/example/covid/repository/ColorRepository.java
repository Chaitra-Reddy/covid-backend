package com.example.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.covid.entity.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Integer>
{
	Color findByColorName(String colorName);
}
