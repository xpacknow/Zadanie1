package com.info.xpacknow.serviceImp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.info.xpacknow.service.TimeMeasureInterface;

public class TimeMeasure implements TimeMeasureInterface {


	public void preTime() {

	    String currentTime = getCurrentTime();

		System.out.println("Pomiar rozpoczęty : " + currentTime);

	}

	public void postTime() {

		String currentTime = getCurrentTime();

		System.out.println("Pomiar zakończony : " + currentTime);
	}

	
	

	private String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'o' hh:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());

	}

}
