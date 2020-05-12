package cn.yueqian.service.impl;

import java.util.List;
import java.util.Scanner;
import cn.yueqian.action.EmployeeManage;
import cn.yueqian.action.View;
import cn.yueqian.bean.CheckInfo;
import cn.yueqian.bean.Employee;
import cn.yueqian.dao.EmployeeDao;
import cn.yueqian.dao.impl.EmployeeDaoImpl;
import cn.yueqian.service.EmpManagerService;

/**
 * @author two 添加员工 修改员工信息 删除员工信息
 */
public class EmpManageServiceImpl implements EmpManagerService {

	private Employee emp = new Employee();
	private static int numOfTimes = 0;
	private EmployeeDao empDao = new EmployeeDaoImpl();
	private EmployeeManage empMan = new EmployeeManage();

	// 添加员工
	@Override
	public void addEmployee(Employee emp) {
		addNumber();
		addUsername();
		addPassword();
		addSex();
		addPhone();
		addRole();
		empDao.insertEmployee(this.emp);
	}

	@Override
	public void updateEmployee(Employee emp) {
		boolean flag = false;
		System.out.println("输入要修改的员工编号：");
		Scanner scan = new Scanner(System.in);
		String number = scan.next();
		Employee empp = empDao.findUser(number);
		if (empp != null) {// 判断是否存在该用户
			if (empp.getRole() != 1) {// 判断是否有权利修改
				flag = true;
			} else {
				System.out.println("没有权利修改管理员！");
				empMan.empManage(emp);
			}
		} else {
			System.out.println("没有这个用户");
			empMan.empManage(emp);
		}
		if (flag) {
			System.out.println("输入要修改的属性：\n\t1.修改姓名\t2.修改密码\t3.修改性别\t4.修改手机号\t5.修改职位\t0.回到上一层");
			switch (scan.next()) {
			case "1":
				empDao.updateEmployee(number, "username", updateUsername());
				empMan.empManage(emp);
				break;
			case "2":
				empDao.updateEmployee(number, "password", updatePassword());
				empMan.empManage(emp);
				break;
			case "3":
				empDao.updateEmployee(number, "sex", updateSex());
				empMan.empManage(emp);
				break;
			case "4":
				empDao.updateEmployee(number, "phone", updatePhone());
				empMan.empManage(emp);
				break;
			case "5":
				empDao.updateEmployee(number, "role", "" + updateRole());
				empMan.empManage(emp);
				break;
			case "0":
				empMan.empManage(emp);
				break;
			default:
				System.out.println("输入有误!");
				updateEmployee(emp);
				break;
			}
		}
	}

	// 删除员工信息
	@Override
	public void deleteEmployee(Employee emp) {
		System.out.print("请输入要删除的员工编号：\n>");
		Scanner scan = new Scanner(System.in);
		String number = scan.next();
		if (empDao.findUser(number) != null) {
			System.out.println("输入-Y(y)-确认删除---输入-N(n)-不做删除：");
			System.out.print(">");
			String yn = scan.next();
			if (yn.equals("y") || yn.equals("Y")) {
				empDao.deleteEmployee(number);
			}
			if (yn.equals("n") || yn.equals("N")) {
				System.out.println("不做删除");
				empMan.empManage(emp);
			}
		} else {
			System.out.println("没有这个用户");
			empMan.empManage(emp);
		}
	}

	// 查询员工信息
	@Override
	public void getAllEmployee(Employee emp) {
		List<Employee> listAllEemployee = empDao.getAllEmployee();
		listAllEemployee.forEach(li -> System.out.println(li));
	}

	// 查询考勤信息
	@Override
	public void getAllCheckInfo() {
		List<CheckInfo> listCheckInfos = empDao.getAllCheckInfo();
		listCheckInfos.forEach(li -> System.out.println(li));
	}

	// 添加编号
	public void addNumber() {
		System.out.print("请输入账号：\n>");
		Scanner scan = new Scanner(System.in);
		String number = scan.next();
		if (empDao.findUser(number) == null) {
			emp.setNumber(number);
		} else {
			System.out.println("该编号已被使用");
			numOfTimes++;
			if (numOfTimes > 3) {
				empMan.empManage(emp);
			}
			addNumber();
		}
	}

	// 添加姓名
	public void addUsername() {
		System.out.print("请输入姓名：\n>");
		Scanner scan = new Scanner(System.in);
		String username = scan.next();
		if (username.length() > 0 && username.length() < 50) {
			emp.setUsername(username);
		} else {
			System.out.println("输入有误");
			numOfTimes++;
			if (numOfTimes > 3) {
				empMan.empManage(emp);
			}
			addUsername();
		}
	}

