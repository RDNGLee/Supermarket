package cn.yueqian.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yueqian.bean.Employee;
import cn.yueqian.bean.Goods;
import cn.yueqian.dao.CommodityDao;
import cn.yueqian.utils.JDBCUtils;

public class CommodityDaoImpl implements CommodityDao {

	List<Goods> list = new ArrayList<Goods>();
	@Override
	public Goods findCommodity(String c_number) {
		Goods comGoods=new Goods();
		String sql = "select * from goods where c_number=?";
		String[] str = { c_number };
		ResultSet rs = JDBCUtils.executeQuery(sql, str);
		try {
			if (rs.next()) {
				comGoods.setC_number(rs.getInt("c_number"));
				comGoods.setC_name(rs.getString("c_name"));
				comGoods.setC_price(rs.getFloat("c_price"));
				comGoods.setInventory(rs.getInt("inventory"));
				comGoods.setVip_price(rs.getString("vip_price"));
				return comGoods;
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
	public void insertCommodity(Goods goods) {
		String sql = "insert into goods (c_name,c_price,vip_price,inventory) values (?,?,?,?)";
		String[] str = {goods.getC_name(),goods.getC_price()+"",(goods.getC_price()*0.8)+"",goods.getInventory()+""};
		int rs = JDBCUtils.executeUpdate(sql, str);
		System.out.println("添加成功");
		JDBCUtils.close();
		
	}

	@Override
	public void updateCommodity(String number, String str1, String str2) {
		String sql = "update goods set " + str1 + "=? WHERE c_number=?";
		String[] str = { str2, number };
		int rs = JDBCUtils.executeUpdate(sql, str);
		System.out.println("修改成功");
		JDBCUtils.close();
		
	}

	@Override
	public void deleteCommodity(String number) {
		String sql = "delete from goods where c_number=?";
		String[] str = { number };
		int rs = JDBCUtils.executeUpdate(sql, str);
		System.out.println("删除成功");
		JDBCUtils.close();
	}

	@Override
	public List<Goods> getAllGoods() {
		String sql = "select * from goods";
		String[] str = {};
		ResultSet rs = JDBCUtils.executeQuery(sql, str);
		try {
			while (rs.next()) {
				Goods comGoods=new Goods();
				comGoods.setC_number(rs.getInt("c_number"));
				comGoods.setC_name(rs.getString("c_name"));
				comGoods.setC_price(rs.getFloat("c_price"));
				comGoods.setInventory(rs.getInt("inventory"));
				comGoods.setVip_price(rs.getString("vip_price"));
				list.add(comGoods);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close();
		}
		return null;
	}

	public List<Goods> getCommodityInven() {
		String sql="select * from goods where  inventory<100";
		String[] str={};
		ResultSet rs = JDBCUtils.executeQuery(sql, str);
		try {
			while (rs.next()) {
				Goods comGoods=new Goods();
				comGoods.setC_number(rs.getInt("c_number"));
				comGoods.setC_name(rs.getString("c_name"));
				comGoods.setC_price(rs.getFloat("c_price"));
				comGoods.setInventory(rs.getInt("inventory"));
				comGoods.setVip_price(rs.getString("vip_price"));
				list.add(comGoods);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close();
		}
		return null;
		
	}
	
	public void updateCommodityInver(String number,String c_number) {
		String sql = "update goods set inventory=inventory+? where c_number=?";
		String[] str = { number, c_number };
		int rs = JDBCUtils.executeUpdate(sql, str);
		System.out.println("修改成功");
		JDBCUtils.close();
	}

}
