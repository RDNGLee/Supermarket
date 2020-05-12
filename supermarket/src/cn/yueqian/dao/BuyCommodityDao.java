package cn.yueqian.dao;

import java.util.List;

import cn.yueqian.bean.Sell_info;

public interface BuyCommodityDao {
	void insertSell_info(Sell_info sell_info);
	List<Sell_info> querySell_info();
}
