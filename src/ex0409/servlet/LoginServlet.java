package ex0409.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	String id = "bjhye", pwd = "1234";
	
	@Override
	protected void doGet(HttpServletRequest requeset, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		
		this.doPost(requeset, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); // 이 코드가 없으면 아래 코드의 <br>은 그냥 "<br>"로 인식된다.
		request.setCharacterEncoding("utf-8"); // post 방식인 경우 한글 인코딩 설정 필요
		
		System.out.println("doPost");
		
		// 넘어오는 3개의 정보를 받아서 화면에 출력
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		
		PrintWriter out = response.getWriter();
		/*
		 * out.println("<html>");
		 * out.println("<head><title>ServletLogin</title></head>");
		 * out.println("<body>"); out.println("아이디: " + userId +"<br>");
		 * out.println("비밀번호: " + userPwd +"<br>"); out.println("이름: " + userName);
		 * out.println("</body>"); out.println("</html>");
		 */
		
		if(id.equals(userId)&&pwd.equals(userPwd)) {
			
			// service --> dao에서 DB에 데이터를 가져와서 뷰쪽으로 전달.
			List<String> list = new ArrayList<String>();
			list.add("등산"); list.add("수영");
			list.add("낚시"); list.add("골프");
			
			request.setAttribute("list", list);
			
			// 이동
			// 1) forward
			request.getRequestDispatcher("LoginOK.jsp").forward(request, response);
			
			// 2) redirect
//			response.sendRedirect("LoginOK.jsp?userName="+URLEncoder.encode(userName, "UTF-8"));
		} else {
			// 메세지 출력
			// 뒤로 가기
			out.println("<script>");
			out.println("alert('"+userName+"님 정보를 확인해주세요.')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
}
