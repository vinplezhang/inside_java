package com.zwp.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletA
 */
@WebServlet("/ServletA")
public class ServletA extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static ThreadLocal<String> name =new ThreadLocal<String>();
	//PrintWriter output;
	
	
	

    /**
     * Default constructor. 
     */
    public ServletA() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		name = request.getParameter("name");
		System.out.println("request name:"+name);
		
		PrintWriter output = response.getWriter();
		System.out.println("output:"+output);
		System.out.println("current Threadf:"+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		output.append("name:").append(name);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
