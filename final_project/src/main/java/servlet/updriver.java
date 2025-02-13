package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.web_service;


@WebServlet("/updriver")
public class updriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public updriver() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
	        
	        
	        String namee=request.getParameter("name");
	        String addresss=request.getParameter("address");
	        int contactt=Integer.parseInt(request.getParameter("contact"));
	        String dobb=request.getParameter("dob");
	        int idnumm=Integer.parseInt(request.getParameter("idnum"));
	        int licenn=Integer.parseInt(request.getParameter("licen"));
	        

	        web_service userModell = new  web_service();
	        boolean isUpdated = userModell.updatedriver(namee,addresss,contactt,dobb,idnumm,licenn);

	        if (isUpdated) {
	            request.setAttribute("message", "User updated successfully!");
	        } else {
	            request.setAttribute("message", "Error updating user!");
	        }

	        request.getRequestDispatcher("adminhome.jsp").forward(request, response);
	}

}
