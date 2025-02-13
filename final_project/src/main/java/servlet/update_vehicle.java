package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.web_service;



@WebServlet("/update_vehicle")
public class update_vehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public update_vehicle() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        
        String platee=request.getParameter("plate");
        String brands=request.getParameter("brand");
        String modell=request.getParameter("model");
        String colorr=request.getParameter("color");
        String enginee=request.getParameter("engine");
        String chasi=request.getParameter("chasi");
        String namee=request.getParameter("name");
        String emaill=request.getParameter("email");
        int phonee=Integer.parseInt(request.getParameter("phone"));
        int idnumm=Integer.parseInt(request.getParameter("id"));
        String providerr=request.getParameter("provider");
        String policyy=request.getParameter("policy");
        String expiree=request.getParameter("expire");

        web_service userModel = new  web_service();
        boolean isUpdated = userModel.updatevehicle(platee,brands,modell,colorr,enginee,chasi,namee,emaill,phonee,idnumm,providerr,policyy,expiree);

        if (isUpdated) {
            request.setAttribute("message", "User updated successfully!");
        } else {
            request.setAttribute("message", "Error updating user!");
        }

        request.getRequestDispatcher("adminhome.jsp").forward(request, response);
    }
	}


