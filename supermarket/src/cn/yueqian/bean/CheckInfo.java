package cn.yueqian.bean;

import java.util.Date;

public class CheckInfo {

	private Date work_date;
	private String employee_no;
	private Date clock_in_time;
	private Date clock_off_time;
	private String diff_in_status;
	private String diff_off_time;

	public Date getWork_date() {
		return work_date;
	}

	public void setWork_date(Date work_date) {
		this.work_date = work_date;
	}

	public String getEmployee_no() {
		return employee_no;
	}

	public void setEmployee_no(String employee_no) {
		this.employee_no = employee_no;
	}

	public Date getClock_in_time() {
		return clock_in_time;
	}

	public void setClock_in_time(Date clock_in_time) {
		this.clock_in_time = clock_in_time;
	}

	public Date getClock_off_time() {
		return clock_off_time;
	}

	public void setClock_off_time(Date clock_off_time) {
		this.clock_off_time = clock_off_time;
	}

	public String getDiff_in_status() {
		return diff_in_status;
	}

	public void setDiff_in_status(String diff_in_status) {
		this.diff_in_status = diff_in_status;
	}

	public String getDiff_off_time() {
		return diff_off_time;
	}

	public void setDiff_off_time(String diff_off_time) {
		this.diff_off_time = diff_off_time;
	}

	@Override
	public String toString() {
		return "工作日:" + work_date + ",\t员工编号:" + employee_no + ",\t上班时间:" + clock_in_time + ",\t下班时间:" + clock_off_time
				+ ",\t上班打卡状态:" + diff_in_status + ",\t下班打卡状态:" + diff_off_time;
	}

}
