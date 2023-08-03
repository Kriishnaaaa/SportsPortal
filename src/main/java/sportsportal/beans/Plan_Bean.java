package sportsportal.beans;

public class Plan_Bean {
      private String name,service;
      private int charge;

	

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Plan_Bean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Plan_Bean(String name, String service,int charge) {
		super();
		this.name = name;
		this.service = service;
		this.charge=charge;
	}
}
