package t.depart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import t.exception.DU;

public class DepartDAO {
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "ca";
	private final String PASSWORD = "ca";

	public DepartDAO() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/** List Start **/
	public ArrayList<DepartDTO> departList() throws Exception {
		ArrayList<DepartDTO> list = new ArrayList<DepartDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from depart";
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int did = rs.getInt("did");
				String dname = rs.getString("dname");
				DepartDTO ddto = new DepartDTO(did, dname);
				list.add(ddto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

	/** List End **/

	/** Read Start **/
	public String getDname(int target) {
		String str = "";
		String sql = "select dname from depart where did=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, target);
			rs = pstmt.executeQuery();
			str = rs.next() ? rs.getString("dname") : "망함";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return str;
	}

	/** Read End **/

	/** Create Start **/
	public void departCreate(String dname) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into depart values((select nvl(max(did),0)+1 from depart),?)";

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			int i = pstmt.executeUpdate();
			if (1 == i) {
				System.out.println(dname + "(을)를 생성을 성공 했습니다.");
			} else {
				System.out.println(dname + "(을)를 생성을 실패 했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/** Create End **/

	/** Update Start **/
	public void departupdate(String dname,Object target) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update depart set dname= ? where did = ?";
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setObject(2, target);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
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
	}

	/** Update End **/

	/** Delete Start **/
	public void departDelete(int did) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from depart where did=?";
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, did);
			if (pstmt.executeUpdate() == 1) {
				System.out.println(did + "의" + getDname(did) + "을(를) 삭제 성공했습니다.");
			} else {
				System.out.println(did + "의" + getDname(did) + "을(를) 삭제 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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
	}

	public int departDU(int did) {
		int i=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update member set did=100 where did = ?";
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,did);
			if(pstmt.executeUpdate()==1) {
				System.out.println("Delete를 실행합니다.");
			}else {
				throw new DU("Delete를 할수 없습니다 초기 화면으로 돌아가겠습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
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
		return i;
	}
	/** Delete End **/
}