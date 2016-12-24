package com.athome.ebusiness.controller.cargo.output;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.athome.ebusiness.controller.BaseController;
import com.athome.ebusiness.service.OutProductService;
import com.athome.ebusiness.util.DownloadUtil;
import com.athome.ebusiness.vo.OutProductVO;

@Controller
public class OutProductController extends BaseController {
	@Resource
	OutProductService outProductService;

	// ת���������µ�ҳ��
	@RequestMapping("/cargo/outproduct/toedit.action")
	public String toedit() {
		return "/cargo/outproduct/jOutProduct.jsp";
	}

	// ģ���ӡ
	@RequestMapping("/cargo/outproduct/printTemplate.action")
	public void printTemplate(String inputDate, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		List<OutProductVO> dataList = outProductService.getAll(inputDate);

		// ��ģ���ļ�
		String path = request.getSession().getServletContext().getRealPath("/"); // jdk1.8 bug
																					// ��linux�²���������д��·��
		String tempFile = path + "/make/xlsprint/tOUTPRODUCT.xlsx";
		Workbook wb = new XSSFWorkbook(new FileInputStream(new File(tempFile)));

		// д��ҵ������
		Sheet sheet = wb.getSheetAt(0); // ��ù�����sheet
		Row nRow = null;
		Cell nCell = null;
		int rowNo = 2;
		int colNo = 1;

		// ��ȡ��ʽ
		nRow = sheet.getRow(2); // ����ж���
		nCell = nRow.getCell(1); // ��ȡ��Ԫ�����
		CellStyle customNameStyle = nCell.getCellStyle(); // ��ȡ����ʽ

		nCell = nRow.getCell(2);
		CellStyle contractNoStyle = nCell.getCellStyle();

		nCell = nRow.getCell(3);
		CellStyle productNoStyle = nCell.getCellStyle();

		nCell = nRow.getCell(4);
		CellStyle cnumberStyle = nCell.getCellStyle();

		nCell = nRow.getCell(5);
		CellStyle factoryStyle = nCell.getCellStyle();

		nCell = nRow.getCell(6);
		CellStyle extStyle = nCell.getCellStyle();

		nCell = nRow.getCell(7);
		CellStyle dateStyle = nCell.getCellStyle();

		nCell = nRow.getCell(9);
		CellStyle tradeStyle = nCell.getCellStyle();

		// �����
		nRow = sheet.getRow(0);
		nCell = nRow.getCell(1);
		nCell.setCellValue(inputDate.replaceFirst("-0", "-").replaceFirst("-", "��") + "�·ݳ�����"); // yyyy-MM

		// ��������
		for (int x = 0; x < 800; x++) {

			for (int j = 0; j < dataList.size(); j++) {
				System.out.println(rowNo);

				colNo = 1; // �кų�ʼ��
				OutProductVO op = dataList.get(j); // ��ȡ���������

				nRow = sheet.createRow(rowNo++);
				nRow.setHeightInPoints(24);

				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getCustomName());
				nCell.setCellStyle(customNameStyle); // ������ʽ

				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getContractNo());
				nCell.setCellStyle(contractNoStyle);

				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getProductNo());
				nCell.setCellStyle(productNoStyle);

				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getCnumber());
				nCell.setCellStyle(cnumberStyle);

				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getFactoryName());
				nCell.setCellStyle(factoryStyle);

				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getExts());
				nCell.setCellStyle(extStyle);

				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getDeliveryPeriod());
				nCell.setCellStyle(dateStyle);

				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getShipTime());
				nCell.setCellStyle(dateStyle);

				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getTradeTerms());
				nCell.setCellStyle(tradeStyle);
			}
		}

		// ����
		DownloadUtil du = new DownloadUtil();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		wb.write(os);
		du.download(os, response, "������.xlsx");
		wb.close();
	}

	@RequestMapping("/cargo/outproduct/print.action")
	public void print(String inputDate, HttpServletResponse response) throws IOException { // inputDate
																							// ��ʽ��yyyy-MM

		List<OutProductVO> dataList = outProductService.getAll(inputDate);

		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		Row nRow = null;
		Cell nCell = null;

		int rowNo = 0; // �к�
		int colNo = 1; // �к�

		// ������ʽ������������
		CellStyle nStyle = wb.createCellStyle();
		Font nFont = wb.createFont();

		sheet.setColumnWidth(0, 2 * 272); // �п�
		sheet.setColumnWidth(1, 26 * 272); // �п� BUG��API�ײ����ò�����ȷ 256��272����
		sheet.setColumnWidth(2, 12 * 272);
		sheet.setColumnWidth(3, 29 * 272);
		sheet.setColumnWidth(4, 10 * 272);
		sheet.setColumnWidth(5, 12 * 272);
		sheet.setColumnWidth(6, 8 * 272);
		sheet.setColumnWidth(7, 10 * 272);
		sheet.setColumnWidth(8, 10 * 272);
		sheet.setColumnWidth(9, 8 * 272);

		// ����⣬�ϲ���Ԫ��
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 9)); // ��ʼ�У������У���ʼ�У�������
		// �ϲ���Ԫ���������д�ںϲ�ǰ��һ����Ԫ����
		nRow = sheet.createRow(rowNo++);
		nRow.setHeightInPoints(36); // �и�

		nCell = nRow.createCell(1);
		nCell.setCellValue(inputDate.replaceFirst("-0", "-").replaceFirst("-", "��") + "�·ݳ�����"); // yyyy-MM
		nCell.setCellStyle(this.bigTitle(wb, nStyle, nFont));

		String[] title = new String[] { "�ͻ�", "������", "����", "����", "����", "����", "��������", "����", "ó������" };

		nRow = sheet.createRow(rowNo++);
		nRow.setHeightInPoints(26.25f);

		// ��ʼ��
		nStyle = wb.createCellStyle();
		nFont = wb.createFont();

		for (int i = 0; i < title.length; i++) {
			nCell = nRow.createCell(i + 1);
			nCell.setCellValue(title[i]);
			nCell.setCellStyle(this.title(wb, nStyle, nFont));
		}

		// ��ʼ��
		nStyle = wb.createCellStyle();
		nFont = wb.createFont();

		// ��������
		for (int j = 0; j < dataList.size(); j++) {
			colNo = 1; // �кų�ʼ��
			OutProductVO op = dataList.get(j); // ��ȡ���������

			nRow = sheet.createRow(rowNo++);
			nRow.setHeightInPoints(24);

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(op.getCustomName());
			nCell.setCellStyle(this.text(wb, nStyle, nFont));

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(op.getContractNo());
			nCell.setCellStyle(this.text(wb, nStyle, nFont));

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(op.getProductNo());
			nCell.setCellStyle(this.text(wb, nStyle, nFont));

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(op.getCnumber());
			nCell.setCellStyle(this.text(wb, nStyle, nFont));

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(op.getFactoryName());
			nCell.setCellStyle(this.text(wb, nStyle, nFont));

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(op.getExts());
			nCell.setCellStyle(this.text(wb, nStyle, nFont));

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(op.getDeliveryPeriod());
			nCell.setCellStyle(this.text(wb, nStyle, nFont));

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(op.getShipTime());
			nCell.setCellStyle(this.text(wb, nStyle, nFont));

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(op.getTradeTerms());
			nCell.setCellStyle(this.text(wb, nStyle, nFont));
		}

		// OutputStream os = new FileOutputStream(new
		// File("c:\\outproduct.xls"));
		// wb.write(os);
		// os.flush();
		// os.close();

		// ����
		DownloadUtil du = new DownloadUtil();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		wb.write(os);
		du.download(os, response, "������.xls");
	}

	// �������ʽ
	public CellStyle bigTitle(Workbook wb, CellStyle nStyle, Font nFont) {
		nFont.setFontName("����");
		nFont.setFontHeightInPoints((short) 16);
		nFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // ����Ӵ�

		nStyle.setAlignment(CellStyle.ALIGN_CENTER); // �������
		nStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // �������

		nStyle.setFont(nFont);

		return nStyle;
	}

	// ������ʽ
	public CellStyle title(Workbook wb, CellStyle nStyle, Font nFont) {
		nFont.setFontName("����");
		nFont.setFontHeightInPoints((short) 12);

		nStyle.setAlignment(CellStyle.ALIGN_CENTER); // �������
		nStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // �������

		// �����
		nStyle.setBorderTop(CellStyle.BORDER_THIN); // ��ϸ��
		nStyle.setBorderBottom(CellStyle.BORDER_THIN); // ��ϸ��
		nStyle.setBorderLeft(CellStyle.BORDER_THIN); // ��ϸ��
		nStyle.setBorderRight(CellStyle.BORDER_THIN); // ��ϸ��

		nStyle.setFont(nFont);

		return nStyle;
	}

	// ������ʽ
	public CellStyle text(Workbook wb, CellStyle nStyle, Font nFont) {
		nFont.setFontName("Times New Roman");
		nFont.setFontHeightInPoints((short) 10);

		nStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // �������

		// �����
		nStyle.setBorderTop(CellStyle.BORDER_THIN); // ��ϸ��
		nStyle.setBorderBottom(CellStyle.BORDER_THIN); // ��ϸ��
		nStyle.setBorderLeft(CellStyle.BORDER_THIN); // ��ϸ��
		nStyle.setBorderRight(CellStyle.BORDER_THIN); // ��ϸ��

		nStyle.setFont(nFont);

		return nStyle;
	}
}
