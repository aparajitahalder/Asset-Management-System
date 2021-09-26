package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Asset;
import beans.Borrower;
import service.AssetInterface;
import service.AssetInterfaceImpl;
import service.BorrowInterface;
import service.BorrowInterfaceImpl;

/**
 * Servlet implementation class OverDueAssetManagement
 */
@WebServlet("/sendMessage")
public class SendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SendMessage() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String msg=request.getParameter("msg");
		int bid=Integer.parseInt(request.getParameter("bid"));
		
		//Testing Purpose
		//PrintWriter out=response.getWriter();
		//out.println(msg);
		
		  BorrowInterface bservice=new BorrowInterfaceImpl(); 
		  int status=bservice.sendMessage(bid,msg);
		  //out.println(status);
		  request.setAttribute("msg", msg); 
		  RequestDispatcher rd=request.getRequestDispatcher("AdminHomepage.jsp"); 
		  rd.forward(request,response);
		 
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
