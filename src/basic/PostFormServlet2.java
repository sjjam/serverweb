package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "mypost2", urlPatterns = { "/mypost2.do" })//(xml�� �����ϴ� �Ͱ� ����)
public class PostFormServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		//��û��������
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String passwd = request.getParameter("passwd");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		String item[] = request.getParameterValues("item");
		
		//���䳻���� ����
		pw.print("<html>");
		pw.print("<body>");
		pw.print("<h1>��������</h1>");
		pw.print("<h3>���̵�:"+userId+"</h3>");
		pw.print("<h3>����:"+userName+"</h3>");
		pw.print("<h3>Favorites:</h3>");
		for (String data : item) {
			pw.print(data+" ");
		}
		pw.print("</body>");
		pw.print("</html>");
	}

}