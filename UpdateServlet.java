package com.sa;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateServlet extends HttpServlet{
    @Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
	   int id=Integer.parseInt(req.getParameter("id"));
	   String name=req.getParameter("sname");
	   int age=Integer.parseInt(req.getParameter("age"));
	   PrintWriter out=res.getWriter();
	   try(Connection con=DBConnection.getConnection()){
		   String sql="UPDATE st SET sname=?,age=? WHERE id=?";
		   PreparedStatement ps=con.prepareStatement(sql);
		   ps.setString(1,name);
		   ps.setInt(2, age);
		   ps.setInt(3, id);
		   
		   int rows=ps.executeUpdate();
		   
		   out.println("<!DOCTYPE html>");
           out.println("<html><head><title></title></head><body>");
           out.print("<h3>");
		   out.println(rows>0 ? "User Updated Succesfully!! ": "Update failed !");
		   out.println("</h3>");
           out.println("</body></html>");
	   }catch(Exception e) {
		   e.printStackTrace(out);
	   }
   }
}
