package dept;

import java.util.ArrayList;

public interface DeptDAO {
	int insert(DeptDTO dept);
	//전체 목록 출력
	ArrayList<DeptDTO> getDeptList();
	int delete(String deptNo);
	DeptDTO read(String deptNo);
}
