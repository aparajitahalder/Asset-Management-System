package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exceptions.AssetNotAddedException;
import Exceptions.AssetNotFoundException;
import beans.Asset;
import beans.User;
import service.AssetInterface;
import service.AssetInterfaceImpl;
import service.BorrowInterface;
import service.BorrowInterfaceImpl;

@WebServlet("/IssueAsset")
public class IssueAsset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		//out.println("In Issue Asset..");
		String assetType=request.getParameter("assetType");
		String userName=request.getParameter("name");
		String userRole = request.getParameter("role");
		String userTelephone = request.getParameter("tel");
		String userEmail = request.getParameter("email");
		//out.println(assetType);
		User u=new User( userName, userRole, userTelephone, userEmail);
		BorrowInterface bservice = new BorrowInterfaceImpl();
		int status=0;
		try {
			status=bservice.issueAsset(u,assetType);
		} catch (AssetNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//out.println(status);
		
		request.setAttribute("status", status);
		RequestDispatcher rd=request.getRequestDispatcher("UserHomepagee.jsp");
		rd.forward(request, response);
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
