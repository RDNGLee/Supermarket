package cn.yueqian.action;

import java.util.Scanner;

import cn.yueqian.bean.Employee;
import cn.yueqian.bean.Vip;
import cn.yueqian.service.EmpLoginService;
import cn.yueqian.service.VipServise;
import cn.yueqian.service.impl.EmpLoginServiceImpl;
import cn.yueqian.service.impl.VipServiseImpl;

/**
 * 登录类
 * @author two
 *
 */
public class Login {
	public void login() {
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		System.out.println("※※※※※※※※※※※欢迎来到粤嵌超市管理系统※※※※※※※※※※");
		System.out.println("请选择操作：\n\t1.员工登陆\n\t2.会员登陆\n\t00.退出程序");
		Scanner sc = new Scanner(System.in);
		System.out.print(">");
		String in = sc.next();
		switch (in) {
		case "1":
			employeeLogin(sc);
			break;
		case "2":
			vipLogin(sc);
			break;
		case "00":
			System.out.println("退出成功");
			System.exit(0);
			break;
		default:
			System.out.println("输入有误");
			login();
			break;
		}
	}
	//员工登录
	public void employeeLogin(Scanner sc) {
		System.out.print("请输入工号：\n>");
		String number = sc.next();
		System.out.print("请输入密码：\n>");
		String password = sc.next();
		EmpLoginService empservice = new EmpLoginServiceImpl();
		Employee emp=empservice.login(number, password);
		if (emp==null) {
			System.out.println("请重新输入");
			login();
		}
		switch (emp.getRole()) {
		case 1://管理员
			View.adminIndex(emp);
			break;
		case 2://收银员
			View.cashierIndex(emp);
			break;
		case 3://采购员
			View.buyerIndex(emp);
			break;
		default:
			System.out.println("请重新输入");
			login();
			break;
		}
	}
	//会员登录
	public void vipLogin(Scanner sc) {
		System.out.print("请输入VIP编号：\n>");
		String vipid = sc.next();
		VipServise vipServise=new VipServiseImpl();
		Vip vip=vipServise.vipLogin(vipid);
		if (vip!=null) {
			View.vipIndex(vip);
		}else {
			System.out.println("请重新输入");
			login();
		}
	}
}
