package com.bravi.bravitest.service;

import org.springframework.stereotype.Service;

@Service
public interface TimeService {

	public String convertTime(String time) throws Exception;
}
