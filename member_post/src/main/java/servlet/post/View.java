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


@WebServlet("/post/view")
public class View extends HttpServlet{
	private PostService Service = new PostServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pnoString = req.getParameter("pno");
		Long bno = pnoString == null ? 1L : Long.valueOf(pnoString);
		
		req.setAttribute("posts", Service.findBy(bno));
		req.getRequestDispatcher("/WEB-INF/jsp/post/view.jsp").forward(req, resp);
	
	}
}
