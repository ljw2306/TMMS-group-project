package t.submenu;

import java.util.Scanner;

import t.interfaces.UpdateCommand;
import t.member.MemberDAO;
public class UpdateDepart implements UpdateCommand {
	public UpdateDepart() {
	}

	@Override
	public void execute(Scanner sc, Object target) throws Exception{
		System.out.println("dname(을)를 입력하세요.");
		String dname = sc.nextLine();
		new MemberDAO().departupdate(dname,target);
	}
}
