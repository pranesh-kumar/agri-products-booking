package com.spring.agrimart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.agrimart.model.FertilizerModel;
import com.spring.agrimart.repository.FertilizerRepository;

@Service
public class FertilizerService {
	FertilizerRepository ob;
	public List<FertilizerModel> getAllDetails()
	{
		return ob.findAll();
	}

}
