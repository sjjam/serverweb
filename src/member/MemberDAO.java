package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dept.DeptDTO;
import fw.DBUtil;

public class MemberDAO {
	public int insert(MemberDTO mem) {
		Connection con = null;
		PreparedStatement ptmt = null;
		String sql = "insert into member values(?,?,?,?,?,?,?)";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(5, mem.getDeptno());
			ptmt.setString(3, mem.getName());
			ptmt.setString(1, mem.getId());
			ptmt.setString(2, mem.getPass());
			ptmt.setString(4, mem.getAddr());
			ptmt.setInt(7, mem.getPoint());
			ptmt.setString(6, mem.getGrade());
			result = ptmt.executeUpdate();
			System.out.println("��� �Ϸ�");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	public ArrayList<MemberDTO> getMemList() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		MemberDTO mem = null;
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select * from member";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while(rs.next()) {
				mem = new MemberDTO(rs.getString(5),rs.getString(3),rs.getString(1)
						,rs.getString(2),rs.getString(4),rs.getInt(7),rs.getString(6));
				list.add(mem);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return list;
	}
	public int delete(String id) {
		Connection con = null;
		PreparedStatement ptmt = null;
		String sql = "delete from member where id = ?";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			result = ptmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		
		if(result > 0) {
			System.out.println("���� �Ϸ�");
		}else {
			System.out.println("���� ����");
		}
		
		return result;
	}
	public MemberDTO read(String id) {
		System.out.println("dao�� readȣ��");
		MemberDTO mem = null;
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id = ?";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			rs = ptmt.executeQuery();//select����
			//�������� �ڹٰ�ü�� ��ȯ
			// - ���ڵ尡 ���� �� : DTO�� ���ڵ带 ��ȯ�ϰ� ArrayList�� add
			// - ���ڵ尡 �� �� : DTO�� ���ڵ� ��ȯ
			if(rs.next()) {//while�ᵵ �ǰ�, �Ѱ��̹Ƿ� if�ᵵ �ȴ�
				mem = new MemberDTO(rs.getString(5),rs.getString(3),rs.getString(1)
						,rs.getString(2),rs.getString(4),rs.getInt(7),rs.getString(6));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return mem;
	}
}
