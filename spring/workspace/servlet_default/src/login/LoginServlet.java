package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginlala")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>login Assignment</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method='post'>");
		out.println("ID : <input type='text' name='logId'><br><br>");
		out.println("PW : <input type='text' name='logPW'><br><br>");
		out.println("<input type='submit' name='login'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		String id = req.getParameter("logId");
		String pw = req.getParameter("logPW");
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		int resid = service.getMemberId(id);
		System.out.println("id 작업 성공 여부 : " + resid);
		
		MemberVO mv = new MemberVO();
		
		mv.setId(id);
		mv.setPw(pw);
		
		int respw = service.getMemberPw(mv);
		System.out.println("pw 작업 성공 여부 : " + respw);
		
		PrintWriter out = resp.getWriter();

		if(resid == 0) {
			out.println("<script>");
			out.println("alert('존재하지 않는 id입니다'); location.href = 'login';");//location href 몰랐음
			out.println("</script>");
		} else {
			if(respw == 0) {
				out.println("<script>");
				out.println("alert('비밀번호가 일치하지 않습니다.'); location.href = 'login';");//location href 몰랐음
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('로그인 성공! 환영합니다.');");
//						+ "var changeView = '<h1>MAIN</h1>';"
//						+ "document.getElementsByTagName(\"body\").html(changeView);");
				out.println("</script>");
			}
		}
		out.println("<html>");
		out.println("<head>");
		out.println("<title>login Assignment</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>MAIN</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}
