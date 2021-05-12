package com.bravi.bravitest.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bravi.bravitest.service.TimeService;


@Controller
public class TimeController {

	@Autowired
	private TimeService timeService;
	
	@RequestMapping(value = "/time", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> convertTime(@RequestParam(value="time") String time,
											  @RequestParam(value="format") Boolean format) throws Exception{
		time = timeService.convertTime(time, format);
		return new ResponseEntity<String>(time, HttpStatus.OK);
	}
	
}
