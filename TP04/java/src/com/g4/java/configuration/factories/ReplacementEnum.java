package com.g4.java.configuration.factories;

public enum ReplacementEnum {
	ELITE("ELITE"),
	TOURNAMENT("TOURNAMENT"),
	UNIVERSAL("UNIVERSAL"),
	RULETTE("RULETTE");
	
	private String name;
	
	private ReplacementEnum(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public static ReplacementEnum getReplacementEnum(String str){
		for (ReplacementEnum rep : ReplacementEnum.values()) {
			if( rep.getName().equals(str) )
				return rep;
		}
		return null;
	}
}
