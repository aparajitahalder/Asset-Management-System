package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BorrowInterface;
import service.BorrowInterfaceImpl;

@WebServlet("/ReturnAsset")
public class ReturnAsset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReturnAsset() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int aid=Integer.parseInt(request.getParameter("aid"));
		int bid=Integer.parseInt(request.getParameter("bid"));
		BorrowInterface aservice=new BorrowInterfaceImpl();
		int status=aservice.returnAsset(aid,bid);
		request.setAttribute("status", status);
		RequestDispatcher rd=request.getRequestDispatcher("HomepageUser.jsp");
		rd.forward(request,response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
