package cn.yueqian.action;

import java.util.Scanner;

import cn.yueqian.bean.Employee;
import cn.yueqian.service.impl.CommodityServiceImpl;

public class CommodityManage {
	
	
	//商品管理页面
	public void comManage(Employee emp) {
		CommodityServiceImpl comSerImpl=new CommodityServiceImpl();
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		System.out.println("※※※※※※※欢迎来到商品管理页面※※※※※※※");
		System.out.println("请选择操作：\n\t1.添加商品\t2.修改商品\t3.查看商品\t4.删除商品\t0.回到上一层\n★★★★★★★★★★★★★★★★★这是我的底线★★★★★★★★★★★★★★★★★★");
		System.out.print(">");
		Scanner scanner = new Scanner(System.in);
		switch (scanner.next()) {
		case "1":
			comSerImpl.addCommodity(emp);
			comManage(emp);
			break;
		case "2":
			comSerImpl.updateCommodity(emp);
			comManage(emp);
			break;
		case "3":
			comSerImpl.getAllCommodity(emp);
			comManage(emp);
			break;
		case "4":
			comSerImpl.deleteCommodity(emp);
			comManage(emp);
			break;
		case "0":
			View.adminIndex(emp);
			break;
		default:
			System.out.println("输入有误");
			comManage(emp);
			break;
		}
		
	}
}
