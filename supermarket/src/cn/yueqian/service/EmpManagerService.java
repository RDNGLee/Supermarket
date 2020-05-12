package cn.yueqian.service;

import cn.yueqian.bean.Employee;

public interface EmpManagerService {
	void addEmployee(Employee emp);
	void updateEmployee(Employee emp);
	void deleteEmployee(Employee emp);
	void getAllEmployee(Employee emp);
	void getAllCheckInfo();
}
