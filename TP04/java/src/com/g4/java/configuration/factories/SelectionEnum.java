package com.g4.java.configuration.factories;

public enum SelectionEnum {
	ELITE("ELITE"),
	RULETTE("RULETTE"),
	UNIVERSAL("UNIVERSAL"),
	TOURNAMENT("TOURNAMENT"),
	BOLTZMAN("BOLTZMAN");
	
	private String name;
	
	private SelectionEnum(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public static SelectionEnum getSelectionEnum(String str){
		for (SelectionEnum rep : SelectionEnum.values()) {
			if( rep.getName().equals(str) )
				return rep;
		}
		return null;
	}
}
