package com.bravi.bravitest.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bravi.bravitest.service.TimeService;


@Controller
public class TimeController {

	@Autowired
	private TimeService timeService;
	
	@GetMapping("/time")
	public ResponseEntity<String> convertTime(@RequestParam(value="time") String time){
		time = timeService.convertTime(time);
		return ResponseEntity.ok(time);
	}
	
}
