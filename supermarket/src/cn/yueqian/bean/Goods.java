package cn.yueqian.bean;
/**
 * 商品信息类
 * @author two
 *
 */
public class Goods {
	private int c_number;//商品编号（条形码编号）
	private String c_name;//商品名
	private float c_price;//要规定小数点后两位
	private String vip_price;//要规定小数点后两位
	private int inventory;//库存量
	public int getC_number() {
		return c_number;
	}
	public void setC_number(int c_number) {
		this.c_number = c_number;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public float getC_price() {
		return c_price;
	}
	public void setC_price(float c_price) {
		this.c_price = c_price;
	}
	public String getVip_price() {
		return vip_price;
	}
	public void setVip_price(String vip_price) {
		this.vip_price = vip_price;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public Goods(int c_number, String c_name, float c_price, String vip_price, int inventory) {
		super();
		this.c_number = c_number;
		this.c_name = c_name;
		this.c_price = c_price;
		this.vip_price = vip_price;
		this.inventory = inventory;
	}
	public Goods() {
		super();
	}
	@Override
	public String toString() {
		return "商品编号:" + c_number + ",\t商品名称:" + c_name + ",\t商品价格" + c_price + ",\t会员价:"
				+ vip_price + ",\t库存量:" + inventory;
	}
	
	
}