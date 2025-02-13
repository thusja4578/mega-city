package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.driver;
import service.web_service;



@WebServlet("/adddriver")
public class adddriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public adddriver() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		driver app11=new driver();
		app11.setName(request.getParameter("name"));
		app11.setAddress(request.getParameter("address"));
		app11.setContact(Integer.parseInt(request.getParameter("contact")));
		app11.setDob(request.getParameter("dob"));
		app11.setIdnum(Integer.parseInt(request.getParameter("idnum")));
		app11.setLicen(Integer.parseInt(request.getParameter("licen")));
		
		web_service app2=new web_service();
		app2.add_driver(app11);
RequestDispatcher diss=request.getRequestDispatcher("adminhome.jsp");
		
		diss.forward(request, response);
		
		
	}

}
