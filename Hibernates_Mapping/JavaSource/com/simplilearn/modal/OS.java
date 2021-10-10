package com.simplilearn.modal;

public class OS {
	
	private String name;
	private long OSID;
	
	public OS(){
		
	}
	
	public OS(String name){
		this.OSID = 0;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getOSID() {
		return OSID;
	}

	public void setOSID(long oSID) {
		OSID = oSID;
	}
	
	

}
