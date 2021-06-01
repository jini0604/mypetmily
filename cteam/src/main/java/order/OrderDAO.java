package order;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO implements OrderService{

	@Autowired private SqlSession sql;

	@Override
	public boolean order_insert(OrderVO orderVo) {
			
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Calendar c1 = Calendar.getInstance();

        String strToday = sdf.format(c1.getTime());


        		
        Random r = new Random();
        int dice = r.nextInt(4589362) + 49311;
        
        

		orderVo.setOrder_num(strToday+dice);
	
		
		sql.insert("order.mapper.order_insert", orderVo);//이걸타고 또 위에서부터 다시 탐?!
		

		
		return sql.insert("order.mapper.order_goods_insert", orderVo) > 0 ? true : false;
	}

	
}
