select  prd_no, prd_nm, IMG_GEN_FILE_NM, qty
from (select o.prd_no, p.prd_nm, p.IMG_GEN_FILE_NM, o.qty  
		from tb_product p, (select prd_no,sum(qty) qty from TB_ORDER_PRODUCT group by prd_no) o   
		where o.prd_no=p.prd_no 
		order by o.qty desc)
where rownum <=8;




select prd_no,sum(qty) qty from TB_ORDER_PRODUCT group by prd_no order by qty desc