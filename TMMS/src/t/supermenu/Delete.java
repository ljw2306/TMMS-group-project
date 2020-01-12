package t.supermenu;

import java.util.Scanner;

import t.interfaces.Command;
import t.interfaces.DeleteCommand;
import t.submenu.DeleteDepart;
import t.submenu.DeleteMember;

public class Delete implements Command{
	public Delete() {
	}
	@Override
	public void execute(Scanner sc) throws Exception {
			DeleteCommand[] dc= {new DeleteMember(),new DeleteDepart()};
			boolean flag=true;
			while (flag) {
				int i=1;
				for (DeleteCommand nav : dc) {
					System.out.print(i+"번:"+nav);
					i++;
					if((dc.length+1)==i)System.out.println(i+"번:초기화면");
				} 
				int menu=Integer.parseInt(sc.nextLine())-1;
				try {
					dc[menu=dc.length!=menu?menu:dc.length+1].execute(sc);
				}catch (Exception e) {
					flag=false;
					return;
				}
			}
	} 
	public String toString() {
		return "삭제  ";
	}
}
