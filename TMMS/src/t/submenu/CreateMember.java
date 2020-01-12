package t.submenu;

import java.util.Scanner;

import t.depart.DepartDTO;
import t.interfaces.CreateCommand;
import t.member.MemberDAO;
import t.member.MemberDTO;

public class CreateMember implements CreateCommand {
	public CreateMember() {
	}
	@Override
	public void execute(Scanner sc) throws Exception{
		MemberDAO dao = new MemberDAO();
		System.out.println("사용할 아이를 입력 해주세요.");
		String target = sc.nextLine();
		boolean result = dao.idDuplicate("id", target);
		if (!result) {
			System.out.println("사용할 이름를 입력 해주세요");
			String name = sc.nextLine();
			System.out.println("사용할 나이를 입력해 주세요.");
			int age = Integer.parseInt(sc.nextLine());
			int i=1;
			for(DepartDTO nav:dao.departList()) {
				System.out.print(i+"번:"+nav.getDname()+"  ");
				i++;
			}	
			System.out.println();
			int did=Integer.parseInt(sc.nextLine())-1;
			MemberDTO dto = new MemberDTO(target, name,did, age);
			dao.memberCreate(dto);
		}else {
			System.out.println("이미 존재하는 아이디 입니다");
			System.out.println("1번:다시입력  2번:초기메뉴");
		
			int menu=Integer.parseInt(sc.nextLine());
			if(menu==1) {
				execute(sc);
			}else {
				return;
			}
		}
	}
}