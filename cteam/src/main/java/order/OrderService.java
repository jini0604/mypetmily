package order;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public interface OrderService {
	
	boolean order_insert(OrderVO orderVo);
	
}
