package cn.yueqian.service;

import cn.yueqian.bean.Employee;
import cn.yueqian.bean.Vip;

public interface VipServise {
	void addVip(Employee emp);
	void updateVip(Employee emp);
	void deleteVip(Employee emp);
	void getAllVip();
	Vip vipLogin(String vipid);
}
