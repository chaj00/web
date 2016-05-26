package product.dao;

import static fw.Query.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import product.dto.ProductDTO;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public ArrayList<ProductDTO> productlist(Connection conn, String category)
			throws SQLException {
		
		String sql ="";
		PreparedStatement ptmt = null;
		if(category==null){
			sql = PRODUCT_LIST;
			ptmt = conn.prepareStatement(sql);
		}else{
			sql = PRODUCT_LIST_CATE;
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, category);
		}
				
		ResultSet rs = ptmt.executeQuery();
		ArrayList<ProductDTO> prdlist = new ArrayList<ProductDTO>();	
		ProductDTO prd =null; 
		while(rs.next()){
			prd = new ProductDTO(rs.getString(1),rs.getString(2),rs.getString(3),
									rs.getString(4),rs.getInt(5),rs.getString(6),
									rs.getString(7),rs.getString(8),rs.getString(9),
									rs.getString(10),rs.getString(11),rs.getString(12),
									rs.getString(13),rs.getString(14));
			prdlist.add(prd);
		}
		return prdlist;
	}

	@Override
	public ArrayList<ProductDTO> searchTopProduct(Connection conn)
			throws SQLException {

		String sql ="";
		PreparedStatement ptmt = null;
		
		sql = PRODUCT_TOP;
		ptmt = conn.prepareStatement(sql);
				
		ResultSet rs = ptmt.executeQuery();
		ArrayList<ProductDTO> toplist = new ArrayList<ProductDTO>();	
		ProductDTO prd =null; 
		while(rs.next()){
			prd = new ProductDTO();
			prd.setPrd_no(rs.getString(1));
			prd.setPrd_nm(rs.getString(2));
			prd.setImg_gen_file_nm(rs.getString(3));
			toplist.add(prd);
		}
		return toplist;
	}

	@Override
	public ProductDTO read(Connection conn, String prd_no) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
