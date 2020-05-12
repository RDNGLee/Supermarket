package cn.yueqian.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import cn.yueqian.action.View;
import cn.yueqian.action.VipManage;
import cn.yueqian.bean.Employee;
import cn.yueqian.bean.Goods;
import cn.yueqian.bean.Sell_info;
import cn.yueqian.bean.Vip;
import cn.yueqian.dao.VipDao;
import cn.yueqian.dao.impl.CommodityDaoImpl;
import cn.yueqian.dao.impl.VipDaoImpl;
import cn.yueqian.service.VipServise;

public class VipServiseImpl implements VipServise {
	private VipDao vipDao = new VipDaoImpl();
	private Vip vip = new Vip();
	private VipManage vipManage = new VipManage();

	// vip登录方法
	@Override
	public Vip vipLogin(String vipid) {
		VipDao vipDao = new VipDaoImpl();
		Vip vip = vipDao.findVip(vipid);
		if (vip != null) {
			return vip;
		} else {
			System.out.println("用户不存在");
		}
		return null;
	}

	// vip添加 收银员添加
	@Override
	public void addVip(Employee emp) {
		addNumber();
		addUsername();
		addPhone();
		vipDao.insertVip(vip);
	}

	// vip修改
	@Override
	public void updateVip(Employee emp) {
		System.out.println("输入要修改的会员编号：");
		Scanner scan = new Scanner(System.in);
		String vipid = scan.next();
		vip = vipDao.findVip(vipid);
		if (vip != null) {// 判断是否存在该用户
			try {
				System.out.println("输入要修改的积分");
				int score = scan.nextInt();
				vipDao.updateVip(vipid, "v_score", "" + score);
				View.adminIndex(emp);
			} catch (Exception e) {
				System.out.println("请输入整数");
				vipManage.vipManage(emp);
			}
		} else {
			System.out.println("没有这个用户");
			vipManage.vipManage(emp);
		}

	}

	// vip删除
	@Override
	public void deleteVip(Employee emp) {
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入要删除的会员号:\n>");
		String vipid = scan.next();
		if (vipDao.findVip(vipid) != null) {
			vipDao.deleteVip(vipid);
		} else {
			System.out.println("没有这个用户");
			vipManage.vipManage(emp);
		}

	}

	// vip查询
	@Override
	public void getAllVip() {
		List<Vip> list = new ArrayList<Vip>();
		list = vipDao.queryVip();
		list.forEach(li -> System.out.println(li));
	}

	public void getVipScore() {
		System.out.print("请输入会员编号:\n>");
		Scanner scanner = new Scanner(System.in);
		String vipNumber = scanner.next();
		Vip vip = vipDao.findVip(vipNumber);
		if (vip != null) {
			System.out.println(vip.getV_score());
		} else {
			System.out.println("输入的编号有误");
		}
	}

	// 添加编号
	public void addNumber() {
		System.out.print("请输入账号：\n>");
		Scanner scan = new Scanner(System.in);
		String vipid = scan.next();
		if (vipDao.findVip(vipid) == null) {
			vip.setV_number(vipid);
		} else {
			System.out.println("该编号已被使用");
			addNumber();
		}
	}

	// 添加姓名
	public void addUsername() {
		System.out.print("请输入姓名：\n>");
		Scanner scan = new Scanner(System.in);
		String username = scan.next();
		if (username.length() > 0 && username.length() < 50) {
			vip.setV_name(username);
		} else {
			System.out.println("输入有误");
			addUsername();
		}
	}

	// 添加手机号码
	public void addPhone() {
		EmpManageServiceImpl empSer = new EmpManageServiceImpl();

		System.out.print("请输入手机号码：\n>");
		Scanner scan = new Scanner(System.in);
		String phone = scan.next();
		if (empSer.judgeRegularString(phone) != null) {
			vip.setV_phone(phone);
		} else {
			addPhone();
		}
	}

}
