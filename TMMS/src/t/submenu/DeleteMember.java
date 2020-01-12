package t.submenu;

import java.util.Scanner;

import t.interfaces.DeleteCommand;
import t.member.MemberDAO;

public class DeleteMember implements DeleteCommand {

	public DeleteMember() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Scanner sc) throws Exception {
		MemberDAO dao =new MemberDAO();
		System.out.println("삭제하실 아이디를 입력해 주세요."); 
		String target=sc.nextLine();
		boolean flag=dao.idDuplicate("id", target);
		if(flag) {
			System.out.println(target+"(을)를정말로 삭제 하시겠습니까?(Y/N)");
			String choice=sc.nextLine().toUpperCase();
			if(choice.equals("Y")) {
				dao.memberDelete(target);
			}else {
				System.out.println("1번:다시입력 2번:초기화면");
				int menu=Integer.parseInt(sc.nextLine());
				if(menu==1) {
					execute(sc);
				}else {
					return;
				}
			}
		}else {
			System.out.println(target+"(은)는 존재하지 않습니다.");
			System.out.println("1번:다시입력 2번:초기화면");
			int menu=Integer.parseInt(sc.nextLine());
			if(menu==1) {
				execute(sc);
			}else {
				return;
			}
		}
	}
	public String toString() {
		return "회원삭제  ";
	}
}