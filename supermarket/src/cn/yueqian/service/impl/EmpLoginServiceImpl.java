package cn.yueqian.service.impl;

import cn.yueqian.bean.Employee;
import cn.yueqian.bean.Vip;
import cn.yueqian.dao.EmployeeDao;
import cn.yueqian.dao.impl.EmployeeDaoImpl;
import cn.yueqian.service.EmpLoginService;

public class EmpLoginServiceImpl implements EmpLoginService {

	@Override
	public Employee login(String userid, String password) {
		//调用dao里面的findUser来查找是否有这个用户
		EmployeeDao empDao=new EmployeeDaoImpl();
		Employee emp=empDao.findUser(userid);
		if (emp!=null&&emp.getRole()!=0) {
			if (emp.getPassword().equals(password)) {
				System.out.println("登陆成功");
				return emp;
			}else {
				System.out.println("密码错误");
			}
		}else {
			System.out.println("没有此用户");
		}
		return null;
	}

	

}
