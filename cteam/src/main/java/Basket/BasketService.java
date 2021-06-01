package Basket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface BasketService {

	boolean cart_insert(CartVO vo);
	
	List<CartVO> cart_select(String member_id);

}
