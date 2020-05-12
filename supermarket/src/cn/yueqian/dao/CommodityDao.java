package cn.yueqian.dao;

import java.util.List;

import cn.yueqian.bean.Employee;
import cn.yueqian.bean.Goods;

public interface CommodityDao {
	Goods findCommodity(String number);
	void insertCommodity(Goods goods);
	void updateCommodity(String number,String str1,String str2);
	void deleteCommodity(String number);
	List<Goods> getAllGoods();
}
