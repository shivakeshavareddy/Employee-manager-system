package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dependentsmodel {
	private int ess;
	private String dependentname;
	private String sex;
	private String bdate;
	private String relationship;
	public int getEss() {
		return ess;
	}
	public void setEss(int ess) {
		this.ess = ess;
	}
	public String getDependentname() {
		return dependentname;
	}
	public void setDependentname(String dependentname) {
		this.dependentname = dependentname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		try {
	    	DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd");
			Date date =dateFormat.parse(bdate);
			DateFormat dateFormat1 =new SimpleDateFormat("dd-MMM-yy");
			String bd= dateFormat1.format(date);
			this.bdate=bd;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	@Override
	public String toString() {
		return "(" + ess + ",'" + dependentname + "', '" + sex + "','" + bdate
				+ "','" + relationship + "')";
	}
	
	
}
