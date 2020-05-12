package cn.yueqian.dao;

import java.util.List;

import cn.yueqian.bean.Sell_info;
import cn.yueqian.bean.Vip;

public interface VipDao {
	Vip findVip(String vipid);
	void insertVip(Vip vip);
	void updateVip(String vipid,String str1,String str2);
	void deleteVip(String vipid);
	List<Vip> queryVip();
	
}
