package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.vehicle;
import service.web_service;



@WebServlet("/vihicledel")
public class vihicledel extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public vihicledel() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		vehicle del=new vehicle();
		del.setPlate(request.getParameter("plate"));
		web_service del_ser=new web_service();
		del_ser.del_vehicle(del);
		RequestDispatcher dis=request.getRequestDispatcher("vehicle_tb");
		dis.forward(request, response);
	}

}
