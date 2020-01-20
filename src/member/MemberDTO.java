package member;

public class MemberDTO {
	String deptno;
	String name;
	String id;
	String pass;
	String addr;
	int point;
	String grade;
	
	public MemberDTO() {
		
	}

	public MemberDTO(String deptno, String name, String id, String pass, String addr, int point, String grade) {
		super();
		this.deptno = deptno;
		this.name = name;
		this.id = id;
		this.pass = pass;
		this.addr = addr;
		this.point = point;
		this.grade = grade;
	}
	

	@Override
	public String toString() {
		return "MemberDTO [deptno=" + deptno + ", name=" + name + ", id=" + id + ", pass=" + pass + ", addr=" + addr
				+ ", point=" + point + ", grade=" + grade + "]";
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
