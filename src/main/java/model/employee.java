package model;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class employee {

	private int Ssn;
	private String Fname;
	private String Lname;
	private int Super_ssn;
	private int Dno;
	private String Minit;
	private String Sex;
	private int Salary;
	private String Bdate;
	private String Address;
	private String email;
	
	public int getSsn() {
		return Ssn;
	}
	public void setSsn(int ssn) {
		Ssn = ssn;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public int getSuper_ssn() {
		return Super_ssn;
	}
	public void setSuper_ssn(int super_ssn) {
		Super_ssn = super_ssn;
	}
	public int getDno() {
		return Dno;
	}
	public void setDno(int dno) {
		Dno = dno;
	}
	public String getMinit() {
		return Minit;
	}
	public void setMinit(String minit) {
		Minit = minit;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public String getBdate() {
		return Bdate;
	}
	public void setBdate(String bdate) {  
	    try {
	    	DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd");
			Date date =dateFormat.parse(bdate);
			DateFormat dateFormat1 =new SimpleDateFormat("dd-MMM-yy");
			String bd= dateFormat1.format(date);
			Bdate=bd;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
		
	}
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "('" + Fname + "','" + Minit + "','" + Lname + "', " + Ssn + ",'"
				+ Bdate + "',' " + Address + "', '" + Sex + "', " + Salary + ", " + Super_ssn + ", "
				+ Dno +",'"+email+ "')";
	}
	
	
}

	


