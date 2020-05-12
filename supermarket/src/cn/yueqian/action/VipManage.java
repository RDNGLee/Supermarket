package cn.yueqian.action;

import java.util.Scanner;

import cn.yueqian.bean.Employee;
import cn.yueqian.service.VipServise;
import cn.yueqian.service.impl.VipServiseImpl;

public class VipManage {
	public void vipManage(Employee emp) {
		VipServise vipSerImpl = new VipServiseImpl();
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		System.out.println("※※※※※※※欢迎来到会员管理页面※※※※※※※");
		System.out.println("请选择操作：\n\t1.删除\t2.查询\t0.回到上一层\t00.退出程序\n★★★★★★★★★★★★★★★★★这是我的底线★★★★★★★★★★★★★★★★★★");
		System.out.print(">");
		Scanner scanner = new Scanner(System.in);
		switch (scanner.next()) {
		case "1":
			vipSerImpl.deleteVip(emp);
			vipManage(emp);
			break;
		case "2":
			vipSerImpl.getAllVip();
			vipManage(emp);
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
			vipManage(emp);
			break;
		}
	}
}
