package t.submenu;

import t.interfaces.ListCommand;
import t.member.MemberDAO;
import t.member.MemberDTO;
public class ListMember implements ListCommand {

	@Override
	public void execute() throws Exception {
		MemberDAO dao = new MemberDAO();
		System.out.println("ID\t\t NAME\t\t DNAME2\t\t AGE");
		for (MemberDTO d : dao.memberList()) {
			System.out.print(d.getId() + "\t\t ");
			System.out.print(d.getName() + "\t\t ");
			System.out.print(dao.getDname(d.getDid())+ "\t\t ");
			System.out.print(d.getAge());
			System.out.println();

		}

	}
}
