package t.supermenu;

import java.util.Scanner;

import t.depart.DepartDAO;
import t.interfaces.Command;
import t.interfaces.UpdateCommand;
import t.member.MemberDAO;
import t.submenu.UpdateDepart;
import t.submenu.UpdateMember;

public class Update implements Command {

	@Override
	public void execute(Scanner sc) throws Exception {

		MemberDAO dao = new MemberDAO();
		
		UpdateCommand[] uc = { new UpdateMember(), new UpdateDepart() };	// 0 1
		
		System.out.println("1번:회원정보수정 2번:부서정보수정 3번:초기화면");			// 실제입력1 : 1 2 3
		
		int menu = Integer.parseInt(sc.nextLine()) - 1;						// 컴퓨터연산 : 0 1 2
		String msg=menu==0?"아이디":"부서번호";	
		String msg2=menu==0?"id":"did";
		System.out.println("수정할 "+msg+"를 입력해 주세요");						// 실제입력2 : 아이디
		if (menu != uc.length) {											// 2
			String target = sc.nextLine();
			 boolean flag=dao.idDuplicate(msg2,target);

			 
			if (flag) {
				uc[menu = uc.length != menu ? menu : uc.length + 1].execute(sc,target);
			} else {
				System.out.println("입력하신"+msg+"(은)는 없습니다.");
				System.out.println("1:다시입력 2번:초기화면");
				menu = Integer.parseInt(sc.nextLine());
				if (menu == 1) {
					execute(sc);
				} else {
					return;
				}
			}
		} else {
			System.out.println("초기화면으로 이동 합니다.");
			return;
		}
		
		
	}
	public String toString() {
		return "수정  ";
	}

}