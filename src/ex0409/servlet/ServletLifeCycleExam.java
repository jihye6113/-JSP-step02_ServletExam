package ex0409.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 브라우저에서 실행되는 servlet 문서 작성
 * 	1) 반드시 public 클래스
 * 	2) 반드시 HttpServlet 상속
 * 	3) 필요한 메서드는 재정의한다.
 * 	4) servlet을 등록한다
 * 		(생성 + url에서 어떻게 요청했을 때 서블릿이 실행될지 설정) 
 * 		- web.xml 등록
 * 		- @annotation 등록
 * */

public class ServletLifeCycleExam extends HttpServlet {

	public ServletLifeCycleExam() {
		System.out.println("ServletLifeCycleExam의 생성자 호출됨");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init() 호출됨.");
	}

//	@Override
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//		System.out.println("service()가 호출됨."); // 재정의를 해서 doGet, doPost는 호출하지 않음.
//	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 현재 창에 한글 인코딩 설정하기
		response.setContentType("text/html;charset=UTF-8"); // UTF-8 대문자로
		
		System.out.println("doGet() 호출됨.");
		
		// 브라우저에 응답(화면구성)
		// 출력스트림이 필요하다.
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color: orange'>HELLO 안녕</h1>");
		out.println("<script>");
		out.println("alert('alert 출력')");
		out.println("</script>");
		
		// 내장객체를 사용한다.
		HttpSession session = request.getSession();
		ServletContext application = request.getServletContext();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost() 호출됨.");
	}

	@Override
	public void destroy() {
		System.out.println("destroy 호출됨");
	}

	
}
