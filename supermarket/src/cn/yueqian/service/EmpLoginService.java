package cn.yueqian.service;

import cn.yueqian.bean.Employee;
import cn.yueqian.bean.Vip;

public interface EmpLoginService {
	Employee login(String userid,String password);
}
