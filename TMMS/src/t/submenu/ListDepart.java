package t.submenu;

import t.depart.DepartDAO;
import t.depart.DepartDTO;
import t.interfaces.ListCommand;
public class ListDepart implements ListCommand {

	@Override
	public void execute() throws Exception {
		DepartDAO dao = new DepartDAO();
		System.out.println("ID\t\t DNAME");
		
		for (DepartDTO d : dao.departList()) {
			System.out.print(d.getDid() + "\t\t ");
			System.out.print(d.getDname());
			System.out.println();
		}
	}
}
