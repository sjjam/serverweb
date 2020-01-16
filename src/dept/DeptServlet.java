package dept;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "deptinsert", urlPatterns = { "/deptinsert.do" })
public class DeptServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		
		//1. 요청정보 추출
		String deptNo = request.getParameter("deptNo");
		String deptName = request.getParameter("deptName");
		String loc = request.getParameter("loc");
		String tel = request.getParameter("tel");
		String mgr = request.getParameter("mgr");
		
		pw.println(deptNo);
		pw.println(deptName);
		pw.println(loc);
		pw.println(tel);
		pw.print(mgr);
		
		DeptDTO dept = new DeptDTO(deptNo, deptName, loc, tel, mgr);
		//2. 비지니스메소드 call
		DeptDAOImpl dao = new DeptDAOImpl();
		int result = dao.insert(dept);
		
		pw.print("<h1>삽입성공</h1>");
		pw.print("<hr/>");
		pw.print("<h3>"+result+"개 행 삽입성공</h3>");
	}

}
