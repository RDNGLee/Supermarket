package cn.yueqian.service;

import cn.yueqian.bean.Clock_info;
import cn.yueqian.bean.Employee;

public interface ClockInOrOutService {
	void ClockIn(Employee emp);
	void ClockOut(Employee emp);
	void insertClock(Employee emp);
	Clock_info getClock();
}
