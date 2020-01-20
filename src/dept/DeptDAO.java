package dept;

import java.util.ArrayList;

public interface DeptDAO {
	int insert(DeptDTO dept);
	//��ü ��� ���
	ArrayList<DeptDTO> getDeptList();
	int delete(String deptNo);
	DeptDTO read(String deptNo);
}
