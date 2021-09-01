package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/iam", loadOnStartup = 10)
public class Iam extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "/basic/source.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String iam = "그래, 난 " + name + ". 포기를 모르는 남자지";
		request.setAttribute("iam", iam);
		doProcess(request, response, "/basic/target.jsp");
	}

	private void doProcess(
			HttpServletRequest request, HttpServletResponse response, String viewName) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
		dispatcher.forward(request, response);
	}
}
