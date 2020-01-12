package t.submenu;

import java.util.Scanner;

import t.interfaces.CreateCommand;
import t.member.MemberDAO;

public class CreateDepart implements CreateCommand {

	@Override
	public void execute(Scanner sc) throws Exception {
		MemberDAO dao=new MemberDAO();
		System.out.println("사용할 부서명을 적어주세요.");
		String dname=sc.nextLine();
		dao.departCreate(dname);
	}

}