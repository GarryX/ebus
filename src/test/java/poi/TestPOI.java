package poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.junit.Test;

public class TestPOI {
	@Test
	public void test() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, InterruptedException, IOException {
		String xlsFile = "c:/testPOI.xlsx";					//����ļ�
		Workbook wb = new SXSSFWorkbook(100);					
		Sheet sheet = wb.createSheet("�ҵĵ�һ��������");		//�����µ�sheet����

		Row nRow = null;
		Cell nCell   = null;
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();  
		String url = "jdbc:mysql://localhost:3306/jkmore100?characterEncoding=UTF-8";
		String user = "root";
		String password = "root";
		
		Connection conn = DriverManager.getConnection(url, user,password);   
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);   

		String sql = "select * from hpa limit 65536";
		sql = "select * from hpa";

		
		long  startTime = System.currentTimeMillis();	//��ʼʱ��
		System.out.println("strat execute time: " + new java.util.Date());

		//ʵ�ʵ���ʱҪ�ִζ�ȡ�������¼���ࡣĿǰ����֧�ֵ����򣬵���ȡ��ʱ��ռ�ô����ڴ�
		ResultSet rs = stmt.executeQuery(sql);  		
		long readDataTime = System.currentTimeMillis();	//׼������ʱ��
		System.out.println("read data execute  time: " + (readDataTime - startTime)/1000 + "m");
		
		//context
		int rowNo = 0;
		int colNo = 0;
		while(rs.next()) {
			colNo = 0;
			nRow = sheet.createRow(rowNo++);

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(rs.getString(colNo));
			
			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(rs.getString(colNo));
			
			if(rowNo%100==0){			//ÿ100�������־
				System.out.println("row no: " + rowNo);
			}
			
			Thread.sleep(1);			//��Ϣһ�£���ֹ��CPUռ��
		}
		
		long finishedTime = System.currentTimeMillis();	//�������ʱ��
		System.out.println("finished execute  time: " + (finishedTime - startTime)/1000 + "m");
		
		
		FileOutputStream fOut = new FileOutputStream(xlsFile);
		wb.write(fOut);
		fOut.flush();
		fOut.close();
		
		long stopTime = System.currentTimeMillis();		//д�ļ�ʱ��
		System.out.println("write xls file time: " + (stopTime - startTime)/1000 + "m");
		
		rs.close();   
		stmt.close();   
		conn.close(); 
	}
}
