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

@WebServlet("/addvehicle")
public class addvehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public addvehicle() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		vehicle app1=new vehicle();
		app1.setPlate(request.getParameter("plate"));
		app1.setBrand(request.getParameter("brand"));
		app1.setModel(request.getParameter("model"));
		app1.setColor(request.getParameter("color"));
		app1.setAngine(request.getParameter("angine"));
		app1.setChasi(request.getParameter("chasi"));
		app1.setName(request.getParameter("name"));
		app1.setEmail(request.getParameter("email"));
		app1.setPhone(Integer.parseInt(request.getParameter("phone")));
		app1.setIdnum(Integer.parseInt(request.getParameter("id")));
		app1.setProvider(request.getParameter("provider"));
		app1.setPolicy(request.getParameter("policy"));
		app1.setExpire(request.getParameter("expire"));
		
		web_service app2=new web_service();
		app2.add_vehicle(app1);
RequestDispatcher diss=request.getRequestDispatcher("home.jsp");
		
		diss.forward(request, response);
		
		
	}

}
