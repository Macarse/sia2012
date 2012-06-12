package com.g4.java.configuration.factories;


public enum EndingEnum {
	MAXGENERATION("MAXGENERATION"),
	STRUCTURAL("STRUCTURAL"),
	CONTENT("CONTENT"),
	OPTIMUM("OPTIMUM");
	
	private String name;
	
	private EndingEnum(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public static EndingEnum getEndingEnum(String str){
		for (EndingEnum rep : EndingEnum.values()) {
			if( rep.getName().equals(str) )
				return rep;
		}
		return null;
	}
}
