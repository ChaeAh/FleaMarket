package goodsAction;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.goodsDAO;
import vo.goodsDTO;

/**
 * Servlet implementation class FashionList
 */
@WebServlet("/fm/CaList.do")
public class CategoryList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		goodsDAO dao = goodsDAO.getInstance();
		String category = request.getParameter("category");
		ArrayList<goodsDTO> arr = dao.goodsList(category);
		request.setAttribute("lists", arr);
		response.setContentType("text/html; charset=UTF-8");
		
		if(category.equals("fashion")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("../fm/fashionPage.jsp");
			dispatcher.forward(request, response);
		}
		else if(category.equals("living")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("../fm/livingPage.jsp");
			dispatcher.forward(request, response);
		}
		else if(category.equals("hobby")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("../fm/hobbyPage.jsp");
			dispatcher.forward(request, response);
		}
		else if(category.equals("food")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("../fm/foodPage.jsp");
			dispatcher.forward(request, response);
		}
		else if(category.equals("pet")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("../fm/petPage.jsp");
			dispatcher.forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}