package bmi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bmi
 */
@WebServlet("/bmi")
public class bmi extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		
		double weight;
		double height;
		try {
			weight = Double.parseDouble(req.getParameter("kg"));
			height = Double.parseDouble(req.getParameter("cm"));
		} catch (Exception e) {
			req.setAttribute("error", "ÉpÉâÉÅÅ[É^Ç™ê≥ÇµÇ≠Ç†ÇËÇ‹ÇπÇÒ");
			req.getRequestDispatcher("/WEB-INF/mvc/bmi/error.jsp")
			    .forward(req, res);
			return;
		}
		
	    Person person = new Person(height, weight);
	    req.setAttribute("person", person);

	    req.getRequestDispatcher("/WEB-INF/mvc/bmi/result.jsp")
	        .forward(req, res);   
	}
}