package com.g7;

import gps.api.GPSProblem;
import gps.api.GPSRule;
import gps.api.GPSState;

import java.util.ArrayList;
import java.util.List;

import com.g7.rules.DropSeven;
import com.g7.rules.DropTen;
import com.g7.rules.DropThree;
import com.g7.rules.SevenToTen;
import com.g7.rules.SevenToThree;
import com.g7.rules.TenToSeven;
import com.g7.rules.TenToThree;
import com.g7.rules.ThreeToSeven;
import com.g7.rules.ThreeToTen;

public class JarsProblem implements GPSProblem {

	@Override
	public GPSState getGoalState() {
		return new JarsState(5, 0, 0);
	}

	/*
	 * Esta funcion de heuristica no es admisible.
	 * */
	@Override
	public Integer getHValue(GPSState arg0) {
		JarsState js = (JarsState) arg0;
		Jar[] jars = js.getJars();

		int totalQuantity = jars[0].getUsed() + jars[1].getUsed() + jars[2].getUsed();

		if ( totalQuantity < 5 )
			return Integer.MAX_VALUE;

		if ( jars[0].getUsed() == 5 ) { 
			return 0;
		}

		// This is SPARTAAA!
		return 300;
	}

	@Override
	public GPSState getInitState() {
		return new JarsState();
	}

	@Override
	public List<GPSRule> getRules() {
		ArrayList<GPSRule> ret = new ArrayList<GPSRule>(9);
		ret.add(new DropTen());
		ret.add(new DropSeven());
		ret.add(new DropThree());
		ret.add(new TenToSeven());
		ret.add(new TenToThree());
		ret.add(new SevenToTen());
		ret.add(new SevenToThree());
		ret.add(new ThreeToTen());
		ret.add(new ThreeToSeven());

		// Se probo usar shuffle para alterar el orden de
		// las reglas y analizar la cantidad de nodos expandidos.
//		Collections.shuffle(ret);
		return ret;
	}

}
