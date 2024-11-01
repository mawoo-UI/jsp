package stud;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test.do")
public class StudentServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<body>");
		pw.println("<h1>안녕 세상</h>");
		pw.println("</body>");
		
		ByteArrayInputStream bais = new ByteArrayInputStream(new byte[] {10,20,30});
		CharArrayReader car = new CharArrayReader(new char[] {'가','나'});
		StringReader sr = new StringReader("가나다라");
		
		System.out.println((char)sr.read());
		System.out.println((char)sr.read());
		System.out.println((char)sr.read());
		System.out.println((char)sr.read());
	}
	
}
//http://localhost:8080/01_servlet/student
//인증서 없는상태에선 http
//로콜호스트에선 https 사용못함
//보조기억장치 실행시 필요한 장치를 주 기억장치에 이동한다.
//윈도우=멀티프로세스
//싱글스레드 실행시-> 프로그램이 반납되었을때 다른프로그램실행가능