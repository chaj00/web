package product.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import product.dao.ProductDAO;
import product.dao.ProductDAOImpl;
import product.dto.ProductDTO;
import static fw.JdbcTemplate.*;
public class ProductServiceImpl implements ProductService {

	@Override
	public ArrayList<ProductDTO> productlist(String category) {
		Connection conn = getConnect();
		ProductDAO dao = new ProductDAOImpl();
		ArrayList<ProductDTO> prdlist = new ArrayList<ProductDTO>();
		
		try {
			prdlist = dao.productlist(conn,category);
		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			close(conn);
		}
		return prdlist;
	}

	@Override
	public ArrayList<ProductDTO> searchTopProduct() {
		Connection conn = getConnect();
		ProductDAO dao = new ProductDAOImpl();
		ArrayList<ProductDTO> toplist = new ArrayList<ProductDTO>();
		
		try {
			toplist = dao.searchTopProduct(conn);
		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			close(conn);
		}
		return toplist;
	}

	@Override
	public ProductDTO read(String prd_no) {

		return null;
	}

}
