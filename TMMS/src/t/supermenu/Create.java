package t.supermenu;

import java.util.Scanner;

import t.interfaces.Command;
import t.interfaces.CreateCommand;
import t.submenu.CreateDepart;
import t.submenu.CreateMember;

public class Create implements Command {

	@Override
	public void execute(Scanner sc) throws Exception {
		boolean flag = true;
		while (flag ) {
			System.out.println("1번:회원가입  2번:부서추가 3번:초기화면");
			int menu = Integer.parseInt(sc.nextLine()) - 1;
			CreateCommand[] cc = { new CreateMember(), new CreateDepart() };
			try {
				cc[menu = menu != cc.length ? menu : cc.length + 1].execute(sc);
			} catch (Exception e) {
				flag=false;
				return;
			} 
		}
	}
	public String toString() {
		return"생성 ";
	}
}