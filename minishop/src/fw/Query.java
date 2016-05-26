package fw;
//SQL만 정의하는 클래스 프레임워크 기반으로 작업을 하면 설정파일(XML)로 변경됨
public class Query {
	public static String PRODUCT_LIST 
						= "select * from TB_PRODUCT";
	public static String PRODUCT_LIST_CATE 
						= "select * from TB_PRODUCT where category_no=?";
	public static String PRODUCT_TOP
						= "select  prd_no, prd_nm, IMG_GEN_FILE_NM "
						  +"from (select o.prd_no, p.prd_nm, p.IMG_GEN_FILE_NM, o.qty "  
								 +"from tb_product p, "
											+ "(select prd_no,sum(qty) qty "
											+ "from TB_ORDER_PRODUCT group by prd_no) o "   
								 +"where o.prd_no=p.prd_no " 
								 +"order by o.qty desc) "
						  +"where rownum <=8 ";	

	
	
	

}
