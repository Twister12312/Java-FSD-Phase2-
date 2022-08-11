package com.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;

/**
 * Servlet Filter implementation class ProductFilter
 */
@WebFilter("/SelectProduct")
public class ProductFilter extends HttpServlet implements Filter {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id"); 
		int flag=0;
		// pass the request along the filter chain
		try {
			int prodId=Integer.parseInt(id);
			chain.doFilter(request, response);
			flag=1;
		}
		catch(Exception e) {
			if(flag==0) out.println("<h1>Wrong input type!</h1>");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
