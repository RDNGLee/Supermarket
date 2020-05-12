package cn.yueqian.bean;
/**
 * vip信息数据类
 * @author two
 *
 */

import java.util.Date;

public class Vip {
	private String v_number;
	private String v_name;
	private int v_score;
	private String v_phone;
	private String v_date;
	public String getV_number() {
		return v_number;
	}
	public void setV_number(String v_number) {
		this.v_number = v_number;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public int getV_score() {
		return v_score;
	}
	public void setV_score(int v_score) {
		this.v_score = v_score;
	}
	public String getV_phone() {
		return v_phone;
	}
	public void setV_phone(String v_phone) {
		this.v_phone = v_phone;
	}
	public String getV_date() {
		return v_date;
	}
	public void setV_date(String v_date) {
		this.v_date = v_date;
	}
	public Vip(String v_number, String v_name, int v_score, String v_phone, String v_date) {
		super();
		this.v_number = v_number;
		this.v_name = v_name;
		this.v_score = v_score;
		this.v_phone = v_phone;
		this.v_date = v_date;
	}
	public Vip() {
		super();
	}
	@Override
	public String toString() {
		return "VIP编号:" + v_number + ",姓名:" + v_name + ",积分:" + v_score + ",手机号码:" + v_phone
				+ ",开卡日期:" + v_date;
	}
	
}
