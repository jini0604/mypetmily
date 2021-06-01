package admin;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import member.MemberVO;
import order.ItemVO;
import order.OrderListVO;

@Service
public class AdminServiceImpl implements AdminService {
@Autowired private AdminDAO dao;
	@Override
	public int item_insert(SellVO vo) {
		// TODO Auto-generated method stub
		return dao.item_insert(vo);
	}
	
	@Override
	public ListPage list(ListPage vo) {
		// TODO Auto-generated method stub
		return dao.list(vo);
	}
	
	@Override
	public MemberListPage member_list(MemberListPage vo) {

		return dao.member_list(vo);
	}
	
	@Override
	public MemberVO member_detail(String member_id) {
		// TODO Auto-generated method stub
		return dao.member_detail(member_id);
	}

	@Override
	public List<OrderListVO> order_list() {
		// TODO Auto-generated method stub
		return dao.order_list();
	}

	/*
	 * @Override public void state_update(HashMap<String, String> map) {
	 * dao.state_update(map);
	 * 
	 * }
	 */

	@Override
	public SellItemVO item_select(int item_num) {

		return dao.item_select(item_num);
	}

	@Override
	public List<OptionVO> option_select(int item_num) {
		return dao.option_select(item_num);
	}

	@Override
	public int option_delete(int item_num) {
		// TODO Auto-generated method stub
		return dao.option_delete(item_num);
	}

	@Override
	public int item_update(SellModifyVO vo) {
		// TODO Auto-generated method stub
		return dao.item_update(vo);
	}

	@Override
	public int item_delete(int item_num) {
		// TODO Auto-generated method stub
		return dao.item_delete(item_num);
	}

	
}
