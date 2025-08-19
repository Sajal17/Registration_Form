package com.sa;

import java.io.IOException;
import java.io.PrintWriter;
//import java.io.PrintWriter;
//import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/register")
public class Demo extends HttpServlet{
    @Override   
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		
    	//Get from data 
    	
    	int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("sname");
        int age = Integer.parseInt(req.getParameter("age"));
        PrintWriter out=res.getWriter();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO st (id, sname, age) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            int rows = ps.executeUpdate();

          out.println("<!DOCTYPE html>");
          out.println("<html><head><title></title></head><body>");
          out.print("<h3>");
          if (rows > 0) {
            out.print("User Inserted Successfully!");
          } else {
            out.print("Insert Failed!");
          }
          out.println("</h3>");
          out.println("</body></html>");

        } catch (Exception e) {
            e.printStackTrace(res.getWriter());
        }
    	
	}
}

//out.println(rows > 0 ? "<h3>User Inserted Successfully!</h3>" : "<h3>Insert Failed!</h3>");
//out.println("<!DOCTYPE html>");
//out.println("<html><head><title></title></head><body>");
//out.print("<h3>");
//if (rows > 0) {
//  out.print("User Inserted Successfully!");
//} else {
//  out.print("Insert Failed!");
//}
//out.println("</h3>");
//out.println("</body></html>");
//String msg = rows > 0 ? "User Inserted Successfully!" : "Insert Failed!";
//req.getRequestDispatcher("insert.jsp").forward(req,res);

//res.sendRedirect("insert.jsp");
//res.sendRedirect("insert.jsp?msg=" + URLEncoder.encode(msg, "UTF-8"));
//String msg = rows > 0 ? "User Inserted Successfully!" : "Insert Failed!";
//req.setAttribute("msg", msg);
//req.getRequestDispatcher("insert.jsp").forward(req, res);
