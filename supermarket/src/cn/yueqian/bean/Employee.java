package cn.yueqian.bean;
/**
 * employee:员工的数据
 * @author two
 *
 */
public class Employee {
	private String number;
	private String username;
	private String password;
	private String sex;
	private String phone;
	private int role;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public Employee(String number, String username, String password, String sex, String phone, int role) {
		super();
		this.number = number;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.phone = phone;
		this.role = role;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "编号:" + number + "\t用户名:" + username + "\t密码:" + password + "\t性别:" + sex
				+ "\t手机号码:" + phone + "\t岗位:" + role;
	}
	
}
