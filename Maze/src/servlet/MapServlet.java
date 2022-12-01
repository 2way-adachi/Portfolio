package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Current;
import model.Map;

/**
 * Servlet implementation class MapServlet
 */
@WebServlet("/MapServlet")
public class MapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String getDirection = request.getParameter("direction");
		HttpSession session = request.getSession();
		Map map = (Map) session.getAttribute("map");
		Current c = (Current) session.getAttribute("current");
		session.removeAttribute("map");
		session.removeAttribute("viewMap");
		session.removeAttribute("current");
		
		switch (getDirection) {
		case "up":
			map.setMap(c.moveCurrent(map.getMap(), 0, -1));
			break;
		case "left":
			map.setMap(c.moveCurrent(map.getMap(), -1, 0));
			break;
		case "right":
			map.setMap(c.moveCurrent(map.getMap(), 1, 0));
			break;
		case "down":
			map.setMap(c.moveCurrent(map.getMap(), 0, 1));
			break;
		}
//		System.out.println("c="+c.getX()+":"+c.getY());
		if(c.isGoal()) {
//			System.out.println("clere");
			request.setAttribute("current", c);
			request.getRequestDispatcher("/WEB-INF/jsp/result.jsp").forward(request, response);
		}else {
		session.setAttribute("map", map);
		session.setAttribute("viewMap", map.getViewMap());
		session.setAttribute("current", c);
		request.getRequestDispatcher("/WEB-INF/jsp/maze.jsp").forward(request, response);
		}
	}

}
