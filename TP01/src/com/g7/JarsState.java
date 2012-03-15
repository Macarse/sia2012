package com.g7;

import gps.api.GPSState;

public class JarsState implements GPSState {
	public static int STEP;

	private Jar[] jars = new Jar[3];

	public JarsState() {
		jars[0] = new Jar(10, 10);
		jars[1] = new Jar(7, 0);
		jars[2] = new Jar(3, 0);
	}

	public JarsState(int ten, int seven, int three) {
		this.jars[0] = new Jar(10, ten);
		this.jars[1] = new Jar(7, seven);
		this.jars[2] = new Jar(3, three);
	}

	@Override
	public boolean compare(GPSState var) {

		JarsState js = (JarsState) var;
		Jar[] jars = js.getJars();

		// Como solo nos interesa que haya un 5 en la primera jarra
		// aprovechamos saber que cualquier estado (5,*,*) sirve.
		if ( this.jars[0].getUsed() == 5 && jars[0].getUsed() == 5 )
			return true;

		for ( int i = 0 ; i < jars.length ; i ++ ) {
			if ( jars[i].getMaxLiters() != this.jars[i].getMaxLiters() )
				return false;

			if ( jars[i].getUsed() != this.jars[i].getUsed() )
				return false;
		}
		
		return true;
	}

	public Jar[] getJars() {
		return jars;
	}

	public void setJars(Jar[] jars) {
		this.jars = jars;
	}

	public String toString() {
		
		return String.format("STEP: %d(%d, %d, %d)", STEP++, this.jars[0].getUsed(), this.jars[1].getUsed(), this.jars[2].getUsed());
	}
}
