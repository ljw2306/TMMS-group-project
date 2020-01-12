package t.submenu;

import java.util.Scanner;

import t.depart.DepartDAO;
import t.interfaces.ReadCommand;
import t.member.MemberDAO;
import t.member.MemberDTO;

public class ReadId implements ReadCommand {
	
	public ReadId() {
	}

	@Override
	public void execute(Scanner sc) throws Exception {

		System.out.println("ID를 입력하세요");
		String target = sc.nextLine();

		MemberDAO dao = new MemberDAO();
		if (dao.idDuplicate("id",target)) {
			MemberDTO dto = dao.memberRead("id",target);
			System.out.println("아이디\t이름\t나이\t부서명");
			System.out.print(dto.getId() + "\t");
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getAge() + "\t");
			System.out.print(new DepartDAO().getDname(dto.getDid()) + "\n");
		} else {
			System.out.println(target + "(은)는 없는 ID입니다.");
		}

	}

	@Override
	public String toString() {
		return "아이디로조회";
	}
}