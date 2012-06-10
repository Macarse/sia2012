package com.g4.java.configuration.factories;

public enum CrossOverEnum {
	CLASSIC("CLASSIC"),
	MULTIPLE_POINT("MULTIPLE POINT"),
	UNIFORM("UNIFORM"),
	ANULAR("ANULAR"),
	GENE("GENE");
	
	
	private String name;
	
	private CrossOverEnum(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public static CrossOverEnum getCrossOverEnum(String str){
		for (CrossOverEnum rep : CrossOverEnum.values()) {
			if( rep.getName().equals(str) )
				return rep;
		}
		return null;
	}
	
}
