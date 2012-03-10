package com.g7.rules;

import gps.api.GPSRule;
import gps.api.GPSState;
import gps.exception.NotAppliableException;

import com.g7.Jar;
import com.g7.JarsState;

public class DropTen implements GPSRule{

	@Override
	public GPSState evalRule(GPSState arg0) throws NotAppliableException {
		JarsState oldJS = (JarsState) arg0;
		Jar[] jars = oldJS.getJars();

		if ( jars[0].getUsed() == 0 ) {
			throw new NotAppliableException();
		}

		JarsState newJS = new JarsState(0, jars[1].getUsed(), jars[2].getUsed());

		return newJS;
	}

	@Override
	public Integer getCost() {
		return 1;
	}

	@Override
	public String getName() {
		return "Drop Ten";
	}

}
