package baithuchanh3;

import java.util.LinkedList;
//import java.util.List;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;

public class menu {
	public static boolean write(LinkedList<sinhvien> danhsach, String filename) {
		//File file = new File(filename);
		try {
			FileOutputStream fos = new FileOutputStream(filename); //khai bao fos oos
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			oos.writeObject(danhsach); //thuc hien
			oos.close(); // close
			fos.close();
			return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public static LinkedList<sinhvien> read(String filename){
		LinkedList<sinhvien> danhsach = new LinkedList<>();
		try {
			FileInputStream fis = new FileInputStream(filename); //khai bao fis ois
			ObjectInputStream ois = new ObjectInputStream(fis); 
			Object obj = ois.readObject(); //thuc hien
			danhsach = 	(LinkedList<sinhvien>) obj; 
			ois.close(); //close
			fis.close();
		}catch (Exception e) {e.printStackTrace();}
		return danhsach;
	}
	
	public static void main(String[] args) {
		LinkedList<sinhvien> danhsach = read("D:\\danhsach.txt"); //doc danhsach tu file
		//LinkedList<sinhvien> danhsach = new LinkedList<sinhvien>();
		danhsachsv quanly = new danhsachsv();
		int menu=1;
		while (menu!=0) {
			System.out.println("CHUONG TRINH QUAN LY SINH VIEN MENU");
			System.out.println("1 - NHAP VAO DANH SACH SINH VIEN");
			System.out.println("2 - XUAT THONG TIN SINH VIEN");
			System.out.println("3 - XUAT THONG TIN THEO MSSV");
			System.out.println("4 - THEM 1 SINH VIEN VAO DANH SACH");
			System.out.println("5 - XOA 1 SINH VIEN TRONG DANH SACH");
			System.out.println("6 - CAP NHAT THONG TIN 1 SINH VIEN TRONG DANH SACH");
			System.out.println("7 - SAP XEP DANH SACH SINH VIEN");
			System.out.println("8 - NHAP DANH SACH SINH VIEN VAO FILE TXT");
			//System.out.println("9 - LAY DANH SACH SINH VIEN TU FILE TXT");
			System.out.println("0 - THOAT");
			menu = danhsachsv.sc.nextInt();
			switch(menu) {
			case 1:{
				quanly.nhapdanhsachsv(danhsach);
				break;
			}
			case 2:{
				quanly.xuatdanhsachsv(danhsach);
				break;
			}
			case 3:{
				quanly.xuatdanhsachtheomssv(danhsach);
				break;
			}
			case 4:{
				quanly.themsinhvien(danhsach);
				break;
			}
			case 5:{
				quanly.xoasinhvien(danhsach);
				break;
			}
			case 6:{
				quanly.capnhatthongtin(danhsach);
				break;
			}
			case 7:{
				quanly.sapxepdanhsachsv(danhsach);
				break;
			}
			case 8:{
				write(danhsach,"D:\\danhsach.txt");
			}
			/*case 9:{
				read("D:\\danhsach.txt");
			}*/
			case 0:
				break;
			}
		}
		danhsachsv.sc.close();
	}
}
