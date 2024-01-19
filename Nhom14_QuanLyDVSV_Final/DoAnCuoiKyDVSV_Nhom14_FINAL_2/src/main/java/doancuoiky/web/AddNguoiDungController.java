package doancuoiky.web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doancuoiky.dao.NguoiDungDao;
import doancuoiky.model.NguoiDung;

/**
 * Servlet implementation class AddNguoiDungController
 */
@WebServlet("/views/QTVHT/themnguoidung")
public class AddNguoiDungController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNguoiDungController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		    String maNguoiDung = request.getParameter("maNguoiDung");
	        String hoTen = request.getParameter("hoTen");
	        String ngaySinhStr = request.getParameter("ngaySinh");
	        // Parse the date string into a Date object (you may need to handle exceptions)
	        Date ngaySinh = Date.valueOf(ngaySinhStr);
	        String gioiTinh = request.getParameter("gioiTinh");
	        String danToc = request.getParameter("danToc");
	        String cmnd = request.getParameter("cmnd");
	        String tonGiao = request.getParameter("tonGiao");
	        String queQuan = request.getParameter("queQuan");
	        String maLop = request.getParameter("maLop");
	        String vaiTro = request.getParameter("vaiTro");
	        String maTinhTrang = request.getParameter("maTinhTrang");
	        String diaChi = request.getParameter("diaChi");
	        String sdt = request.getParameter("sdt");
	        String email = request.getParameter("email");
	        
			/*
			 * System.out.println("Mã Người Dùng: " + maNguoiDung);
			 * System.out.println("Họ Tên: " + hoTen); System.out.println("Ngày Sinh: " +
			 * ngaySinh); System.out.println("Giới Tính: " + gioiTinh);
			 * System.out.println("Dân Tộc: " + danToc); System.out.println("CMND: " +
			 * cmnd); System.out.println("Tôn Giáo: " + tonGiao);
			 * System.out.println("Quê Quán: " + queQuan); System.out.println("Mã Lớp: " +
			 * maLop); System.out.println("Vai Trò: " + vaiTro);
			 * System.out.println("Mã Tình Trạng: " + maTinhTrang);
			 * System.out.println("Địa Chỉ: " + diaChi);
			 * System.out.println("Số Điện Thoại: " + sdt); System.out.println("Emai;: " +
			 * email);
			 */
	        

	        // Create a new NguoiDung object and set its properties
	        NguoiDung nguoiDung = new NguoiDung();
	        nguoiDung.setMaNguoiDung(maNguoiDung);
	        nguoiDung.setHoTen(hoTen);
	        nguoiDung.setNgaySinh(ngaySinh);
	        nguoiDung.setGioiTinh(gioiTinh);
	        nguoiDung.setDanToc(danToc);
	        nguoiDung.setCmnd(cmnd);
	        nguoiDung.setTonGiao(tonGiao);
	        nguoiDung.setQueQuan(queQuan);
	        nguoiDung.setMaLop(maLop);
	        nguoiDung.setVaiTro(vaiTro);
	        nguoiDung.setMaTinhTrang(maTinhTrang);
	        nguoiDung.setDiaChi(diaChi);
	        nguoiDung.setSdt(sdt);
	        nguoiDung.setEmail(email);

	         NguoiDungDao nguoidungdao = new NguoiDungDao();
	         try {
				nguoidungdao.addNewUser(nguoiDung);
				 response.sendRedirect("quanlysinhvien.jsp");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
		
	}

}
