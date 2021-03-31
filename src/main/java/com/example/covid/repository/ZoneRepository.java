package com.example.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.covid.entity.Zone;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Integer>
{

}
