package cn.yueqian.utils;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
	private static String url;
	private static String user;
	private static String password;
	private static Connection conn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	private static Properties proper = new Properties();
	// 初始化数据，将加载驱动放到静态代码块中,因为只用加载一次
	static {
		try {
			proper.load(new FileReader("supermarket.properties"));
			Class.forName(proper.getProperty("driver"));
			url = proper.getProperty("url");
			user = proper.getProperty("user");
			password = proper.getProperty("password");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获得数据库连接
	public static Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	// 条件查询 ，Connection（获得连接） 代表数据库连接对象，每一个Connection代表一个物理连接会话。
	public static ResultSet executeQuery(String sql, String[] str) {
		// 获得连接
		conn = getConnection();
		//
		try {
			// 得到发送的SQL语句
			ps = conn.prepareStatement(sql);
			// 处理占位符问题（就是查询的表有多少列）
			if (str != null) {
				for (int i = 0; i < str.length; i++) {
					ps.setString(i + 1, str[i]);
				}
			}
			// 发送sql语句
			rs = ps.executeQuery();
			return rs;// 返回结果集
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	// 编写增删改方法
	public static int executeUpdate(String sql, String[] str) {
		// 获得连接
		conn = getConnection();
		try {
			// 得到发送的SQL语句
			ps = conn.prepareStatement(sql);
			if (str != null) {
				for (int i = 0; i < str.length; i++) {
					ps.setString(i + 1, str[i]);
				}
			}
			int in = ps.executeUpdate();
			return in;// 修改成功了 in 条信息
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;

	}

	// 编写一个方法，关资源
	public static void close() {
		try {

			if (rs != null) {
				rs.close();
			}

			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
