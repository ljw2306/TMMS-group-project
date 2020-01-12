package t.submenu;

import java.util.Scanner;

import t.depart.DepartDAO;
import t.interfaces.ReadCommand;
import t.member.MemberDAO;
import t.member.MemberDTO;
public class ReadAge implements ReadCommand {
	@Override
	public void execute(Scanner sc) throws Exception {
		System.out.println("age를 입력하세요");
		int target = Integer.parseInt(sc.nextLine());
		MemberDAO dao = new MemberDAO();
		if (dao.idDuplicate("age",target)) {
			MemberDTO dto = dao.memberRead("age",target);
			System.out.println("아이디\t이름\t나이\t부서명");
			System.out.print(dto.getId() + "\t");
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getAge() + "\t");
			System.out.print(new DepartDAO().getDname(dto.getDid()) + "\n");
			}else {
				System.out.println(target+"살은 없습니다.");
			}
	}
	@Override
	public String toString() {
		return "나이로조회";
	}

}