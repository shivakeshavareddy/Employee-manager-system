package model;

public class projectmodel {
	
	private String pname;
	private int pno;
	private String plocation;
	private int dnum;
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPlocation() {
		return plocation;
	}
	public void setPlocation(String plocation) {
		this.plocation = plocation;
	}
	public int getDnum() {
		return dnum;
	}
	public void setDnum(int dnum) {
		this.dnum = dnum;
	}
	@Override
	public String toString() {
		return "(" + pname + ", " + pno + ", " + plocation + ", " + dnum + ")";
	}
	
	
	
	
}
