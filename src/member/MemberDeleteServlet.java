package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "memDel", urlPatterns = { "/member/delete.do" })
public class MemberDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		int result = dao.delete(id);
		
		response.sendRedirect("/serverweb/member/list.do");
	}
}
