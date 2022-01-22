package baithuchanh3;

import java.io.Serializable;

public class sinhvien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int MSSV;
	private String ten;
	private int namsinh;
	private float dtb;
	
	public sinhvien() {		
	}
	
	public sinhvien(int MSSV, String ten, int namsinh, float dtb) {
		this.MSSV = MSSV;
		this.ten = ten;
		this.namsinh = namsinh;
		this.dtb = dtb;
	}
	
	public void xuatthongtinsv(int i) {
		System.out.printf("%-5d%-20d%-20s%-20d%-20s\n", i, this.MSSV, this.ten, this.namsinh, this.xeploai());
	}
	
	public void setmssv(int MSSV) {
		this.MSSV = MSSV;
	}
	
	public int getmssv() {
		return this.MSSV;
	}
	
	public void setten(String ten) {
		this.ten = ten;
	}
	
	public String getten() {
		return this.ten;
	}
	
	public void setnamsinh(int namsinh) {
		this.namsinh = namsinh;
	}
	
	public int getnamsinh() {
		return this.namsinh;
	}
	
	public void setdtb(float dtb) {
		this.dtb = dtb;
	}
	
	public float getdtb() {
		return this.dtb;
	}
	
	public String xeploai() {
		if (this.dtb<5)
			return "Yeu";
		else if (this.dtb<6)
			return "Trung binh yeu";
		else if(this.dtb<7)
			return "Trung binh";
		else if(this.dtb<8)
			return "Kha";
		else if(this.dtb<9)
			return "Gioi";
		else 
			return "Xuat sac";
	}
}
