package poi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

public class testPOIDemo {
	@Test
	public void HSSF() throws IOException{
		//1.����һ��������excel�ļ�
		Workbook wb = new HSSFWorkbook();		//HSSF����excel 2003���°汾
		//2.����һ��������sheet
		Sheet sheet = wb.createSheet();
		//3.����һ���ж���Row
		Row nRow = sheet.createRow(4);			//������,�����0��ʼ
		//4.����һ����Ԫ�����ָ����
		Cell nCell = nRow.createCell(3);		//������
		//5.����Ԫ����������
		nCell.setCellValue("���ǲ������곤��");
		//6.����
		OutputStream os = new FileOutputStream(new File("c:\\testPOI.xls"));
		wb.write(os);
		//7.�ر�
		os.close();
		wb.close();
	}
	
	
	//����ʽ���򻯶��󴴽���������ʽ
	@Test
	public void HSSFStyle() throws IOException{
		Workbook wb = new HSSFWorkbook();				//HSSF����excel 2003���°汾
		Sheet sheet = wb.createSheet();
		Row nRow = sheet.createRow(4);					//������,�����0��ʼ
		Cell nCell = nRow.createCell(3);				//������
		
		CellStyle nStyle = wb.createCellStyle();
		Font nFont = wb.createFont();
		
		
		nCell.setCellValue("���ǲ������곤��");
		nCell.setCellStyle(this.titleStyle(wb, nStyle, nFont));
		
		//�ٴ���һ����Ԫ��
		nRow = sheet.createRow(5);
		nCell = nRow.createCell(5);
		
		nCell.setCellValue("java.itcast.cn");
		
		//��ʽ��ʼ��
		nStyle = wb.createCellStyle();
		nFont = wb.createFont();
		nCell.setCellStyle(this.textStyle(wb, nStyle, nFont));
		
		OutputStream os = new FileOutputStream(new File("c:\\testPOI.xls"));
		wb.write(os);
		os.close();
	}
	
	//����ʽ
	@Test
	public void HSSFStyleFont() throws IOException{
		Workbook wb = new HSSFWorkbook();				//HSSF����excel 2003���°汾
		Sheet sheet = wb.createSheet();
		Row nRow = sheet.createRow(4);					//������,�����0��ʼ
		Cell nCell = nRow.createCell(3);				//������
		
		nCell.setCellValue("���ǲ������곤��");
		
		//����һ����Ԫ����ʽ
		CellStyle nStyle = wb.createCellStyle();
		//����һ���������
		Font nFont = wb.createFont();
		nFont.setFontName("�����п�");				//��������
		nFont.setFontHeightInPoints((short)26);		//���������С
		
		nStyle.setFont(nFont);
		nCell.setCellStyle(nStyle);
		
		//�ٴ���һ����Ԫ��
		nRow = sheet.createRow(5);
		nCell = nRow.createCell(5);
		
		nCell.setCellValue("java.itcast.cn");
		
		nStyle = wb.createCellStyle();
		nFont = wb.createFont();
		nFont.setFontName("Times New Roman");
		nFont.setFontHeightInPoints((short)12);
		
		nStyle.setFont(nFont);
		nCell.setCellStyle(nStyle);
		
		OutputStream os = new FileOutputStream(new File("c:\\testPOI.xls"));
		wb.write(os);
		os.close();
		wb.close();
	}
	
	
	//����ʽ
	@Test
	public void HSSFStyleMore() throws IOException{
		Workbook wb = new HSSFWorkbook();				//HSSF����excel 2003���°汾
		Sheet sheet = wb.createSheet();
		Row nRow = sheet.createRow(4);					//������,�����0��ʼ
		Cell nCell = nRow.createCell(3);				//������
		
		nCell.setCellValue("���ǲ������곤��");
		
		//����һ����Ԫ����ʽ
		CellStyle titleStyle = wb.createCellStyle();
		//����һ���������
		Font titleFont = wb.createFont();
		titleFont.setFontName("�����п�");				//��������
		titleFont.setFontHeightInPoints((short)26);		//���������С
		
		titleStyle.setFont(titleFont);
		
		//�ٴ���һ����Ԫ��
		Row xRow = sheet.createRow(5);
		Cell xCell = xRow.createCell(5);
		
		xCell.setCellValue("java.itcast.cn");
		
		CellStyle textStyle = wb.createCellStyle();
		Font textFont = wb.createFont();
		textFont.setFontName("Times New Roman");
		textFont.setFontHeightInPoints((short)12);
		
		textStyle.setFont(textFont);
		
		xCell.setCellStyle(textStyle);
		
		nCell.setCellStyle(titleStyle);
		OutputStream os = new FileOutputStream(new File("c:\\testPOI.xls"));
		wb.write(os);
		os.close();
	}
	
	//������ʽ
	public CellStyle titleStyle(Workbook wb, CellStyle nStyle ,Font nFont ){
		nFont.setFontName("�����п�");				//��������
		nFont.setFontHeightInPoints((short)28);		//���������С
		nStyle.setFont(nFont);						//���������
		
		return nStyle;
	}
	
	//������ʽ
	public CellStyle textStyle(Workbook wb, CellStyle nStyle ,Font nFont ){
		nFont.setFontName("Times New Roman");				//��������
		nFont.setFontHeightInPoints((short)12);				//���������С
		nStyle.setFont(nFont);								//���������
		
		return nStyle;
	}
}
