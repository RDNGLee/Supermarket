package cn.yueqian.bean;



/**
 * 销售的信息数据类
 * @author two
 *
 */
public class Sell_info {
	private int s_c_number; //商品编号
	private int s_quantity; //购买数量
	private String s_time;  //购买时间
	private String s_e_number;//收银员编号
	private String vipNumber;
	private double money;
	
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getVipNumber() {
		return vipNumber;
	}
	public void setVipNumber(String vipNumber) {
		this.vipNumber = vipNumber;
	}
	public int getS_c_number() {
		return s_c_number;
	}
	public void setS_c_number(int s_c_number) {
		this.s_c_number = s_c_number;
	}
	public int getS_quantity() {
		return s_quantity;
	}
	public void setS_quantity(int s_quantity) {
		this.s_quantity = s_quantity;
	}
	public String getS_time() {
		return s_time;
	}
	public void setS_time(String s_time) {
		this.s_time = s_time;
	}
	public String getS_e_number() {
		return s_e_number;
	}
	public void setS_e_number(String s_e_number) {
		this.s_e_number = s_e_number;
	}
	
	public Sell_info() {
		super();
	}
	@Override
	public String toString() {
		return "商品编号:" + s_c_number + ",\t购买数量:" + s_quantity + ",\t购买时间:" + s_time
				+ ",\t收银员编号:" + s_e_number + ",\t会员编号" + vipNumber+",\t消费金额:"+money;
	}
	
	
}
