package product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.dto.ProductDTO;
import product.service.ProductService;
import product.service.ProductServiceImpl;


@WebServlet(name = "prdlist", urlPatterns = { "/prdlist.do" })
public class ProductListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String category = request.getParameter("category");
		String pathurl = request.getParameter("pathurl");
		
		String forwardview="";
		
		ProductService service = new ProductServiceImpl();
		ArrayList<ProductDTO> prdlist= service.productlist(category);
		request.setAttribute("prdlist", prdlist);
		

		if(category==null){
			ArrayList<ProductDTO> toplist= service.searchTopProduct();
			request.setAttribute("toplist", toplist);
			
			forwardview="/layout/indexLayout.jsp";
		}else{
			request.setAttribute("pathurl", pathurl);
			forwardview="/layout/mainLayout.jsp";
		}
		
		//요청재지정
		RequestDispatcher rd = request.getRequestDispatcher(forwardview);
		rd.forward(request, response);
	}

}
