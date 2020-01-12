package t.join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JoinDAO {
	private final String DRIVER="oracle.jdbc.driver.OracleDriver";
	private final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER="ca";
	private final String PASSWORD="ca";
	
	public JoinDAO() {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		public ArrayList<JoinDTO> getList() throws Exception {
			ArrayList<JoinDTO> list = new ArrayList<JoinDTO>();
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "select * from member natural join depart";
			ResultSet rs = null;
			
			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					String id = rs.getString("id");
					String name = rs.getString("name");
					int age = rs.getInt("age");
					int did = rs.getInt("did");
					String dname = rs.getString("dname");
					
					JoinDTO jdto = new JoinDTO(id, name, age, did, dname);
					list.add(jdto);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}
					if (conn != null) {
						conn.close();
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			return list;
	}
}

