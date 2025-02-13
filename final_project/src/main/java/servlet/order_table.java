package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bill;
import service.web_service;



@WebServlet("/order_table")
public class order_table extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public order_table() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		web_service service1=new web_service();
		ArrayList<Bill> custom = service1. getAllOrders();
		request.setAttribute("cust", custom);
		RequestDispatcher dispacher=request.getRequestDispatcher("order.jsp");
		dispacher.forward(request, response);
	}

}
