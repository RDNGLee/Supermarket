package cn.yueqian.bean;
/**
 * 考勤类数据
 * @author two
 *
 */

import java.util.Date;

public class Clock_info {
	private int clock_id;
	private String employee_no;
	private String clock_in_time;
	private String clock_off_time;
	private String clock_date;

	public int getClock_id() {
		return clock_id;
	}

	public void setClock_id(int clock_id) {
		this.clock_id = clock_id;
	}

	public String getEmployee_no() {
		return employee_no;
	}

	public void setEmployee_no(String employee_no) {
		this.employee_no = employee_no;
	}

	public String getClock_in_time() {
		return clock_in_time;
	}

	public void setClock_in_time(String clock_in_time) {
		this.clock_in_time = clock_in_time;
	}

	public String getClock_off_time() {
		return clock_off_time;
	}

	public void setClock_off_time(String clock_off_time) {
		this.clock_off_time = clock_off_time;
	}

	public String getClock_date() {
		return clock_date;
	}

	public void setClock_date(String clock_date) {
		this.clock_date = clock_date;
	}

	public Clock_info(int clock_id, String employee_no, String clock_in_time, String clock_off_time, String clock_date) {
		super();
		this.clock_id = clock_id;
		this.employee_no = employee_no;
		this.clock_in_time = clock_in_time;
		this.clock_off_time = clock_off_time;
		this.clock_date = clock_date;
	}

	public Clock_info() {
		super();
	}

	@Override
	public String toString() {
		return "Clock_info [clock_id=" + clock_id + ", employee_no=" + employee_no + ", clock_in_time=" + clock_in_time
				+ ", clock_off_time=" + clock_off_time + ", clock_date=" + clock_date + "]";
	}
	
}
