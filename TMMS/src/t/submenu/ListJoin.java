package t.submenu;

import t.interfaces.ListCommand;
import t.join.JoinDAO;
import t.join.JoinDTO;

public class ListJoin implements ListCommand {
	
	@Override
	public void execute() throws Exception {
		
		JoinDAO jdao = new JoinDAO();
		System.out.println("ID\t\t NAME\t\t AGE\t\t DID\t\t DNAME");
		
		for (JoinDTO j : jdao.getList()) {
			System.out.print(j.getId() + "\t\t ");
			System.out.print(j.getName() + "\t\t ");
			System.out.print(j.getAge() + "\t\t ");
			System.out.print(j.getDid() + "\t\t ");
			System.out.print(j.getDname());
			System.out.println();
		}
		
	}
}
