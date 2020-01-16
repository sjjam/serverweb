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
		//1. 요청정보추출
		//2. 비지니스메소드 call		
		DeptDAOImpl dao = new DeptDAOImpl();
		ArrayList<DeptDTO> list = new ArrayList<DeptDTO>();
		list = dao.getDeptList();
		//ArrayList<DeptDTO> list = dao.getDeptList(); 위두줄 한줄로
		//3. 응답메시지 생성
		pw.print("<h1>부서목록보기</h1>");
		pw.print("<hr/>");
		pw.print("<table border='1' width='500'>");
		pw.print("<tr>");
		pw.print("<th>부서 번호</th><th>부서 이름</th><th>부서 위치</th>");
		pw.print("<th>전화 번호</th><th>담당자</th><th>삭제</th>");
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
								+"&info=test'>삭제</a></td>");
			pw.print("</tr>");
		}
		pw.print("</table>");
	}
}
