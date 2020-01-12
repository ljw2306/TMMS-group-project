package t.submenu;

import java.util.Scanner;

import t.depart.DepartDAO;
import t.interfaces.ReadCommand;
import t.member.MemberDAO;
import t.member.MemberDTO;

public class ReadName implements ReadCommand {

	public ReadName() {
	}

	@Override
	public void execute(Scanner sc) throws Exception {

		System.out.println("Name를 입력하세요");
		String target = sc.nextLine();
		
		
		MemberDAO dao = new MemberDAO();
		if (dao.idDuplicate("name",target)) {
			MemberDTO dto = dao.memberRead("name",target);
			System.out.println("아이디\t이름\t나이\t부서명");
			System.out.print(dto.getId() + "\t");
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getAge() + "\t");
			System.out.print(new DepartDAO().getDname(dto.getDid()) + "\n");
		} else {
			System.out.println(target + "(은)는 없는 Name입니다.");
		}

	}
	@Override
	public String toString() {
		return "이름으로조회";
	}

}