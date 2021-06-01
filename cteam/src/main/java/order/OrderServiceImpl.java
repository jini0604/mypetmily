package order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired OrderDAO dao;

	@Override
	public boolean order_insert(OrderVO orderVo) {
		// TODO Auto-generated method stub
		return dao.order_insert(orderVo);
	}
	


}
