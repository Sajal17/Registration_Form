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
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
      protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
    	  int id=Integer.parseInt(req.getParameter("id"));
    	  
    	  PrintWriter out=res.getWriter();
    	  try(Connection con=DBConnection.getConnection()){
    		  String sql = "DELETE FROM st WHERE id=?";
              PreparedStatement ps = con.prepareStatement(sql);
              ps.setInt(1, id);

              int rows = ps.executeUpdate();
              out.println("<!DOCTYPE html>");
              out.println("<html><head><title></title></head><body>");
              out.print("<h3>");
              out.println(rows > 0 ? "User Deleted Successfully!" : "Delete Failed!");
              
              out.println("</h3>");
              out.println("</body></html>");
    	  } catch (Exception e) {
              e.printStackTrace(out);
          }
      }
}
