package com.g7.rules;

import com.g7.Jar;
import com.g7.JarsState;

import gps.api.GPSRule;
import gps.api.GPSState;
import gps.exception.NotAppliableException;

public class TenToThree implements GPSRule {

	@Override
	public GPSState evalRule(GPSState arg0) throws NotAppliableException {
		JarsState oldJS = (JarsState) arg0;
		Jar[] jars = oldJS.getJars();
		
		int qty = Math.min(jars[0].getUsed(), jars[2].getMaxLiters() - jars[2].getUsed());

		if ( qty == 0 ) {
			throw new NotAppliableException();
		}

		JarsState newJS = new JarsState(jars[0].getUsed()-qty, jars[1].getUsed(), jars[2].getUsed()+qty);

		return newJS;
	}

	@Override
	public float getCost() {
		return 1;
	}

	@Override
	public String getName() {
		return "Ten To Three";
	}

}
