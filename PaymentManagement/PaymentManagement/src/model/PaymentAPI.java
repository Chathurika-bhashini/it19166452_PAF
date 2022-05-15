package model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.HashMap; 
import java.util.Map; 
import java.util.Scanner;




@WebServlet("/PaymentAPI") 

public class PaymentAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Payment PaymentObj = new ();
	
	public PaymentAPI()
	{
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String output = PaymentObj.insertPayment(
				request.getParameter("pyId"), 
				request.getParameter("payDes"), 
				request.getParameter("payDate"),
				request.getParameter("payAmount"),
			
				response.getWriter().write(output); 
		
		
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map paras = getParasMap(request); 
		 String output = PaymentObj.updatePayment(paras.get("hidPaymentIDSave").toString(), 
		paras.get("pyId").toString(), 
		paras.get("payDes").toString(), 
		paras.get("payDate").toString(), 
		paras.get("payAmount").toString(), 
		
		response.getWriter().write(output); 
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map paras = getParasMap(request); 
		 String output = PaymentObj.deletePayment(paras.get("pyId").toString()); 
		response.getWriter().write(output); 

		
	}

	
	// Convert request parameters to a Map
		private static Map getParasMap(HttpServletRequest request) 
		{ 
		 Map<String, String> map = new HashMap<String, String>(); 
		try
		 { 
		 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
		 String queryString = scanner.hasNext() ? 
		 scanner.useDelimiter("\\A").next() : ""; 
		 scanner.close(); 
		 String[] params = queryString.split("&"); 
		 for (String param : params) 
		 {
			 String[] p = param.split("="); 
			 map.put(p[0], p[1]); 
			 } 
			 } 
			catch (Exception e) 
			 { 
			 } 
			return map; 
		}


}