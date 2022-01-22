package baithuchanh3;
import java.util.Scanner;
import java.lang.String;
import java.util.LinkedList;
//import java.util.List;

public class danhsachsv {
	
	static Scanner sc = new Scanner(System.in);
	
	public void nhapdanhsachsv(LinkedList<sinhvien> danhsach) {
		int kt = 1;
		while (kt!=0) {
			int maso = 0;
			String ten = "";
			int namsinh = 0;
			float dtb = 0;
			boolean nhapkhongdungmssv = true;
			while(nhapkhongdungmssv) {
				try {
					nhapkhongdungmssv = false;
					System.out.print("Nhap MSSV: ");
					Scanner scmmsv = new Scanner(System.in);
					maso = scmmsv.nextInt();
				} catch(Exception e) {System.out.print("Nhap khong dung/ Nhap lai"); nhapkhongdungmssv = true;}
			}
			System.out.print("Nhap ten sinh vien: ");
			sc.nextLine();
			ten = sc.nextLine();
			boolean nhapkhongdungnam = true;
			while (nhapkhongdungnam) {
				try {
					nhapkhongdungnam = false;
					System.out.print("Nhap nam sinh sinh vien: ");
					Scanner scnam = new Scanner(System.in);
					namsinh = scnam.nextInt();
				} catch(Exception e) {System.out.print("Nhap khong dung nam sinh/Nhap lai"); nhapkhongdungnam = true;}
			}
			boolean nhapkhongdungdtb = true;
			while (nhapkhongdungdtb) {
				try {
					nhapkhongdungdtb = false;
					System.out.print("Nhap dtb sinh vien: ");
					Scanner scdtb = new Scanner(System.in);
					dtb = scdtb.nextFloat();
				} catch(Exception e) {System.out.print("Nhap khong dung dtb/Nhap lai"); nhapkhongdungdtb = true;}
			}
			sinhvien newsv = new sinhvien(maso,ten,namsinh,dtb);
			danhsach.add(newsv);
			System.out.print("Ban co muon nhap tiep khong Co/1 Khong/0: ");
			kt = sc.nextInt();
		}
		
	}
	
	public void xuatdanhsachsv(LinkedList<sinhvien> danhsach) {
		System.out.println("XUAT DANH SACH SINH VIEN");
		System.out.printf("%-5s%-20s%-20s%-20s%-20s\n","STT","MSSV","Ten","Nam sinh","Xep loai");
		for (int i=0; i<danhsach.size(); i++) 
			danhsach.get(i).xuatthongtinsv(i+1);
	}
	
	public void xuatdanhsachtheomssv(LinkedList<sinhvien> danhsach) {
		System.out.print("Nhap MSSV can xuat: ");
		int maso = sc.nextInt();
		for (int i=0; i<danhsach.size(); i++) 
		{
			if (maso == danhsach.get(i).getmssv())
				danhsach.get(i).xuatthongtinsv(i);
			else
				System.out.print("Khong tim thay");
		}
	}
	
	public void themsinhvien(LinkedList<sinhvien> danhsach) {
		System.out.print("Nhap MSSV: ");
		int maso = sc.nextInt();
		System.out.print("Nhap ten sinh vien: ");
		sc.nextLine();
		String ten = sc.nextLine();
		System.out.print("Nhap nam sinh sinh vien: ");
		int namsinh = sc.nextInt();
		System.out.print("Nhap diem trung binh sinh vien: ");
		float dtb = sc.nextFloat();
		sinhvien newsv = new sinhvien(maso,ten,namsinh,dtb);
		danhsach.add(newsv);
	}
	
	
	public void xoasinhvien(LinkedList<sinhvien> danhsach) {
		System.out.print("Chon cach xoa 1/Xoa theo MSSV 2/Xoa theo ten");
		int nhap = sc.nextInt();
		int vt=0;
		if (nhap==1) {
			System.out.print("Nhap MSSV can xoa: ");
			int masoxoa = sc.nextInt();
			for (int i=0; i<danhsach.size(); i++) {
				if (masoxoa == danhsach.get(i).getmssv()) //tim maso sinh vien
					vt = i;
				else
					System.out.print("Khong tim thay");
			}
			danhsach.remove(vt);
		}
		if(nhap==2) {
			System.out.print("Nhap Ho va ten can xoa: ");
			sc.nextLine();
			String hovatenxoa = sc.nextLine();
			for (int i=0; i<danhsach.size(); i++) {
				if (danhsach.get(i).getten().compareTo(hovatenxoa)==0)
					vt = i;
				else 
					System.out.print("Khong tim thay");
			}
			danhsach.remove(vt);
		}
	}
	
	public void capnhatthongtin(LinkedList<sinhvien> danhsach) {
		System.out.print("Nhap MSSV sinh vien can cap nhat: ");
		int maso = sc.nextInt();
		int vt=0;
		for (int i=0; i<danhsach.size(); i++) 
			if (maso == danhsach.get(i).getmssv()) //tim maso sinh vien
				vt = i;
		System.out.print("Nhap thong tin can cap nhat 1/Hoten 2/Namsinh 3/Diemtrungbinh");
		int kt = sc.nextInt();
		if (kt==1) {
			System.out.print("Nhap ho ten cap nhat: ");
			sc.nextLine();
			String hoten = sc.nextLine();
			danhsach.get(vt).setten(hoten);
		}
		if (kt==2) {
			System.out.print("Nhap nam sinh cap nhat: ");
			int namsinh = sc.nextInt();
			danhsach.get(vt).setnamsinh(namsinh);
		}
		if (kt==3) {
			System.out.print("Nhap diem trung binh cap nhat: ");
			float dtb = sc.nextFloat();
			danhsach.get(vt).setdtb(dtb);
		}
	}
	
	public void sapxepdanhsachsv(LinkedList<sinhvien> danhsach) {
		for (int i=0; i<danhsach.size(); i++)
			for (int j=i+1; j<danhsach.size(); j++)
				if (danhsach.get(i).getten().compareTo(danhsach.get(j).getten())>0) {
					sinhvien tam = new sinhvien();
					tam = danhsach.get(i);
					danhsach.set(i, danhsach.get(j));
					danhsach.set(j, tam);
				}
	}
}
