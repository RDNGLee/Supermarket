package cn.yueqian.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yueqian.bean.CheckInfo;
import cn.yueqian.bean.Clock_info;
import cn.yueqian.bean.Employee;
import cn.yueqian.dao.EmployeeDao;
import cn.yueqian.utils.JDBCUtils;

public class EmployeeDaoImpl implements EmployeeDao {
	// 查询员工是否存在
	@Override
	public Employee findUser(String number) {
		Employee emp = new Employee();
		String sql = "select * from employee where number=?";
		String[] str = { number };
		ResultSet rs = JDBCUtils.executeQuery(sql, str);
		try {
			if (rs.next()) {
				emp.setNumber(rs.getString("number"));
				emp.setUsername(rs.getString("username"));
				emp.setPassword(rs.getString("password"));
				emp.setSex(rs.getString("sex"));
				emp.setPhone(rs.getString("phone"));
				emp.setRole(rs.getInt("role"));
				return emp;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close();
		}

		return null;
	}

	@Override
	public void insertEmployee(Employee emp) {
		String sql = "insert into employee values (?,?,?,?,?,?)";
		String[] str = { emp.getNumber(), emp.getUsername(), emp.getPassword(), emp.getSex(), emp.getPhone(),
				"" + emp.getRole() };
		int rs = JDBCUtils.executeUpdate(sql, str);
		System.out.println("添加成功");
		JDBCUtils.close();
	}

	@Override
	public void updateEmployee(String number, String str1, String str2) {
		String sql = "update employee set " + str1 + "=? WHERE number=?";
		String[] str = { str2, number };
		int rs = JDBCUtils.executeUpdate(sql, str);
		JDBCUtils.close();
	}

	@Override
	public void deleteEmployee(String number) {
		String sql = "update  employee set role=0 where number=?";
		String[] str = { number };
		int rs = JDBCUtils.executeUpdate(sql, str);
		System.out.println("删除成功");
		JDBCUtils.close();
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list = new ArrayList<Employee>();
		String sql = "select * from employee";
		String[] str = {};
		ResultSet rs = JDBCUtils.executeQuery(sql, str);
		try {
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setNumber(rs.getString("number"));
				emp.setUsername((rs.getString("username")));
				emp.setPassword((rs.getString("password")));
				emp.setSex((rs.getString("sex")));
				emp.setPhone((rs.getString("phone")));
				emp.setRole(rs.getInt("role"));
				if (emp.getRole() != 1) {
					list.add(emp);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close();
		}
		return list;
	}

	// 查询考勤信息
	@Override
	public List<CheckInfo> getAllCheckInfo() {
		List<CheckInfo> list = new ArrayList<CheckInfo>();
		String sql = "select * from check_info";
		String[] str = {};
		ResultSet rs = JDBCUtils.executeQuery(sql, str);
		try {
			while (rs.next()) {
				CheckInfo checkInfo = new CheckInfo();
				checkInfo.setWork_date(rs.getDate("work_date"));
				checkInfo.setEmployee_no(rs.getString("employee_no"));
				checkInfo.setClock_in_time(rs.getDate("clock_in_time"));
				checkInfo.setClock_off_time(rs.getDate("clock_off_time"));
				checkInfo.setDiff_in_status(rs.getString("diff_in_status"));
				checkInfo.setDiff_off_time(rs.getString("diff_off_time"));
				list.add(checkInfo);
			}
			
		} catch (SQLException e) {
			
		} finally {
			JDBCUtils.close();
		}
		return list;
	}

	//
	@Override
	public void updateClockIn(String datein, Employee emp) {
		String sql = "update clock_info set clock_in_time=now() where employee_no=? and clock_date=?";
		String[] str = { emp.getNumber() ,datein};
		int rs = JDBCUtils.executeUpdate(sql, str);
		System.out.println("打卡成功");
		JDBCUtils.close();
	}

	//
	@Override
	public void updateClockOut(String dateout, Employee emp) {
		String sql = "update clock_info set clock_off_time=now() where employee_no=? and clock_date=?";
		String[] str = { emp.getNumber(), dateout};
		int rs = JDBCUtils.executeUpdate(sql, str);
		System.out.println("打卡成功");
		JDBCUtils.close();
	}

	// 插入空的信息
	@Override
	public void insertClock(String empNumber) {
		String sql = "insert into clock_info (employee_no,clock_in_time,clock_off_time,clock_date) values (?,?,?,now())";
		String[] str = { empNumber, null, null };
		int rs = JDBCUtils.executeUpdate(sql, str);
		JDBCUtils.close();
	}

	@Override
	public List<Clock_info> getAllClock_infos() {
		List<Clock_info> list = new ArrayList<Clock_info>();
		String sql = "select * from clock_info";
		String[] str = {};
		ResultSet rs = JDBCUtils.executeQuery(sql, str);
		try {
			while (rs.next()) {
				Clock_info clock_info = new Clock_info();
				clock_info.setClock_id(rs.getInt("clock_id"));
				clock_info.setEmployee_no(rs.getString("employee_no"));
				clock_info.setClock_in_time(rs.getString("clock_in_time"));
				clock_info.setClock_off_time(rs.getString("clock_off_time"));
				clock_info.setClock_date(rs.getString("clock_date"));
				list.add(clock_info);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close();
		}
		return null;
	}

}
