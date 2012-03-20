package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
	private static final String route = "log.txt";
	private static FileWriter fw = null;

	public static final int LEVEL_OFF = -1;
	public static final int LEVEL_DEBUG = 3;
	public static final int LEVEL_TRACE = 2;
	public static final int LEVEL_WARNING = 1;
	public static final int LEVEL_ERROR = 0;
	
	public static int LOG_LEVEL;
	
	/**
	 * Initializes the logger to save messages to the default logFile "log.txt"
	 */
	public static void init() {
		Logger.init(route);
	}

	/**
	 * Initializes the logger to save messages to the selectes logFile.
	 */
	public static void init(String logFile) {
		try {
			fw = new FileWriter(new File(logFile));
			LOG_LEVEL = 0;
		} catch (IOException e) {
			System.out.println("Could not create log file for Logger!");
			System.out.println(e.getMessage());
		}
	}
	
	public static void log(String tag, Object o, int level) {
		if (level > LOG_LEVEL) {
			return;
		}
		if (o != null) {
			log(tag, o.toString());
		} else {
			log(tag, "null object");
		}
	}
	
	private static void log(String tag, String message) {
		String msg = "<" + tag + "> " + message + '\n';
		try {
			if (fw != null) {
				System.out.println(msg);
				fw.write(msg);
				fw.flush();
			} else {
				System.out.print(msg);
			}
		} catch (IOException e) {
			System.out.print("ERROR LOGGING MSG: " + msg);
		}
	}
}
