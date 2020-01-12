package t.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import t.depart.DepartDAO;

public class MemberDAO extends DepartDAO {
	private final String DRIVER = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "ca";
	private final String PASSWORD = "ca";

	public MemberDAO() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결 실패");
		}
	}

	/** List Start **/

	public ArrayList<MemberDTO> memberList() throws Exception {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from member";
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int did = rs.getInt("did");
				int age = rs.getInt("age");

				MemberDTO mdto = new MemberDTO(id, name,age, did);
				list.add(mdto);

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

	public MemberDTO memberRead(String point, Object target) {
		MemberDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where " + point + " =?";
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			if (target instanceof Integer) {
				pstmt.setInt(1, (Integer) target);
			} else {
				pstmt.setString(1, (String) target);
			}
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new MemberDTO(rs.getString("id"), rs.getString("name"), rs.getInt("age"),rs.getInt("did"));
			}
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
		return dto;
	}

	public boolean idDuplicate(String point, Object target) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = point.equals("did")?"select * from depart where "+point+" =?":
			"select * from member where " + point + " =?";
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1,target);
			rs = pstmt.executeQuery();
			flag = rs.next();
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
		return flag;
	}

	/** Read End **/
	/** Create Start **/
	public void memberCreate(MemberDTO dto) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member values (?,?,?,?)";
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getDid());
			pstmt.setInt(4, dto.getAge());

			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("아이디:" + dto.getId() + "(을)를 생성을 성공했습니다.");
			} else {
				System.out.println("아이디:" + dto.getId() + "(을)를 생성을 실패했습니다.");
			}
		} catch (Exception e) {
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
	public void memberUpdate(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		sql = "update member set name=?,age=?,did=? where id=?";
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setInt(3, dto.getDid());
			pstmt.setString(4, dto.getId());
			pstmt.executeUpdate();
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

	/** Update End **/

	/** Delete Start **/

	public void memberDelete(String target) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from member where id=?";
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, target);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("아이디:" + target + "(을)를삭제를 성공했습니다.");
			} else {
				System.out.println("아이디:" + target + "(을)를삭제를 실패했습니다.");
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
	/** Delete End **/
}