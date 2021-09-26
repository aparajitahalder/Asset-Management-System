package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exceptions.AssetNotAddedException;
import beans.Asset;
import dao.AssetDaoIntf;
import dao.AssetDaoImpl;
import service.AssetInterface;
import service.AssetInterfaceImpl;

/**
 * Servlet implementation class addAsset
 */
@WebServlet("/addAsset")
public class addAsset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String assetType=request.getParameter("aid");
		String assetName = request.getParameter("aname");
		String assetDesc = request.getParameter("desc");
		
		PrintWriter out=response.getWriter();
		
		response.setContentType("text/html");
		Asset a=new Asset(assetType,assetName,assetDesc);
		AssetInterface aservice=new AssetInterfaceImpl();
		
		try {
			String s=aservice.addAsset(a);
		} catch (SQLException | AssetNotAddedException e) {
			
			e.printStackTrace();
		}
		

		RequestDispatcher rd=request.getRequestDispatcher("AdminHomepage.jsp");
		rd.forward(request, response);
		
		
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
