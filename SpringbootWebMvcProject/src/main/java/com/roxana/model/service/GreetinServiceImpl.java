package com.roxana.model.service;

import org.springframework.stereotype.Service;

@Service
public class GreetinServiceImpl implements GreetingService {

	@Override
	public String evening() {
		return "Good evening!";
		
	}

	@Override
	public String morning() {
		return "Good morning!";
		
	}
	
	
	
	

}
