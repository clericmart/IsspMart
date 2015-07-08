package ua.web.martynenko.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name="db", displayName="DataBase Servlet", urlPatterns={"/db"})
public class DBServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String URL = "jdbc:mysql://localhost:3306/testdb";
	private static final String USER = "root";
	private static final String PASS = "root";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/issp");
			try(Connection con = ds.getConnection()) {
				String SQL = "INSERT INTO user (name) VALUES (?)";
				PreparedStatement ps  = con.prepareStatement(SQL);
					ps.setString(1, req.getParameter("login"));
					ps.execute();
				Enumeration<Driver> drenum = DriverManager.getDrivers();
				while (drenum.hasMoreElements()) {
					resp.getWriter().print(drenum.nextElement());
					resp.getWriter().print("OK");}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		resp.getWriter().print("blabla");
		
	}
	
}
