package com.g4.java.configuration;

import org.kohsuke.args4j.Option;

public class CommandLineParser {

	@Option(name="-p", aliases={"--properties"}, usage="The path of the .properties file")
	private String propertiesPath;
	
	public boolean help;
	
	@Option(name="--help", usage="Print the usage of each parameters")
	public void showHelp(boolean flag){
		help = true;
	}
	
	public String getPropertiesPath(){
		return propertiesPath;
	}
}
