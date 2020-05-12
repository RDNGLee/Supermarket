package cn.yueqian.action;

import java.util.Scanner;

import cn.yueqian.bean.Employee;
import cn.yueqian.service.EmpManagerService;
import cn.yueqian.service.impl.EmpManageServiceImpl;

public class EmployeeManage {
	//员工管理页面
	public void empManage(Employee emp){
		EmpManageServiceImpl empMS=new EmpManageServiceImpl();
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		System.out.println("                               ※※※※※※※欢迎来到员工管理页面※※※※※※※");
		System.out.println("请选择操作：\n\t1.添加员工\t2.修改员工\t3.删除员工\t4.查询收银员和采购员\n\t5.查询考勤信息\t0.回到上一层\t00.退出程序\n★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★这是我的底线★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		Scanner scanner = new Scanner(System.in);
		System.out.print(">");
		switch (scanner.next()) {
		case "1":
			empMS.addEmployee(emp);
			empManage(emp);
			break;
		case "2":
			empMS.updateEmployee(emp);
			empManage(emp);
			break;
		case "3":
			empMS.deleteEmployee(emp);
			empManage(emp);
			break;
		case "4":
			empMS.getAllEmployee(emp);
			empManage(emp);
			break;
		case "5":
			empMS.getAllCheckInfo();
			empManage(emp);
			break;
		case "0":
			View.adminIndex(emp);
			break;
		case "00":
			System.out.println("退出成功");
			System.exit(0);
			break;
		default:
			System.out.println("输入有误");
			empManage(emp);
			break;
		}
	}
}
