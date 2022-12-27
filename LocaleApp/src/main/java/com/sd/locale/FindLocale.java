package com.sd.locale;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FindLocale extends HttpServlet {
	
		public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
			// get print writer
			PrintWriter pw = res.getWriter();
			// set response content type
			res.setContentType("text/html");
			// read the p1 request param value
			String p1Val = req.getParameter("p1");
			Locale locales[] = Locale.getAvailableLocales();
			
			for (Locale l:locales) {
				if(p1Val.equalsIgnoreCase("link1"))
					pw.println(l.getDisplayCountry());
			else if(p1Val.equalsIgnoreCase("link2"))
					pw.println(l.getDisplayLanguage());
			else
				pw.println(System.getProperties());
					
			}
			pw.println("<br><a href='links.html>home</a>");
		}
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
			doGet(req, res);
			
		}

}
