package t.test;

import java.util.Scanner;

import t.interfaces.Command;
import t.supermenu.Create;
import t.supermenu.Delete;
import t.supermenu.List;
import t.supermenu.Read;
import t.supermenu.Update;

public class MainEx {

	public static void main(String[] args) {
		Command[] com= {new Create(),new List(),new Read(),new Update(),new Delete()};
		System.out.println("TEAMPROJECT‎ MMS!!");
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		while (flag) {
			int i=1;
			for(Command nav:com) {
				System.out.print(i+"번:"+nav.toString()+"  ");
				i++;
				if(i==com.length+1) {
					System.out.println(i+"번:종료");
				}
			}
			int menu = Integer.parseInt(sc.nextLine())-1;
			try {
				com[menu].execute(sc);
			} catch (Exception e) {
				System.out.println("GoodBye~!!");
				flag=false;
				sc.close();
			}
		}
		
		
	}

}
