package cn.yueqian.service.impl;

import java.util.List;
import java.util.Scanner;

import cn.yueqian.action.CommodityManage;
import cn.yueqian.action.View;
import cn.yueqian.bean.Employee;
import cn.yueqian.bean.Goods;
import cn.yueqian.dao.CommodityDao;
import cn.yueqian.dao.impl.CommodityDaoImpl;
import cn.yueqian.service.CommodityService;

public class CommodityServiceImpl implements CommodityService {
	private CommodityDaoImpl commodDao = new CommodityDaoImpl();
	private CommodityManage commodMan = new CommodityManage();
	private Goods goods = new Goods();

	// 添加商品
	@Override
	public void addCommodity(Employee emp) {
		addName();
		addPrice();
		addInventory();
		commodDao.insertCommodity(goods);
		commodMan.comManage(emp);
	}

	// 修改商品
	@Override
	public void updateCommodity(Employee emp) {
		boolean flag = false;
		System.out.print("输入要修改的商品编号：\n>");
		Scanner scan = new Scanner(System.in);
		String c_number = scan.next();
		Goods empp = commodDao.findCommodity(c_number);
		if (empp != null) {// 判断是否存在该用户
			flag = true;
		} else {
			System.out.println("没有这个商品");
			commodMan.comManage(emp);
		}
		if (flag) {
			System.out.print("输入要修改的属性：\n\t1.修改名称\t2.修改价格\t0.回到首页\n>");
			switch (scan.next()) {
			case "1":
				commodDao.updateCommodity(c_number, "c_name", updateName());
				commodMan.comManage(emp);
				break;
			case "2":
				float price = updatePrice();
				commodDao.updateCommodity(c_number, "c_price", "" + price);
				commodDao.updateCommodity(c_number, "vip_price", "" + price * 0.8);
				System.out.println("会员价8折");
				commodMan.comManage(emp);
				break;
			case "0":
				View.adminIndex(emp);
				break;
			default:
				System.out.println("输入有误!");
				updateCommodity(emp);
				break;
			}
		}
	}

	// 删除商品
	@Override
	public void deleteCommodity(Employee emp) {
		System.out.print("输入要删除的商品编号：\n>");
		Scanner scan = new Scanner(System.in);
		String c_number = scan.next();
		if (commodDao.findCommodity(c_number) != null) {
			System.out.println("输入-Y(y)-确认删除---输入-N(n)-不做删除：");
			String yn = scan.next();
			if (yn.equals("y") || yn.equals("Y")) {
				commodDao.deleteCommodity(c_number);
			}
			if (yn.equals("n") || yn.equals("N")) {
				System.out.println("不做删除");
				View.adminIndex(emp);
			}
		} else {
			System.out.println("没有这个商品");
			commodMan.comManage(emp);
		}

	}

	// 查询商品
	@Override
	public void getAllCommodity(Employee emp) {
		List<Goods> listAllEemployee = commodDao.getAllGoods();
		listAllEemployee.forEach(li -> System.out.println(li));
	}

	// 低于一百提示添加商品
	public void addComInventory() {
		List<Goods> list = commodDao.getCommodityInven();
		if (list != null) {
			System.out.println("数量低于100的商品：");
			list.forEach(li -> System.out.println(li));
			System.out.print("输入要修改的商品编号：\n>");
			Scanner scan = new Scanner(System.in);
			try {
				int c_number = scan.nextInt();
				System.out.print("请输入添加的商品数量:\n>");
				int number = scan.nextInt();
				commodDao.updateCommodityInver(number + "", c_number + "");
				System.out.println("修改成功");
			} catch (Exception e) {
				System.out.println("输入有误");
			}
		} else {
			System.out.println("没有需要补充的商品");
		}
	}

	// 添加商品名称
	public void addName() {
		System.out.print("请输入名称:\n>");
		Scanner scan = new Scanner(System.in);
		String c_name = scan.next();
		if (c_name.length() > 0 && c_name.length() < 100) {
			goods.setC_name(c_name);
		} else {
			System.out.println("输入有误");
			addName();
		}
	}

	// 添加商品价格
	public void addPrice() {
		System.out.print("请输入价格\n>");
		Scanner scan = new Scanner(System.in);
		try {
			float c_price = scan.nextInt();
			goods.setC_price(c_price);
		} catch (Exception e) {
			System.out.println("请输入数字");
			addPrice();
		}
	}

	// 添加库存
	public void addInventory() {
		System.out.print("请输入商品数量:\n>");
		Scanner scan = new Scanner(System.in);
		try {
			int inventory = scan.nextInt();
			goods.setInventory(inventory);
		} catch (Exception e) {
			System.out.println("请输入数字");
			addInventory();
		}
	}

	// 修改名称
	public String updateName() {
		Scanner scan = new Scanner(System.in);
		System.out.print("输入名称:\n>");
		String username = scan.next();
		if (username.length() > 0 && username.length() < 50) {
			return username;
		} else {
			System.out.println("输入有误");
			updateName();
			return null;
		}
	}

	// 修改价格
	public float updatePrice() {
		System.out.print("请输入价格:\n>");
		Scanner scan = new Scanner(System.in);
		try {
			float price = scan.nextInt();
			return price;
		} catch (Exception e) {
			System.out.println("请输入数字");
			updatePrice();
		}
		return -1;
	}

}
