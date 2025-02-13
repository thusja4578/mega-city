package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bill;
import service.BillService;

@WebServlet("/BillServlet")
public class BillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BillService billService = new BillService();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("download".equals(action)) {
            downloadBills(response);
        } else {
            processBill(request, response);
        }
    }

    private void processBill(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String bookingNumber = request.getParameter("order_number");
        String customerName = request.getParameter("name");
        String address = request.getParameter("address");
        int telephone = Integer.parseInt(request.getParameter("tel"));
        String destinationAddress = request.getParameter("desaddress");
        int distance = Integer.parseInt(request.getParameter("destance"));
        int vehicle = Integer.parseInt(request.getParameter("option"));

        Bill bill = new Bill(bookingNumber, customerName, address, telephone, destinationAddress, distance, vehicle);

        if (billService.saveBill(bill)) {
            response.sendRedirect("result.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private void downloadBills(HttpServletResponse response) throws IOException {
        List<Bill> bills = billService.getAllBills();
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=bills.csv");

        PrintWriter writer = response.getWriter();
        writer.println("Booking Number,Customer Name,Address,Telephone,Destination Address,Distance,Vehicle,Amount");

        for (Bill bill : bills) {
            writer.println(
                bill.getBookingNumber() + "," + 
                bill.getCustomerName() + "," + 
                bill.getAddress() + "," + 
                bill.getTelephone() + "," + 
                bill.getDestinationAddress() + "," + 
                bill.getDistance() + "," + 
                bill.getVehicle() + "," + 
                bill.getAmount()
            );
        }

        writer.flush();
        writer.close();
    }
}
