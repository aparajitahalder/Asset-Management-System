package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exceptions.AssetNotFoundException;
import Exceptions.BorrowerNotFoundException;
import beans.Asset;
import beans.Borrower;
import service.AssetInterface;
import service.AssetInterfaceImpl;
//import service.AssetService;
import service.BorrowInterface;
import service.BorrowInterfaceImpl;

/**
 * Servlet implementation class searchAsset
 */
@WebServlet("/searchAsset")
public class SearchAsset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchAsset() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type=request.getParameter("type");
		String search=request.getParameter("search");
		PrintWriter out=response.getWriter();
		out.println(type);	

		response.setContentType("text/html");
		AssetInterface aservice=new AssetInterfaceImpl();
		
		
		
		if (type=="name") {
			List<Asset> alist = null;
			out.println("In type..");
			
			try {
				alist = aservice.searchAssetByName(search);
			} catch (AssetNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("alist", alist);
			//PrintWriter out=response.getWriter();
			//out.println(alist);
			RequestDispatcher rd=request.getRequestDispatcher("DisplayOverdue.jsp");
			rd.forward(request, response);
			
		}
		
		else if (type=="date") {
			
			List<Asset> alist = null;
			try {
				alist = aservice.searchAssetByDate(search);
			} catch (AssetNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("alist", alist);
			RequestDispatcher rd=request.getRequestDispatcher("DisplayOverdue.jsp");
			rd.forward(request, response);
			
		}
		else if (type=="category") {
			List<Asset> alist = null;
			try {
				alist = aservice.searchAssetByCategory(search);
			} catch (AssetNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("alist", alist);
			RequestDispatcher rd=request.getRequestDispatcher("DisplayOverdue.jsp");
			rd.forward(request, response);
			
		}
		else {
			//out.println("In else..");
			request.setAttribute("msg", "Invalid Category");
			RequestDispatcher rd=request.getRequestDispatcher("displayAsset.jsp");
			rd.include(request, response);
		}
        
		
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
