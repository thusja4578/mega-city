package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.database;
import model.Bill;
import model.register;

import model.vehicle;




public class web_service {
	//************************************************************************************************************************************************
	//register user

	public void reg_user(register app1)
	{
		try {
			String query="insert into reg values ('"+app1.getRegistration_number()+"','"+app1.getName()+"','"+app1.getAddress()+"','"+app1.getNic()+"','"+app1.getUsername()+"','"+app1.getPassword()+"')";
			Statement state=database.getcon().createStatement();
			state.executeUpdate(query);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//**********************************************************************************************************************************************************
//bill table
	 public ArrayList<Bill> getAllOrders()
		{
			try {
				ArrayList<Bill> listcus=new ArrayList<Bill>();
				String query="select*from bill";
				Statement statement=database.getcon().createStatement();
				ResultSet rs=statement.executeQuery(query);
				while(rs.next())
				{
					Bill cus11=new Bill(query, query, query, 0, query, 0, 0);
				
					
				cus11.setId(rs.getInt("id"));
				cus11.setBookingNumber(rs.getString("bookingNumber"));
				cus11.setCustomerName(rs.getString("CustomerName"));
				cus11.setAddress(rs.getString("Address"));
				cus11.setTelephone(rs.getInt("Telephone"));
				cus11.setDestinationAddress(rs.getString("DestinationAddress"));
				cus11.setDistance(rs.getInt("Distance"));
				cus11.setVehicle(rs.getInt("Vehicle"));
				cus11.setAmount(rs.getInt("Amount"));
				
					
					listcus.add(cus11);
					
				}
				return listcus;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
//********************************************************************************************************************************************************
	// add vehicles 
	 public void add_vehicle(vehicle app1)
		{
			try {
				String query="insert into vehicle values ('"+app1.getPlate()+"','"+app1.getBrand()+"','"+app1.getModel()+"','"+app1.getColor()+"','"+app1.getAngine()+"','"+app1.getChasi()+"','"+app1.getName()+"','"+app1.getEmail()+"','"+app1.getPhone()+"','"+app1.getIdnum()+"','"+app1.getProvider()+"','"+app1.getPolicy()+"','"+app1.getExpire()+"')";
				Statement state=database.getcon().createStatement();
				state.executeUpdate(query);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
//**************************************************************************************************************************************************
	 //vehicle table 
	 public ArrayList<vehicle> getallvehicle()
		{
			try {
				ArrayList<vehicle> listcus=new ArrayList<vehicle>();
				String query="select*from vehicle";
				Statement statement=database.getcon().createStatement();
				ResultSet rs=statement.executeQuery(query);
				while(rs.next())
				{
					vehicle cus1=new vehicle();
					cus1.setPlate(rs.getString("plate"));
					cus1.setBrand(rs.getString("brand"));
					cus1.setModel(rs.getString("model"));
					cus1.setColor(rs.getString("color"));
					cus1.setAngine(rs.getString("engine"));
					cus1.setChasi(rs.getString("chasi"));
					cus1.setName(rs.getString("name"));
					cus1.setEmail(rs.getString("email"));
					cus1.setPhone(rs.getInt("phone"));
					cus1.setIdnum(rs.getInt("idnum"));
					cus1.setProvider(rs.getString("provider"));
					cus1.setPolicy(rs.getString("policy"));
					cus1.setExpire(rs.getString("expire"));
					
					listcus.add(cus1);
				}
				return listcus;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	 //*********************************************************************************************************************************
	 //vehicle update
	 public boolean updatevehicle(String platee,String brands,String modell,String colorr,String enginee,String chasi,String namee,String emaill,int phonee,int idnumm,String providerr,String policyy,String expiree) {
	        try (Connection con = database.getcon()) {
	            String query = "UPDATE vehicle SET brand = ?, model = ?, color=?, engine=?, chasi=?, name=?, email=?, phone=?, idnum=?, provider=?, policy=?, expire=? WHERE plate = ?";
	            PreparedStatement ps = con.prepareStatement(query);
	          
	            
	            ps.setString(1, brands);
	            ps.setString(2, modell);
	            ps.setString(3, colorr);
	            ps.setString(4, enginee);
	            ps.setString(5, chasi);
	            ps.setString(6, namee);
	            ps.setString(7, emaill);
	            ps.setInt(8, phonee);
	            ps.setInt(9, idnumm);
	            ps.setString(10, providerr);
	            ps.setString(11, policyy);
	            ps.setString(12, expiree);
	            ps.setString(13, platee);

	            int rowsUpdated = ps.executeUpdate();
	            return rowsUpdated > 0;
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
}
