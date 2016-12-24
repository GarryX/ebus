package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @Description: ����Ǩ�ƣ���mysqlǨ�Ƶ�oracle
 * @Author: nutony
 * @Date: 2013-05-15
 */
public class TestMigrate {
	@Test
	public void clearTable() throws InstantiationException, IllegalAccessException, ClassNotFoundException,
			SQLException, IOException, InterruptedException {
		// Map<String,String> map = new HashMap<String,String>();
		// //�±����޸��ֶ����������������
		// map.put("CONTRACT_C.CNOTE", "NOTE");
		// map.put("CONTRACT_C.CONTRACTOR", "CONTACTS");
		String s = "CONTRACT_C,CONTRACT_PRODUCT_C,EXT_CPRODUCT_C";
		// String s = "export_c,export_product_c,ext_eproduct_c";
		this.execute("clear", s.split(","));
	}

	@Test
	public void copyData() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException,
			IOException, InterruptedException {
		String s = "FACTORY_C,CONTRACT_C,CONTRACT_PRODUCT_C,EXT_CPRODUCT_C,EXPORT_C,EXPORT_PRODUCT_C,EXT_EPRODUCT_C";
		this.execute("copy", s.split(","));
	}

	private void execute(String what, String[] tables) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException, IOException, InterruptedException {
		// Դ���ݿ���Ϣ
		String srcDriver = "com.mysql.jdbc.Driver";
		String srcUrl = "jdbc:mysql://localhost:3306/ebusiness";
		String srcUser = "root";
		String srcPassword = "4inlovewithU";

		// Ŀ�����ݿ���Ϣ
		String desDriver = "oracle.jdbc.driver.OracleDriver";
		String desUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
		String desUser = "Garry";
		String desPassword = "garry";

		if ("copy".equals(what)) {
			for (String tableName : tables) {
				String desColumns = this.getDesColumns(tableName, desDriver, desUrl, desUser, desPassword); // Ŀ����ֶ�
				System.out.println(desColumns);
				List<String> sqls = this.insertSql(tableName, desColumns, srcDriver, srcUrl, srcUser, srcPassword);
				this.executeBatch(sqls, desDriver, desUrl, desUser, desPassword);
			}
		} else {
			List<String> sqls = new ArrayList<>();
			for (String tableName : tables) {
				sqls.add("delete from " + tableName); // clear table data
				this.executeBatch(sqls, desDriver, desUrl, desUser, desPassword);
			}
		}
		System.out.println("Successfull!");
	}

	// ����sql����insert sql�ű�
	public List<String> insertSql(String tableName, String desColumns, String driver, String url, String user,
			String password) throws InstantiationException, IllegalAccessException, ClassNotFoundException,
			SQLException, IOException, InterruptedException {
		Class.forName(driver).newInstance();
		Connection conn = DriverManager.getConnection(url, user, password);
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from " + tableName);
		ResultSetMetaData rsmd = rs.getMetaData(); // ��ñ�ṹ����

		for (int j = 1; j < rsmd.getColumnCount() + 1; j++) { // ��ӡ�ֶα��������
			System.out.print(rsmd.getColumnName(j) + "[" + rsmd.getColumnTypeName(j) + "]\t");
		}
		System.out.println("");

		List<String> sqls = new ArrayList<>();
		StringBuffer sBuf = new StringBuffer();

		while (rs.next()) {
			sBuf.append("insert into " + tableName + " ");
			sBuf.append("(");
			for (int j = 1; j < rsmd.getColumnCount() + 1; j++) {
				if (desColumns.indexOf(rsmd.getColumnName(j) + ",") > -1) { // Ŀ����и��ֶβŴ���
					sBuf.append(rsmd.getColumnName(j)).append(",");
				}
			}
			sBuf.delete(sBuf.length() - 1, sBuf.length()); // del last ','
			sBuf.append(")");

			sBuf.append(" values(");
			for (int j = 1; j < rsmd.getColumnCount() + 1; j++) {
				if (desColumns.indexOf(rsmd.getColumnName(j) + ",") > -1) { // Ŀ����и��ֶβŴ���
					if (rs.getString(j) != null && "VARCHAR".indexOf(rsmd.getColumnTypeName(j)) > -1) {
						sBuf.append("'").append(rs.getString(j)).append("'").append(",");
					} else if (rs.getString(j) != null && "DATETIME".indexOf(rsmd.getColumnTypeName(j)) > -1) {
						sBuf.append("to_date('").append(rs.getString(j).replace(".0", ""))
								.append("','yyyy-mm-dd hh24:mi:ss'),"); // oracle��������
					} else {
						sBuf.append(rs.getInt(j)).append(",");
					}
				}
			}
			sBuf.delete(sBuf.length() - 1, sBuf.length()); // del last ','
			sBuf.append(")");
			System.out.println(sBuf.toString());
			sqls.add(sBuf.toString()); // add sql
			sBuf.delete(0, sBuf.length()); // clear
		}

		rs.close();
		stmt.close();
		conn.close();

		return sqls;
	}

	// ���Ŀ����У���ʱĿ����Դ���ֶλ��в��죬���ﴦ��Դ���ж�Ŀ���û�е����
	public String getDesColumns(String tableName, String driver, String url, String user, String password)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException,
			InterruptedException {
		StringBuilder sb = new StringBuilder();
		Class.forName(driver).newInstance();
		Connection conn = DriverManager.getConnection(url, user, password);
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from " + tableName);
		ResultSetMetaData rsmd = rs.getMetaData(); // ��ñ�ṹ����

		for (int j = 1; j < rsmd.getColumnCount() + 1; j++) { // ��ӡ����
			sb.append(rsmd.getColumnName(j) + ",");
		}

		rs.close();
		stmt.close();
		conn.close();

		return sb.toString();
	}

	// ����ִ��sql���
	public void executeBatch(List<String> sqls, String driver, String url, String user, String password)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException,
			InterruptedException {
		if (sqls.size() > 0) {
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false); // ���Զ��ύ�������޷������ύ
			Statement stmt = conn.createStatement();
			for (String sql : sqls) {
				stmt.addBatch(sql); // ���Ҫִ�е�sql���
			}
			stmt.executeBatch(); // �����ύִ��

			stmt.close();
			conn.close();
		}
	}

}
