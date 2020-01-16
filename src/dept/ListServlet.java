package dept;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "list", urlPatterns = { "/dept/list.do" })
public class ListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		//1. ��û��������
		//2. �����Ͻ��޼ҵ� call		
		DeptDAOImpl dao = new DeptDAOImpl();
		ArrayList<DeptDTO> list = new ArrayList<DeptDTO>();
		list = dao.getDeptList();
		//ArrayList<DeptDTO> list = dao.getDeptList(); ������ ���ٷ�
		//3. ����޽��� ����
		pw.print("<h1>�μ���Ϻ���</h1>");
		pw.print("<hr/>");
		pw.print("<table border='1' width='500'>");
		pw.print("<tr>");
		pw.print("<th>�μ� ��ȣ</th><th>�μ� �̸�</th><th>�μ� ��ġ</th>");
		pw.print("<th>��ȭ ��ȣ</th><th>�����</th><th>����</th>");
		int size = list.size();
		for(int i=0;i<size;i++) {
			DeptDTO dept = list.get(i);
			pw.print("<tr>");
			pw.print("<td>" + dept.getDeptNo() + "</td>");
			pw.print("<td>" + dept.getDeptName() + "</td>");
			pw.print("<td>" + dept.getLoc() + "</td>");
			pw.print("<td>" + dept.getTel() + "</td>");
			pw.print("<td>" + dept.getMgr() + "</td>");
			pw.print("<td><a href='/serverweb/dept/delete.do?deptNo="+dept.getDeptNo()
								+"&info=test'>����</a></td>");
			pw.print("</tr>");
		}
		pw.print("</table>");
	}
}