	// 添加密码
	public void addPassword() {
		System.out.print("请输入密码：\n>");
		Scanner scan = new Scanner(System.in);
		String password = scan.next();
		if (password.length() > 0 && password.length() < 50) {
			emp.setPassword(password);
		} else {
			System.out.println("输入有误");
			numOfTimes++;
			if (numOfTimes > 3) {
				empMan.empManage(emp);
			}
			addPassword();
		}
	}

	// 添加性别
	public void addSex() {
		System.out.print("请输入性别：\n>");
		Scanner scan = new Scanner(System.in);
		String sex = scan.next();
		if (sex.equals("男") || sex.equals("女")) {
			emp.setSex(sex);
		} else {
			System.out.println("输入有误");
			numOfTimes++;
			if (numOfTimes > 3) {
				empMan.empManage(emp);
			}
			addSex();
		}
	}

	// 添加手机号码
	public void addPhone() {
		System.out.print("请输入手机号码：\n>");
		Scanner scan = new Scanner(System.in);
		String phone = scan.next();
		if (judgeRegularString(phone) != null) {
			emp.setPhone(phone);
		} else {
			numOfTimes++;
			if (numOfTimes > 3) {
				empMan.empManage(emp);
			}
			addPhone();
		}
	}

	// 添加职位
	public void addRole() {
		System.out.print("请输入职位：\n\t>2---收银员\n\t>3---采购员\n>");
		Scanner scan = new Scanner(System.in);
		int role = -1;
		try {
			role = scan.nextInt();
			if (role == 3 || role == 2) {
				emp.setRole(role);
				return;
			}
		} catch (Exception e) {
			System.out.print("请输入2,或3");
		}
		numOfTimes++;
		if (numOfTimes > 3) {
			empMan.empManage(emp);
		}
		addRole();
	}

	// 获得修改姓名
	public String updateUsername() {
		System.out.print("请输入姓名：\n>");
		Scanner scan = new Scanner(System.in);
		String username = scan.next();
		if (username.length() > 0 && username.length() < 50) {
			System.out.println("修改成功");
			return username;
		} else {
			System.out.println("输入有误");
			numOfTimes++;
			if (numOfTimes > 3) {
				return null;
			}
			updateUsername();
			return null;
		}
	}

	// 修改密码
	public String updatePassword() {
		System.out.print("请输入密码：\n>");
		Scanner scan = new Scanner(System.in);
		String password = scan.next();
		if (password.length() > 0 && password.length() < 50) {
			System.out.println("修改成功");
			return password;
		} else {
			System.out.println("输入有误");
			numOfTimes++;
			if (numOfTimes > 3) {
				return null;
			}
			updatePassword();
			return null;
		}
	}

	// 修改性别
	public String updateSex() {
		System.out.print("请输入性别：\n>");
		Scanner scan = new Scanner(System.in);
		String sex = scan.next();
		if (sex.equals("男") || sex.equals("女")) {
			System.out.println("修改成功");
			return sex;
		} else {
			System.out.println("输入有误");
			numOfTimes++;
			if (numOfTimes > 3) {
				return null;
			}
			updateSex();
			return null;
		}
	}

	// 修改手机号码
	public String updatePhone() {
		System.out.print("请输入手机号码：\n>");
		Scanner scan = new Scanner(System.in);
		String phone = scan.next();
		if (judgeRegularString(phone) != null) {
			return phone;
		} else {
			numOfTimes++;
			if (numOfTimes > 3) {
				return null;
			}
			updatePhone();
			return null;
		}
	}

	// 获取输入的11位号码是哪个运营商的号码
	public static String judgeRegularString(String str) {
		String modelReg = "^[1]((3[4-9])|(4[7])|(5[127-9])|(7[8])|(8[2-478])|(9[8]))[0-9]{8}$";
		String unicom = "^[1]((3[012])|(4[5])|(5[56])|(6[6])|(7[56])|(8[56]))[0-9]{8}$";
		String chinanet = "^[1]((3[3])|(5[3])|(7[37])|(8[019])|(9[9]))[0-9]{8}$";
		String nullNumber = "^\\d{11}$";
		if (str.matches(modelReg)) {
			return str;
		} else if (str.matches(unicom)) {
			return str;
		} else if (str.matches(chinanet)) {
			return str;
		} else if (str.matches(nullNumber)) {
			System.out.println("该号码未知!");
			return null;
		} else {
			System.out.println("输入有误,请重新输入：");
			return null;
		}

	}

	// 修改职位
	public int updateRole() {
		System.out.print("请输入职位：\n\t>2---收银员\n\t>3---采购员\n>");
		Scanner scan = new Scanner(System.in);
		int role = -1;
		try {
			role = scan.nextInt();
			if (role == 3 || role == 2) {
				System.out.println("修改成功");
				return role;
			}
		} catch (Exception e) {
			System.out.print("请输入2,或3");
		}
		numOfTimes++;
		if (numOfTimes > 3) {
			return -1;
		}
		updateRole();
		return -1;
	}

}
