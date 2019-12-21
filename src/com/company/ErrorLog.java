package com.company;

public class ErrorLog {

	private String machineId;
	private String description;

	/** Precondition: message is a valid Error log entry */
	public ErrorLog(String message) {
	    int semiLoc = message.indexOf(':');
	    machineId = message.substring(0,semiLoc);
	    description = message.substring(semiLoc+1);
	}

	/** Returns true if the description in this error log entry
	 * contains keyword; false otherwise.
	 */
	public boolean containsKey(String keyword) {
	    if (description.contains(keyword)){
	    	int location = description.indexOf(keyword);
			boolean isFirstChar = false;
			boolean isLastChar = false;
	    	if(location == 0){
	    		isFirstChar = false;
			}else if(Character.isLetterOrDigit(description.charAt(location-1)) || !Character.isWhitespace(description.charAt(location-1))){
	    		isFirstChar = true;
			}
	    	if(location == description.length()-keyword.length()){
	    		isLastChar = false;
			}else if(Character.isLetterOrDigit(description.charAt(location+keyword.length())) || !Character.isWhitespace((description.charAt(location+keyword.length())))){
	    		isLastChar = true;
			}
	    	if(!isFirstChar && !isLastChar){
	    		return true;
			}
			return false;
		}else{return false;}
	}

	public String getMachineId() { return machineId;}
	public String getDescription() { return description; }

	public static void main(String[] args) {
		ErrorLog er1 = new ErrorLog("CLIENT2:security alert");
		ErrorLog er2 = new ErrorLog("Webserver:disk offline");
		ErrorLog er3 = new ErrorLog("SERVER22:file not found on disk3");
		ErrorLog er4 = new ErrorLog("SERVER15:read error on disk DSK7");
		ErrorLog er5 = new ErrorLog("SERVER22:write error on disk");
		ErrorLog er6 = new ErrorLog("Webserver:error on /dev/disk");

		System.out.println("message 1 " + er1.containsKey("disk"));
		System.out.println("message 2 " + er2.containsKey("disk"));
		System.out.println("message 3 " + er3.containsKey("disk"));
		System.out.println("message 4 " + er4.containsKey("disk"));
		System.out.println("message 5 " + er5.containsKey("disk"));
		System.out.println("message 6 " + er6.containsKey("disk"));
	}

}
/*
Output
message 1 false
message 2 true
message 3 false
message 4 true
message 5 true
message 6 false
 */
