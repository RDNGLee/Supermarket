package cn.yueqian.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.sun.org.apache.regexp.internal.recompile;

import cn.yueqian.bean.Employee;
import cn.yueqian.bean.Goods;
import cn.yueqian.bean.Sell_info;
import cn.yueqian.dao.VipDao;
import cn.yueqian.dao.impl.BuyCommodityDaoImpl;
import cn.yueqian.dao.impl.CommodityDaoImpl;
import cn.yueqian.dao.impl.VipDaoImpl;
import cn.yueqian.service.BuyCommodityService;

public class BuyCommodityServiceImpl implements BuyCommodityService {

	private CommodityDaoImpl comDao = new CommodityDaoImpl();
	private Goods goods = new Goods();
	private BuyCommodityDaoImpl buyDao = new BuyCommodityDaoImpl();
	private List<Goods> list = comDao.getAllGoods();
	// 购买商品的实现方法ss
	@Override
	public void addSell_info(Employee emp) {
		boolean flag = true;
		boolean flagVip = true;
		String vipnum = null;
		List<Sell_info> listSell_infos = new ArrayList<Sell_info>();
		list.forEach(li -> System.out.println(li));
		Scanner scan = new Scanner(System.in);
		// 循环执行卖商品
		while (flag) {
			System.out.print("要买什么商品，请输入相应的编号:\n>");
			Sell_info sell_info = new Sell_info();
			String number = scan.next();
			goods = comDao.findCommodity(number);
			if (goods != null) {
				// 买东西的数量
				int num = buyNumber(emp, sell_info);
				// 判断一次用户是否是会员
				if (flagVip) {
					vipnum = getVipNumber();
					flagVip = false;
				}
				// set sell_info的属性值
				double money = getMoney(vipnum, goods.getC_price(), num);
				sell_info.setS_c_number(goods.getC_number());
				sell_info.setVipNumber(vipnum);
				sell_info.setS_e_number(emp.getNumber());
				sell_info.setS_time(getCurrentTime());
				sell_info.setMoney(money);
				buyDao.insertSell_info(sell_info);// 插入数据库
				listSell_infos.add(sell_info);// 存储用户买的商品信息
				// 判断用户是否还要购买商品
				flag = needCommod();

			} else {
				System.out.println(">>>没有该商品<<<");
				addSell_info(emp);
			}
		}
		// 打印用户购买的商品信息
		printXx(emp, listSell_infos);
	}

	// 买东西的数量
	public int buyNumber(Employee emp, Sell_info sell_info) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入要购买该商品的数量");
		int num = 0;
		try {
			num = scan.nextInt();
			if (num > 0 && num <= goods.getInventory()) {// 判断是否仓库是否还有没有那么多商品
				sell_info.setS_quantity(num); // 购买商品数
			} else {
				System.out.println(">>>输入有误<<<");
				buyNumber(emp, sell_info);
			}
		} catch (Exception e) {
			System.out.println("输入有误，请输入整数");
			buyNumber(emp, sell_info);
		}
		return num;
	}

	// 打印用户购买的商品信息
	public void printXx(Employee emp, List<Sell_info> listSell_infos) {
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★\n购买了：");
		double zmoney = 0.0;
		for (int i = 0; i < listSell_infos.size(); i++) {
			zmoney += listSell_infos.get(i).getMoney();
			System.out.println("商品编号:" + listSell_infos.get(i).getS_c_number() + ",\t商品数量:"
					+ listSell_infos.get(i).getS_quantity());
		}
		System.out.println("消费金额：" + zmoney + "\t收银员:" + emp.getNumber() + "\n购买时间:" + getCurrentTime());
	}

	// 判断用户是否还需要购买商品
	public boolean needCommod() {
		Scanner scan = new Scanner(System.in);
		System.out.print("还需要其他商品吗：\t输入Y/y---输入其他字符则为没有会员\n>");
		String str = scan.next();
		if (str.equals("Y") || str.equals("y")) {
			return true;
		} else {
			System.out.println("好的");
		}
		return false;
	}

	// 购买商品者的vip
	public String getVipNumber() {
		System.out.print("请问您有会员卡吗：\t输入Y/y---输入其他字符则为没有会员\n>");
		VipDao vipDao = new VipDaoImpl();
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		if (str.equals("Y") || str.equals("y")) {
			System.out.print("请输入会员编号:\n>");
			String number = scan.next();
			if (vipDao.findVip(number) != null) {
				return number;
			} else {
				System.out.println("没有该会员");
			}
		} else {
			System.out.println("好的");
		}
		return null;
	}

	// 当前时间--精确到秒
	public String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String str = sdf.format(date.getTime());
		return str;
	}

	// 获得消费的价格
	public double getMoney(String vip, double c_price, int s_quantity) {
		double price = 0.0;
		if (vip != null) {
			price = c_price * s_quantity * 0.8;
			BigDecimal bigDec = new BigDecimal(price);
			price = Double.parseDouble(bigDec.setScale(2, BigDecimal.ROUND_HALF_UP).toString());// 两位小数
			return price;
		} else {
			price = c_price * s_quantity;
			BigDecimal bigDec = new BigDecimal(price);
			price = Double.parseDouble(bigDec.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
			;// 两位小数
			return price;
		}
	}

	// 读取sell_info表数据
	@Override
	public void getAllSell_info() {
		List<Sell_info> list = new ArrayList<Sell_info>();
		list = buyDao.querySell_info();
		list.forEach(li -> System.out.println(li));
	}

	public void getZongMoney() {
		double money = buyDao.getGrossprofit();
		System.out.println("总收入：" + money);
	}
}
