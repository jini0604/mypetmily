package Basket;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BasketDAO implements BasketService {
	
	@Autowired private SqlSession sql;
	
	@Override
	public boolean cart_insert(CartVO vo) {

		return sql.insert("cart.mapper.cart_insert",vo) > 0 ? true : false;
	}

	@Override
	public List<CartVO> cart_select(String member_id) {

		return sql.selectList("cart.mapper.cart_select", member_id);
	}

}
