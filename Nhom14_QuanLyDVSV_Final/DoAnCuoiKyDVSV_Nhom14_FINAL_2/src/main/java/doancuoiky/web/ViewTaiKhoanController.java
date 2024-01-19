package doancuoiky.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doancuoiky.dao.LoginDao;
import doancuoiky.model.Login;

/**
 * Servlet implementation class ViewTaiKhoanController
 */
@WebServlet("/views/QTVHT/viewtaikhoan")
public class ViewTaiKhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTaiKhoanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String id = request.getParameter("sid");
		 System.out.print(id);
		 System.out.print("Trang thai xoa");
		 LoginDao logindao = new LoginDao();
		 Login taikhoan = new Login();
		 taikhoan = logindao.selectLoginsByMaNguoiDung(id).get(0);
	        request.setAttribute("xemtaikhoan", taikhoan);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/QTVHT/xemtaikhoan.jsp");
	        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
