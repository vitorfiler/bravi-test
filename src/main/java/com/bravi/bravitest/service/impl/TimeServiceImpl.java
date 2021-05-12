package com.bravi.bravitest.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.bravi.bravitest.service.TimeService;

@Component("TimeController")
public class TimeServiceImpl implements TimeService{
	private static final String[] numNames = {
			"",
		    " one",
		    " two",
		    " three",
		    " four",
		    " five",
		    " six",
		    " seven",
		    " eight",
		    " nine",
		    " ten",
		    " eleven",
		    " twelve",
		    " thirteen",
		    " fourteen",
		    " fifteen",
		    " sixteen",
		    " seventeen",
		    " eighteen",
		    " nineteen",
		    " twenty",
		    " twenty-one",
		    " twenty-two",
		    " twenty-three",
		    " twenty-four",
		    " twenty-five",
		    " twenty-six",
		    " twenty-seven",
		    " twenty-eight",
		    " twenty-nine",
		    " thirty",
		    " thirty-one",
		    " thirty-two",
		    " thirty-three",
		    " thirty-four",
		    " thirty-five",
		    " thirty-six",
		    " thirty-seven",
		    " thirty-eight",
		    " thirty-nine",
		    " forty",
		    " forty-one",
		    " forty-two",
		    " forty-three",
		    " forty-four",
		    " forty-five",
		    " forty-six",
		    " forty-seven",
		    " forty-eight",
		    " forty-nine",
		    " fifty",
		    " fifty-one",
		    " fifty-two",
		    " fifty-three",
		    " fifty-four",
		    " fifty-five",
		    " fifty-six",
		    " fifty-seven",
		    " fifty-eight",
		    " fifty-nine",
	};
	
	private static final String OCLOCK = " o' clock ";
	private static final String PAST = "past ";
	private static final String TO = "to ";
	
	 
	public String convertTime(String time, Boolean format) throws Exception {
		
		try {			
			String[] splitTime = time.split(":");
			int hour = Integer.parseInt(splitTime[0]);
			int minute = Integer.parseInt(splitTime[1]);
		
		
		return validateSentence(hour, minute, time);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	private String validateSentence(int hour, int minute, String hourComplete) {

		if(minute>59 || hour>23)return "invalid hour";
		String minutes = (60 - minute) >1? " minutes ": " minute ";
		String sentence = minute == 0 ? numNames[hour]+ OCLOCK : minute >= 1 && minute <= 30 ? numNames[minute]+ minutes + PAST + numNames[hour] : numNames[60 - minute]+ minutes + TO + numNames[hour+1];
		if(minute == 15 || minute == 45 || minute == 30) {			
			sentence = minute == 15 ? " quarter " + PAST + numNames[hour] : minute == 45 ? " quarter " + TO + numNames[hour+1] : " half " + PAST + numNames[hour];	
		}

		return hourComplete + " ->" + sentence;
	}
}
