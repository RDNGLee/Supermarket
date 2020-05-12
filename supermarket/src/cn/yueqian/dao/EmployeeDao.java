package cn.yueqian.dao;

import java.util.List;
import cn.yueqian.bean.CheckInfo;
import cn.yueqian.bean.Clock_info;
import cn.yueqian.bean.Employee;

public interface EmployeeDao {
	Employee findUser(String userid);
	void insertEmployee(Employee emp);
	void updateEmployee(String number,String str1,String str2);
	void deleteEmployee(String number);
	List<Employee> getAllEmployee();
	List<CheckInfo> getAllCheckInfo();
	void insertClock(String empNumber);
	void updateClockIn(String datein,Employee emp);
	void updateClockOut(String dateout,Employee emp);
	List<Clock_info> getAllClock_infos();
}
