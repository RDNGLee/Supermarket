package cn.yueqian.service;

import cn.yueqian.bean.Employee;

public interface CommodityService {
	void addCommodity(Employee emp);
	void updateCommodity(Employee emp);
	void deleteCommodity(Employee emp);
	void getAllCommodity(Employee emp);
}
