package application;



public class Data {
	
	private static Data data = new Data();
	private Data(){}  
	   
	 public static Data getInstance() {    
       if (data ==null)  
     {  
       	data=new  Data();  
     }  
       return data;  
}  		
	
	public Data(String noOfPerson, String arrivalTime, String bursttime,String completitionTime , String totalTime,
			String waitingTime) {
		super();
		this.noOfPerson = noOfPerson;
		this.arrivalTime = arrivalTime;
		this.bursttime = bursttime;
		this.completitionTime = completitionTime;
		this.totalTime = totalTime;
		this.waitingTime = waitingTime;
	}

	public String noOfPerson, arrivalTime,bursttime,completitionTime,totalTime,waitingTime;
	public String avgwait,avgtotlatime;
	public int numberOfPerson;
	public int[] pn=new int[12], at =new int[12],bt=new int[12],wt=new int[12],tt=new int[12],ct = new int[12];
	

	
	


public String getNoOfPerson() {
	return noOfPerson;
}

public String getArrivalTime() {
	return arrivalTime;
}

public String getBursttime() {
	return bursttime;
}

public String getCompletitionTime() {
	return completitionTime;
}

public String getTotalTime() {
	return totalTime;
}

public String getWaitingTime() {
	return waitingTime;
}

public void setNoOfPerson(String noOfPerson) {
	this.noOfPerson = noOfPerson;
}

public void setArrivalTime(String arrivalTime) {
	this.arrivalTime = arrivalTime;
}

public void setBursttime(String bursttime) {
	this.bursttime = bursttime;
}

public void setCompletitionTime(String completitionTime) {
	this.completitionTime = completitionTime;
}

public void setTotalTime(String totalTime) {
	this.totalTime = totalTime;
}

public void setWaitingTime(String waitingTime) {
	this.waitingTime = waitingTime;
}

}

