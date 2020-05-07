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
		response.setContentType("text/html;charset=UTF-8"); // �� �ڵ尡 ������ �Ʒ� �ڵ��� <br>�� �׳� "<br>"�� �νĵȴ�.
		request.setCharacterEncoding("utf-8"); // post ����� ��� �ѱ� ���ڵ� ���� �ʿ�
		
		System.out.println("doPost");
		
		// �Ѿ���� 3���� ������ �޾Ƽ� ȭ�鿡 ���
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		
		PrintWriter out = response.getWriter();
		/*
		 * out.println("<html>");
		 * out.println("<head><title>ServletLogin</title></head>");
		 * out.println("<body>"); out.println("���̵�: " + userId +"<br>");
		 * out.println("��й�ȣ: " + userPwd +"<br>"); out.println("�̸�: " + userName);
		 * out.println("</body>"); out.println("</html>");
		 */
		
		if(id.equals(userId)&&pwd.equals(userPwd)) {
			
			// service --> dao���� DB�� �����͸� �����ͼ� �������� ����.
			List<String> list = new ArrayList<String>();
			list.add("���"); list.add("����");
			list.add("����"); list.add("����");
			
			request.setAttribute("list", list);
			
			// �̵�
			// 1) forward
			request.getRequestDispatcher("LoginOK.jsp").forward(request, response);
			
			// 2) redirect
//			response.sendRedirect("LoginOK.jsp?userName="+URLEncoder.encode(userName, "UTF-8"));
		} else {
			// �޼��� ���
			// �ڷ� ����
			out.println("<script>");
			out.println("alert('"+userName+"�� ������ Ȯ�����ּ���.')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
}
