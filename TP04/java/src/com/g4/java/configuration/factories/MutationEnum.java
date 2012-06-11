package com.g4.java.configuration.factories;


public enum MutationEnum {
	CLASSIC("CLASSIC"),
	NOT_UNIFORM("NOTUNIFORM");
	
	private String name;
	
	private MutationEnum(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public static MutationEnum getMutationEnum(String str){
		for (MutationEnum rep : MutationEnum.values()) {
			if( rep.getName().equals(str) )
				return rep;
		}
		return null;
	}
}
