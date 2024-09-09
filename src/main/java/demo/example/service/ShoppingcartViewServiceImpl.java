package demo.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import demo.example.model.ShoppingcartView;
import demo.example.model.ShoppingcartViewRepository;

@Service
public class ShoppingcartViewServiceImpl implements ShoppingcartViewService {

	@Autowired
	private ShoppingcartViewRepository svr;
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Override
	public List<ShoppingcartView> getAllShoppingcartView() {
		List<ShoppingcartView> shoppingcartViews = svr.findAll();
		return shoppingcartViews;
	}
	@SuppressWarnings("deprecation")
	@Override
	public List<ShoppingcartView> getShoppingcartViewByMemberId(String memberId) {
        String sql = "SELECT * FROM bookshop.shoppingcartlist WHERE memberId = ?";
        return jdbcTemplate.query(sql, new Object[]{memberId}, (rs, rowNum) -> {
            ShoppingcartView view = new ShoppingcartView();
            view.setMemberId(rs.getString("memberId"));
            view.setMemberName(rs.getString("memberName"));
            view.setBookId(rs.getString("bookId"));
            view.setBookName(rs.getString("bookName"));
            view.setAuthor(rs.getString("author"));
            view.setPublisherName(rs.getString("publisherName"));
            view.setCategory(rs.getString("category"));
            view.setQuantity(rs.getInt("quantity"));
            view.setPrice(rs.getBigDecimal("price"));
            return view;
        });
    }

}
