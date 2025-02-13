package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.register;
import service.web_service;


@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public add() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		register app1=new register();
		app1.setRegistration_number(request.getParameter("registration_number"));
		app1.setName(request.getParameter("name"));
		app1.setAddress(request.getParameter("address"));
		app1.setNic(Integer.parseInt(request.getParameter("nic")));
		app1.setUsername(request.getParameter("username"));
		app1.setPassword(request.getParameter("password"));
		
		web_service app2=new web_service();
		app2.reg_user(app1);
RequestDispatcher diss=request.getRequestDispatcher("home.jsp");
		
		diss.forward(request, response);
		
	}

}
