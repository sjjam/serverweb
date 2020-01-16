package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;
import jdbc.member.exam.MemberDTO;

public class DeptDAOImpl implements DeptDAO{
	@Override
	public int insert(DeptDTO dept) {
		Connection con = null;
		PreparedStatement ptmt = null;
		String sql = "insert into mydept values(?,?,?,?,?)";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dept.getDeptNo());
			ptmt.setString(2, dept.getDeptName());
			ptmt.setString(3, dept.getLoc());
			ptmt.setString(4, dept.getTel());
			ptmt.setString(5, dept.getMgr());
			result = ptmt.executeUpdate();
			System.out.println("등록 완료");
		}catch(SQLException e) {
			System.out.println("등록 실패");
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}

	@Override
	public ArrayList<DeptDTO> getDeptList() {
		ArrayList<DeptDTO> list = new ArrayList<DeptDTO>();
		DeptDTO dept = null;
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select * from mydept";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while(rs.next()) {
				dept = new DeptDTO(rs.getString(1),rs.getString(2),rs.getString(3)
						,rs.getString(4),rs.getString(5));
				list.add(dept);
				//System.out.println(rs.getString(1));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return list;
	}

	@Override
	public int delete(String deptNo) {
		Connection con = null;
		PreparedStatement ptmt = null;
		String sql = "delete from mydept where deptNo = ?";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, deptNo);
			result = ptmt.executeUpdate();
			System.out.println("삭제 완료");
		}catch(SQLException e) {
			System.out.println("삭제 실패");
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
}
