package cn.yueqian.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yueqian.bean.Employee;
import cn.yueqian.bean.Sell_info;
import cn.yueqian.bean.Vip;
import cn.yueqian.dao.VipDao;
import cn.yueqian.utils.JDBCUtils;

public class VipDaoImpl implements VipDao {
	// 查询会员是否存在
	@Override
	public Vip findVip(String vipid) {
		Vip vip = new Vip();
		String sql = "select * from vip where v_number=?";
		String[] str = { vipid };
		ResultSet rs = JDBCUtils.executeQuery(sql, str);
		try {
			if (rs.next()) {
				vip.setV_number(rs.getString("v_number"));
				vip.setV_name(rs.getString("v_name"));
				vip.setV_score(rs.getInt("v_score"));
				vip.setV_phone(rs.getString("v_phone"));
				vip.setV_date(rs.getString("v_date"));
				return vip;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close();
		}
		return null;
	}

	@Override
	public void updateVip(String vipid, String str1, String str2) {
		String sql = "update vip set " + str1 + "=? where v_number=?";
		String[] str = { str2, vipid };
		int rs = JDBCUtils.executeUpdate(sql, str);
		System.out.println("修改成功");
		JDBCUtils.close();
	}

	@Override
	public void deleteVip(String vipid) {
		String sql = "delete from vip where v_number=?";
		String[] str = { vipid };
		int rs = JDBCUtils.executeUpdate(sql, str);
		System.out.println("删除成功");
		JDBCUtils.close();
	}

	@Override
	public void insertVip(Vip vip) {
		String sql = "insert into vip values (?,?,0,?,now())";
		String[] str = { vip.getV_number(), vip.getV_name(), vip.getV_phone()};
		int rs = JDBCUtils.executeUpdate(sql, str);
		System.out.println("添加成功");
		JDBCUtils.close();
	}

	@Override
	public List<Vip> queryVip() {
		List<Vip> list = new ArrayList<Vip>();
		String sql = "select * from vip";
		String[] str = {};
		ResultSet rs = JDBCUtils.executeQuery(sql, str);
		try {
			while (rs.next()) {
				Vip vip = new Vip();
				vip.setV_date(rs.getString("v_date"));
				vip.setV_name(rs.getString("v_name"));
				vip.setV_number(rs.getString("v_number"));
				vip.setV_phone(rs.getString("v_phone"));
				vip.setV_score(rs.getInt("v_score"));
				list.add(vip);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close();
		}
		return list;
	}

	
}


