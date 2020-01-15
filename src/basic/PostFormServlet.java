package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostFormServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) 
						throws ServletException, IOException{
		req.setCharacterEncoding("euc-kr");
		System.out.println("user ID : "+req.getParameter("userId"));
		System.out.println("성명 : "+req.getParameter("userName"));
		System.out.println("pass : "+req.getParameter("passwd"));
		System.out.println("성별 : "+req.getParameter("gender"));
		System.out.println("직업 : "+req.getParameter("job"));
		String fav[] = req.getParameterValues("item");
		System.out.print("취미 : ");
		for (int i = 0; i < fav.length; i++) {
			System.out.print(fav[i]+" ");
		}
		
	}
}
