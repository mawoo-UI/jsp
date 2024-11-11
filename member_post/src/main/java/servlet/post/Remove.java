package servlet.post;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Criteria;
import service.PostService;
import service.PostServiceImpl;
import vo.Member;

@WebServlet("/post/remove")
public class Remove extends HttpServlet{
	private PostService service = new PostServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pnoStr = req.getParameter("pno");
		Object memberObject = req.getSession().getAttribute("member");
		Criteria cri = new Criteria(req);
		String redirectUrl = "list?" + cri.getQs2();
		
		if(pnoStr == null || memberObject == null) {
			printMsg("비정상적인 접근입니다",redirectUrl, resp);
			return;
		}
		Long pno = Long.valueOf(pnoStr);
		Member m = (Member) memberObject;
		if(!m.getId().equals(service.findBy(pno).getWriter())) {
			printMsg("본인이 작성한 글만 삭제할 수 있습니다.", redirectUrl, resp);
			return;
		}
		service.remove(pno);
		
		
		resp.sendRedirect(redirectUrl);
	}
	
	void printMsg(String msg, String url, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<script>");
		pw.printf("alert('%s'); %n", msg);
		pw.printf("location.href = '%s';%n", url);
		pw.println("</script>");
	}
			
}
