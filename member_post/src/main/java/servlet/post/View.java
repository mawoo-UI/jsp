package servlet.post;

import java.io.IOException;
import java.security.Provider.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PostService;
import service.PostServiceImpl;
import utils.Commons;


@WebServlet("/post/view")
public class View extends HttpServlet{
	private PostService service = new PostServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pnoString = req.getParameter("pno");
		if(pnoString == null) {
			Commons.printMsg("비정상적인 접근입니다.", "list", resp);
			return;
		}
		Long pno = Long.valueOf(pnoString);
		
		req.setAttribute("post", service.view(pno));
		req.getRequestDispatcher("/WEB-INF/jsp/post/view.jsp").forward(req, resp);
	
	}
}
