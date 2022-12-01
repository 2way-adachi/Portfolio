package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Current;
import model.Goal;
import model.Map;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = "";

		String size = (request.getParameter("size"));
		String tate = request.getParameter("height");
		String yoko = request.getParameter("width");
		int height = 0;
		int width = 0;
//		System.out.println("size=" + size + "tate=" + tate + "yoko=" + yoko);
		if (size == null && tate == "" && yoko == "") {
			error += "大きさを選択 もしくは入力してください";
		} else if ((tate == "" || yoko == "" )&& size == null) {
			error += "サイズはどちらも入力してください";
		} else if (tate != "" && yoko != "") {
			height = Integer.parseInt(tate);
			width = Integer.parseInt(yoko);
//			System.out.println(tate + "=" + height);
//			System.out.println(yoko + "=" + width);
			if (height < 5 || width < 5 || height % 2 == 0 || width % 2 == 0) {
				error += "サイズは5以上の奇数で入力してください";
			}
		}

		if (error.length() != 0) {
			System.out.println("エラーあり");
			System.out.println(error);
			request.setAttribute("error", error);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else if (size != null) {
			switch (Integer.parseInt(size)) {
			case 1:
				height = 11;
				width = 31;
				break;
			case 2:
				height = 21;
				width = 61;
				break;
			case 3:
				height = 31;
				width = 91;
				break;
			}
		}
		Map map = new Map(width, height);
		Current c = new Current(map.getMap());
		@SuppressWarnings("unused")
		Goal g = new Goal(map.getMap(), c);
		map.displayMap(map.getMap());

		HttpSession session = request.getSession();
		session.setAttribute("viewMap", map.getViewMap());
		session.setAttribute("map", map);
		session.setAttribute("current", c);
		request.getRequestDispatcher("/WEB-INF/jsp/maze.jsp").forward(request, response);

	}

}
