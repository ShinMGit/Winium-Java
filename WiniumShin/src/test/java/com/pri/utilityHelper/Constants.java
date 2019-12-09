package com.pri.utilityHelper;

public class Constants {
	
	private static final String APIURI = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
	//private static final String APPURL = "http://newtours.demoaut.com";
	private static final String APPURL = "https://myaccount.google.com/intro";
	//private static final String APPURL = "https://shop.advanceautoparts.com";
	
	private static final String BROWSER = "Chrome";
	
	private static final String NOTEPAD_WRITE_LOCATION = "C:/NotepadOut/autoWrite.txt";
	
	private static final String FILEOUTPUT_TXT= "/Users/shinmaibam/Documents/Automation/TestRun";
	
	private static final int MAX_EXPLICITWAITTIME = 60;
	private static final int MIN_EXPLICITWAITTIME = 30;
	
	private static final String HEADER_TEXT = "Create your Google Account";
	
	
	public static String getHeaderText() {
		return HEADER_TEXT;
	}

	public static String getNotepadWriteLocation() {
		return NOTEPAD_WRITE_LOCATION;
	}

	public static String getBrowser() {
		return BROWSER;
	}

	public static String getAppurl() {
		return APPURL;
	}

	public static String getApiuri() {
		return APIURI;
	}
	
	public static int getMaxExplicitwaittime() {
		return MAX_EXPLICITWAITTIME;
	}

	public static int getMinExplicitwaittime() {
		return MIN_EXPLICITWAITTIME;
	}

	
	
	

}
