package Basket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketServiceImpl implements BasketService {
	@Autowired private BasketDAO dao;
	
	@Override
	public boolean cart_insert(CartVO vo) {
	
		return dao.cart_insert(vo);
	}

	@Override
	public List<CartVO> cart_select(String member_id) {
		// TODO Auto-generated method stub
		return dao.cart_select(member_id);
	}


}
