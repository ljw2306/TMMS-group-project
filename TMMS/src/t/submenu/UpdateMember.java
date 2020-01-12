package t.submenu;

import java.util.Scanner;
import t.depart.DepartDTO;
import t.interfaces.UpdateCommand;
import t.member.MemberDAO;
import t.member.MemberDTO;

public class UpdateMember implements UpdateCommand {
	public UpdateMember() {
	}
	@Override
	public void execute(Scanner sc, Object target) throws Exception {
		System.out.println("name을 입력하세요.");
		String name = sc.nextLine();
		System.out.println("age를 입력하세요.");
		int age = Integer.valueOf(sc.nextLine());

		MemberDAO dao = new MemberDAO();
		// Depart Read
		System.out.println("직업변경");
		int i=1;
		for(DepartDTO nav:dao.departList()) {
			System.out.print(i+"번:"+nav.getDname());
			i++;
			if(dao.departList().size()+1==i) {
				System.out.println(i+"번:없음");
			}
		}
		int did = Integer.parseInt(sc.nextLine())-1;
		dao.memberUpdate(new MemberDTO((String) target, name, age, did));
	}

}
