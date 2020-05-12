package cn.yueqian.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yueqian.bean.Sell_info;
import cn.yueqian.dao.BuyCommodityDao;
import cn.yueqian.utils.JDBCUtils;

public class BuyCommodityDaoImpl implements BuyCommodityDao {

	@Override
	public void insertSell_info(Sell_info info) {
		String sql = "insert into sell_info(s_c_number,s_quantity,s_time,s_e_number,s_vip,s_money)values(?,?,?,?,?,?)";
		String[] str = { info.getS_c_number() + "", info.getS_quantity() + "", info.getS_time() + "",
				info.getS_e_number(), info.getVipNumber(), info.getMoney() + "" };
		int rs = JDBCUtils.executeUpdate(sql, str);
		JDBCUtils.close();
	}

	@Override
	public List<Sell_info> querySell_info() {
		List<Sell_info> listInfos = new ArrayList<Sell_info>();
		String sql = "select * from sell_info";
		String[] str = {};
		ResultSet rs = JDBCUtils.executeQuery(sql, str);
		try {
			while (rs.next()) {
				Sell_info sInfo = new Sell_info();
				sInfo.setS_c_number(rs.getInt("s_c_number"));
				sInfo.setS_quantity(rs.getInt("s_quantity"));
				sInfo.setS_time(rs.getString("s_time"));
				sInfo.setVipNumber(rs.getString("s_vip"));
				sInfo.setS_e_number(rs.getString("s_e_number"));
				sInfo.setMoney(rs.getDouble("s_money"));
				listInfos.add(sInfo);
			}
			return listInfos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.close();
		}
		return null;
	}
	
	//获得总利润
	public double getGrossprofit() {
		String sql="select sum(s_money) as sumMoney from sell_info";
		String[] str={};
		double money=0.0;
		ResultSet rs=JDBCUtils.executeQuery(sql, str);
		try {
			if (rs.next()) {
				money=rs.getDouble("sumMoney");
			}
			return money;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.close();
		}
		return -1;
	}

}
