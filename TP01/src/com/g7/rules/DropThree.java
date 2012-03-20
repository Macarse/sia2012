package com.g7.rules;

import gps.api.GPSRule;
import gps.api.GPSState;
import gps.exception.NotAppliableException;

import com.g7.Jar;
import com.g7.JarsState;

public class DropThree implements GPSRule{

	@Override
	public GPSState evalRule(GPSState arg0) throws NotAppliableException {
		JarsState oldJS = (JarsState) arg0;
		Jar[] jars = oldJS.getJars();

		if ( jars[2].getUsed() == 0 ) {
			throw new NotAppliableException();
		}

		JarsState newJS = new JarsState(jars[0].getUsed(), jars[1].getUsed(), 0);

		return newJS;
	}

	@Override
	public float getCost() {
		return 1;
	}

	@Override
	public String getName() {
		return "Drop Three";
	}

}
