package net.aurore.front;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.aurore.core.AuroreConsoleMessages;

/**
 * Servlet implementation class Console
 */
@WebServlet("")
public class Console extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	private static final String VIEW  = "/WEB-INF/console.jsp";
    private static final String ATT_LIST = "console_messages";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Console() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute(ATT_LIST, AuroreConsoleMessages.getHistoric());
		this.getServletContext().getRequestDispatcher(VIEW).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
