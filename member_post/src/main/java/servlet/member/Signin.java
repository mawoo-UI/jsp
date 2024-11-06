package servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import service.MemberService;
import service.MemberServiceImpl;
import vo.Member;

	@WebServlet("/signin")
	public class Signin extends HttpServlet{
		private MemberService service = new MemberServiceImpl();

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getRequestDispatcher("/WEB-INF/jsp/member/signin.jsp").forward(req, resp);
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String remember = req.getParameter("remember-id");
			
			
//			Member member = new Member();
//			member.setId(id);
//			기본값으로 되어있으면 한글깨짐 //한글 3byte ,영문 1byte(?)
//			iso 8859-1 (기본값)
			Member member = Member.builder()
					.id(id)
					.pw(pw)
					.build();
			
			System.out.println(id);
			System.out.println(pw);
			System.out.println(remember);
			
			
			
//			service.register(member);
			if (service.login(id, pw)) {
				//로그인 성공
				HttpSession session = req.getSession();
				session.setAttribute("member", service.findBy(id));
				
				//쿠키에 아이디 기억 여부 처리
				if(remember != null) {
					Cookie cookie = new Cookie("remember-id", id);
					System.out.println(cookie);
					cookie.setMaxAge(60 * 60 * 24 * 7);
					resp.addCookie(cookie);
				}else {
					Cookie[] cookie  = req.getCookies();
					for(Cookie c: cookie) {
						if (c.getName().equals("renenber-id")){
							c.setMaxAge(0);
							resp.addCookie(c);
							break;
						}
					}
				}
				
				resp.sendRedirect(req.getContextPath()+"/index");
				
				//아이디 기억 안할 때 처리할 일
			} 
			else {
				resp.sendRedirect("login?msg=fail");
				
			}
			
		}
		
	}
	

