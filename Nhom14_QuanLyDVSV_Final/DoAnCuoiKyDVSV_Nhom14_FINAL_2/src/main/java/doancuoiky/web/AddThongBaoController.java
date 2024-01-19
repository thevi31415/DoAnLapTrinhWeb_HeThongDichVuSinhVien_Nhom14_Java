package doancuoiky.web;

import java.io.IOException;
import java.security.SecureRandom;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import doancuoiky.dao.ThongBaoDao;
import doancuoiky.model.NguoiDung;
import doancuoiky.model.ThongBao;

/**
 * Servlet implementation class AddThongBaoController
 */
@WebServlet("/views/CTSV/themthongbao")
public class AddThongBaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final String PREFIX = "TB";
	    private static final int TOKEN_LENGTH = 7; // 9
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddThongBaoController() {
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
		  // Đọc dữ liệu từ form
		String maThongBao = generateRandomToken() ;
        String maNguoiNhan = request.getParameter("MaNguoiNhan");
        String tieuDe = request.getParameter("TieuDe");
        String noiDung = request.getParameter("NoiDung");

        Date ngayguoi = new java.sql.Date(System.currentTimeMillis());
        
        HttpSession session = request.getSession();
       
		NguoiDung nguoidung1 = (NguoiDung)session.getAttribute("NguoiDung");
        String maNguoigui = nguoidung1.getMaNguoiDung();
        
        
        ThongBao thongbao =  new ThongBao();
        ThongBaoDao thongbaodao = new ThongBaoDao();
        thongbao.setMaNguoiGui(maNguoigui);
        thongbao.setMaNguoiNhan(maNguoiNhan);
        thongbao.setNoiDung(noiDung);
        thongbao.setTieuDe(tieuDe);
        thongbao.setNgayGui(ngayguoi);
        thongbao.setMaTB(maThongBao);
        try {
            thongbaodao.addNewNotification(thongbao);
            // Đặt thông báo thành công vào request attribute
            request.setAttribute("thongBao", "Thông báo đã được gửi thành công!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Đặt thông báo không thành công vào request attribute
            request.setAttribute("thongBao", "Có lỗi xảy ra, không thể gửi thông báo.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        System.out.print("Trang thai them thong bao");
        
        // Thực hiện xử lý dữ liệu (ví dụ: lưu vào cơ sở dữ liệu)

        // Trả về kết quả (có thể chuyển hướng đến trang khác)
        response.getWriter().println("Thông báo đã được gửi thành công!" + maNguoigui);
    
	}
	public static String generateRandomToken() {
		
        SecureRandom random = new SecureRandom();
        StringBuilder token = new StringBuilder(PREFIX);

        for (int i = 0; i < TOKEN_LENGTH; i++) {
            char randomChar = (char) (random.nextInt(26) + 'A');
            token.append(randomChar);
        }

        return token.toString();
    }

}
