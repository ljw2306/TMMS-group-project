package t.submenu;

import java.util.Scanner;

import t.interfaces.DeleteCommand;
import t.member.MemberDAO;

public class DeleteDepart implements DeleteCommand {

	public DeleteDepart() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Scanner sc) throws Exception {
		MemberDAO dao=new MemberDAO();
		System.out.println("삭제할 did을 입력하세요");
		int did= Integer.parseInt(sc.nextLine());
		System.out.println(did+"번을 100번인 비고로 변경하겠습니다.");
		System.out.println("다음 수정시 100번을 참고하세요.");
			try {
				dao.departDU(did);
				dao.departDelete(did);
			} catch (Exception e) {
				return;
			}
		
		
	}
	public String toString() {
		return "부서 삭제";
	}
}
