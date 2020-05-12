package cn.yueqian.action;

import java.util.Scanner;

import cn.yueqian.bean.Employee;
import cn.yueqian.bean.Vip;
import cn.yueqian.service.VipServise;
import cn.yueqian.service.impl.BuyCommodityServiceImpl;
import cn.yueqian.service.impl.ClockInOrOutServiceImpl;
import cn.yueqian.service.impl.CommodityServiceImpl;
import cn.yueqian.service.impl.VipServiseImpl;

//System.out.println("请选择操作：\n\t1.\n\t2.\n\t1.\n\t2.\n\t1.\n\t2.");
public class View {
	private static ClockInOrOutServiceImpl clock=new ClockInOrOutServiceImpl();
	// 管理员首页
	public static void adminIndex(Employee emp) {
		String username = emp.getUsername();
		BuyCommodityServiceImpl buySer=new BuyCommodityServiceImpl();
		clock.insertClock(emp);//插入一个空的打卡表
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		System.out.println("※※※※※※※欢迎" + username + "进入超市管理系统※※※※※※※");
		System.out.println("请选择操作：\n\t1.员工管理\n\t2.会员管理\n\t3.商品管理\n\t4.查询超市营业额\n\t5.上班打卡\n\t6.下班打卡\n\t0.回到登录界面\n\t00.退出程序\n★★★★★★★★★★★★★★★★★这是我的底线★★★★★★★★★★★★★★★★★★");
		System.out.print(">");
		Scanner scanner = new Scanner(System.in);
		switch (scanner.next()) {
		case "1"://调用员工管理 
			new EmployeeManage().empManage(emp);
			break;
		case "2":
			new VipManage().vipManage(emp);
			break;
		case "3":
			new CommodityManage().comManage(emp);
			break;
		case "4":
			buySer.getAllSell_info();
			buySer.getZongMoney();
			adminIndex(emp);
			break;
		case "5":
			clock.ClockIn(emp);
			adminIndex(emp);
			break;
		case "6":
			clock.ClockOut(emp);
			adminIndex(emp);
			break;
		case "0":
			new Login().login();
			break;
		case "00":
			System.out.println("退出成功");
			System.exit(0);
			break;
		default:
			System.out.println("输入有误");
			adminIndex(emp);
			break;
		}
	}

	// 收银员首页
	public static void cashierIndex(Employee emp) {
		String username = emp.getUsername();
		VipServiseImpl vipSer=new VipServiseImpl();
		clock.insertClock(emp);//插入一个空的打卡表
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		System.out.println("※※※※※※※欢迎" + username + "进入超市管理系统※※※※※※※");
		System.out.println(
				"请选择操作：\n\t1.收银结算\n\t2.开通会员\n\t3.VIP积分查询\n\t4.上班打卡\n\t5.下班打卡\n\t0.回到登录界面\n\t00.退出程序\n★★★★★★★★★★★★★★★★★这是我的底线★★★★★★★★★★★★★★★★★★");
		Scanner scanner = new Scanner(System.in);
		System.out.print(">");
		switch (scanner.next()) {
		case "1":
			new BuyCommodityServiceImpl().addSell_info(emp);
			View.cashierIndex(emp);
			break;
		case "2":
			vipSer.addVip(emp);
			View.cashierIndex(emp);
			break;
		case "3":
			vipSer.getVipScore();
			View.cashierIndex(emp);
			break;
		case "4":
			clock.ClockIn(emp);
			cashierIndex(emp);
			break;
		case "5":
			clock.ClockOut(emp);
			cashierIndex(emp);
			break;
		case "0":
			new Login().login();
			break;
		case "00":
			System.out.println("退出成功");
			System.exit(0);
			break;
		default:
			System.out.println("输入有误，请重新操作");
			cashierIndex(emp);
			break;
		}
	}

	//采购员首页
	public static void buyerIndex(Employee emp) {
		String username = emp.getUsername();
		CommodityServiceImpl commodSer=new CommodityServiceImpl();
		clock.insertClock(emp);//插入一个空的打卡表
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		System.out.println("※※※※※※※欢迎" + username + "进入超市管理系统※※※※※※※");
		System.out.println(
				"请选择操作：\n\t1.进行商品补货\n\t2.查询进货单\n\t3.上班打卡\n\t4.下班打卡\n\t0.回到登录界面\n\t00.退出程序\n★★★★★★★★★★★★★★★★★这是我的底线★★★★★★★★★★★★★★★★★★");
		Scanner scanner = new Scanner(System.in);
		System.out.print(">");
		switch (scanner.next()) {
		case "1":
			commodSer.addComInventory();
			buyerIndex(emp);
			break;
		case "2":
			commodSer.getAllCommodity(emp);
			buyerIndex(emp);
			break;
		case "3":
			clock.ClockIn(emp);
			buyerIndex(emp);
			break;
		case "4":
			clock.ClockOut(emp);
			buyerIndex(emp);
			break;
		case "0":
			new Login().login();
			break;
		case "00":
			System.out.println("退出成功");
			System.exit(0);
			break;
		default:
			System.out.println("输入有误，请重新操作");
			buyerIndex(emp);
			break;
		}
	}

	// Vip首页
	public static void vipIndex(Vip vip) {
		String username = vip.getV_phone();
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★\n※※※※※※※欢迎" + username
				+ "进入超市管理系统※※※※※※※\n请选择操作：\n\t1.查询会员信息\n\t0.回到登录界面\n\t00.退出程序\n★★★★★★★★★★★★★★★★★这是我的底线★★★★★★★★★★★★★★★★★★");
		Scanner scanner = new Scanner(System.in);
		System.out.print(">");
		switch (scanner.next()) {
		case "1":
			System.out.println(vip);
			vipIndex(vip);
			break;
		case "0":
			new Login().login();
			break;
		case "00":
			System.out.println("退出成功");
			System.exit(0);
			break;
		default:
			System.out.println("输入有误，请重新操作");
			vipIndex(vip);
			break;
		}
	}
}
