package cn.yueqian.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.yueqian.bean.Clock_info;
import cn.yueqian.bean.Employee;
import cn.yueqian.dao.impl.EmployeeDaoImpl;
import cn.yueqian.service.ClockInOrOutService;

public class ClockInOrOutServiceImpl implements ClockInOrOutService {
	EmployeeDaoImpl empDao = new EmployeeDaoImpl();

	// 上班打卡
	@Override
	public void ClockIn(Employee emp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Clock_info> list = empDao.getAllClock_infos();
		String dateIn = sdf.format(new Date());
		for (int i = 0; i < list.size(); i++) {
			if (emp.getNumber().equals(list.get(i).getEmployee_no())&&list.get(i).getClock_date().equals(dateIn)) {
				if (list.get(i).getClock_in_time() != null) {
					System.out.println("不能重复打卡");
					return;
				}
			}
		}
		empDao.updateClockIn(dateIn, emp);
	}

	// 下班打卡
	@Override
	public void ClockOut(Employee emp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Clock_info> list = empDao.getAllClock_infos();
		String dateout = sdf.format(new Date());
		for (int i = 0; i < list.size(); i++) {
			if (emp.getNumber().equals(list.get(i).getEmployee_no())&&list.get(i).getClock_date().equals(dateout)) {
				if (list.get(i).getClock_off_time() != null) {
					System.out.println("不能重复打卡");
					return;
				}
			}
		}
		empDao.updateClockOut(dateout, emp);
	}

	@Override
	public void insertClock(Employee emp) {
		List<Clock_info> list = empDao.getAllClock_infos();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateout = sdf.format(new Date());
		for (int i = 0; i < list.size(); i++) {
			if (emp.getNumber().equals(list.get(i).getEmployee_no())) {
				if (list.get(i).getClock_date().equals(dateout)) {
					return;
				}
			}
		}
		empDao.insertClock(emp.getNumber());
	}

	@Override
	public Clock_info getClock() {

		return null;
	}

}
