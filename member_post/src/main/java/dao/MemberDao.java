package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import utils.DBConn;
import vo.Member;

public class MemberDao {
	// CRUD
	public int insert(Member member) {
		Connection conn = null;

		PreparedStatement pstmt = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String sql = "insert into tbl_member (id, pw, name, email, road_addr, detail_addr)"
					+"values(?,?,?,?,?,?)";

			// 1. connection 객체 취득
			conn = DBConn.getConnection();
			// 2. 문장 생성,파라미터 지정\
			pstmt = conn.prepareStatement(sql);

			int idx = 1;

			pstmt.setString(idx++, member.getId());
			pstmt.setString(idx++, member.getPw());
			pstmt.setString(idx++, member.getName());
			pstmt.setString(idx++, member.getEmail());
			pstmt.setString(idx++, member.getRoadAddr());
			pstmt.setString(idx++, member.getDetailAddr());
			// 3. 문장 실행
//			return stmt.executeUpdate(sql);
			return pstmt.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException ignore) {}
		}
		return 0;
	}

	public static void main(String[] args) {
//		MemberDao dao = new MemberDao();
//		int result = dao.insert(Member.builder().id("cccc").pw("1234").name("소똥이").build());
//		System.out.println(result);
		
		Member m = dao.selectOne("ddd");
		System.out.println(m);
	}
	private static final MemberDao dao = new MemberDao();
	
	public static MemberDao getInstance() {
		// TODO Auto-generated method stub
		return dao;
	}
	private MemberDao() {}

	public Member selectOne(String id) {
		Member member = null;
		String sql ="select * from tbl_member where id = ?";
		try(Connection conn = DBConn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				member = Member.builder()
						.id(rs.getString("id"))
						.pw(rs.getString("pw"))
						.name(rs.getString("name"))
						.email(rs.getString("email"))
						.roadAddr(rs.getString("road_Addr"))
						.detailAddr(rs.getString("detail_Addr"))
						.regdate(rs.getDate("regdate"))
						.build();
			}
			rs.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return member;
	} 
		
}
