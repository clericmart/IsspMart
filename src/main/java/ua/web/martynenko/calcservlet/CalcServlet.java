package ua.web.martynenko.calcservlet;

import java.util.ArrayList;

import ua.web.martynenko.calcservlet.CalcOperations;
import ua.web.martynenko.calcservlet.OperationType;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CalcServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1426068165852851617L;
	

	@SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet CalcServlet</title>");
		out.println("</head>");
		out.println("<body>");
		
		try {	
			

			double one = Double.valueOf(request.getParameter("one"));
			double two = Double.valueOf(request.getParameter("two"));
			String operation = request.getParameter("operation");
			

			HttpSession session = request.getSession(true);
			
			OperationType operType = OperationType.valueOf(operation.toUpperCase());
			
			double result = calcResult(operType, one, two);
			
			ArrayList<String> listOperation;
			
			if (session.isNew()) {
				listOperation = new ArrayList<String>();
			} else {
				listOperation = (ArrayList<String>) session.getAttribute("formula");
			}
			

			listOperation.add(one + " " + operType.getStringValue() + " " + two + " = " + result);
			session.setAttribute("formula", listOperation);
			

            out.println("<h1>ID equels: " + session.getId() + "</h1>");
            out.println("<h3>Operation list (sum:" + listOperation.size() + ") </h3>");

            for (String oper : listOperation) {
                out.println("<h3>" + oper + "</h3>");
            }			
			
		} catch (Exception e) {
			out.println("<h3 style=\"color:red;\">Error, check parametrs</h3>");
            out.println("<h3>Names of parametrs one, two, operation</h3>");
            out.println("<h3>Operations: add, subtract, multiply, divide</h3>");
            out.println("<h1>Example</h1>");
            out.println("<h3>?one=1&two=3&operation=add</h3>");	
		} finally {
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
	}
	
	private double calcResult (OperationType operType, double one, double two) {
		double result = 0;
		switch (operType) {
			case ADD: {
				result = CalcOperations.add(one, two);
				break;
			}
			case SUBSTRACT: {
				result = CalcOperations.subtract(one, two);
				break;
			}
			case DIVIDE: {
				result = CalcOperations.divide(one, two);
				break;
			}
			case MULTIPLY: {
				result = CalcOperations.multiply(one, two);
				break;
			}		
		}		
		return result;
	}
}
