package model;

public class works_on {
	
	private int essn;
	private int pno;
	private float hours;
	public int getEssn() {
		return essn;
	}
	public void setEssn(int essn) {
		this.essn = essn;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public float getHours() {
		return hours;
	}
	public void setHours(float hours) {
		this.hours = hours;
	}
	@Override
	public String toString() {
		return "(" + essn + ", " + pno + "," + hours + ")";
	}
	
	
	
}
