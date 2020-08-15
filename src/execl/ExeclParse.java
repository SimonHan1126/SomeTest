package execl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.sf.json.JSONObject;

public class ExeclParse {
	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";

	// 判断Excel的版本,获取Workbook
	public static Workbook getWorkbok(InputStream in, File file) throws IOException {
		Workbook wb = null;
		if (file.getName().endsWith(EXCEL_XLS)) { // Excel 2003
			wb = new HSSFWorkbook(in);
		} else if (file.getName().endsWith(EXCEL_XLSX)) { // Excel 2007/2010
			wb = new XSSFWorkbook(in);
		}
		return wb;
	}

	// 判断文件是否是excel
	public static void checkExcelVaild(File file) throws Exception {
		if (!file.exists()) {
			throw new Exception("文件不存在");
		}
		if (!(file.isFile() && (file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX)))) {
			throw new Exception("文件不是Excel");
		}
	}

	// 由指定的Sheet导出至List
	public static void exportListFromExcel() throws IOException {

		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// 同时支持Excel 2003、2007

			File excelFile = new File("/Users/hanshihui/Desktop/anchor_micro_time_detail.xlsx"); // 创建文件对象
			// File excelFile = new
			// File("/Users/hanshihui/Desktop/talent_0_9_micro_time.xlsx"); //
			// 创建文件对象
			FileInputStream is = new FileInputStream(excelFile); // 文件流
			checkExcelVaild(excelFile);
			Workbook workbook = getWorkbok(is, excelFile);
			// Workbook workbook = WorkbookFactory.create(is); // 这种方式
			// Excel2003/2007/2010都是可以处理的

			int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
			/**
			 * 设置当前excel中sheet的下标：0开始
			 */
			Sheet sheet = workbook.getSheetAt(0); // 遍历第一个Sheet

			// 为跳过第一行目录设置count
			int count = 0;

			for (Row row : sheet) {
				// 跳过第一行的目录
				if (count == 0) {
					count++;
					continue;
				}
				// 如果当前行没有数据，跳出循环
				if (row.getCell(0).toString().equals("")) {
					return;
				}
				String rowValue = "";
				for (Cell cell : row) {
					if (cell.toString() == null) {
						continue;
					}
					int cellType = cell.getCellType();
					String cellValue = "";
					switch (cellType) {
					case Cell.CELL_TYPE_STRING: // 文本
						cellValue = cell.getRichStringCellValue().getString() + "#";
						break;
					case Cell.CELL_TYPE_NUMERIC: // 数字、日期
						if (DateUtil.isCellDateFormatted(cell)) {
							cellValue = fmt.format(cell.getDateCellValue()) + "#";
						} else {
							cell.setCellType(Cell.CELL_TYPE_STRING);
							cellValue = String.valueOf(cell.getRichStringCellValue().getString()) + "#";
						}
						break;
					case Cell.CELL_TYPE_BOOLEAN: // 布尔型
						cellValue = String.valueOf(cell.getBooleanCellValue()) + "#";
						break;
					case Cell.CELL_TYPE_BLANK: // 空白
						cellValue = cell.getStringCellValue() + "#";
						break;
					case Cell.CELL_TYPE_ERROR: // 错误
						cellValue = "错误#";
						break;
					case Cell.CELL_TYPE_FORMULA: // 公式
						// 得到对应单元格的公式
						// cellValue = cell.getCellFormula() + "#";
						// 得到对应单元格的字符串
						cell.setCellType(Cell.CELL_TYPE_STRING);
						cellValue = String.valueOf(cell.getRichStringCellValue().getString()) + "#";
						break;
					default:
						cellValue = "#";
					}
					// System.out.print(cellValue);
					rowValue += cellValue;
				}
				System.out.println(rowValue);
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	public static void jsonToExcel() throws Exception {
		Set<String> keys = null;
		// 创建HSSFWorkbook对象
		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建HSSFSheet对象
		HSSFSheet sheet = wb.createSheet("sheet0");

		FileReader reader = new FileReader("/Users/hanshihui/Desktop/code/麦时统计-精确到小时.txt");
		BufferedReader br = new BufferedReader(reader);
		String str = null;
		int roleNo = 0;
		int rowNo = 0;
		while ((str = br.readLine()) != null) {
			JSONObject jsonObject = JSONObject.fromObject(str);
			// 创建HSSFRow对象
			HSSFRow row = sheet.createRow(roleNo++);
			// 创建HSSFCell对象
			if (keys == null) {
				// 标题
				keys = jsonObject.keySet();
				for (String s : keys) {
					HSSFCell cell = row.createCell(rowNo++);
					cell.setCellValue(s);
				}
				rowNo = 0;
				row = sheet.createRow(roleNo++);
			}

			for (String s : keys) {
				HSSFCell cell = row.createCell(rowNo++);
				cell.setCellValue(jsonObject.getString(s));
			}
			rowNo = 0;
			System.out.println(rowNo);

		}

		br.close();
		reader.close();

		// 输出Excel文件
		FileOutputStream output = new FileOutputStream("/Users/hanshihui/Desktop/code/麦时统计-精确到小时.xls");
		wb.write(output);
		wb.close();
		output.flush();
		output.close();
	}

	public static void main(String[] args) throws Exception {
		// exportListFromExcel();
//		jsonToExcel();
		String temp = "";
		try {

			File file = new File("/Users/hanshihui/Desktop/code/麦时统计.txt");
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			StringBuffer buffer = new StringBuffer();

			while ((temp = br.readLine()) != null) {
				buffer.append(temp);
			}

			// 创建HSSFWorkbook对象
			HSSFWorkbook wb = new HSSFWorkbook();
			// 创建HSSFSheet对象
			HSSFSheet sheet = wb.createSheet("sheet0");

			int roleNo = 0;
			int rowNo = 0;
			HSSFRow firstRow = sheet.createRow(roleNo++);
			for(int i = 0; i < 16; i++)
			{
				
				HSSFCell cellTitle = firstRow.createCell(rowNo++);
				if(i == 0)
				{
					
					cellTitle.setCellValue("主播ID");
				}
				else
				{
					cellTitle.setCellValue("2017年11月" + i + "日");
				}
			}
			rowNo = 0;
			JSONObject jsonObject = JSONObject.fromObject(buffer.toString());
			long ONE_HOUR = 3600;
			Iterator<String> anchorIterator = jsonObject.keys();
			while (anchorIterator.hasNext()) {
				String anchorId = anchorIterator.next();
				JSONObject achorMicroInfo = jsonObject.getJSONObject(anchorId);
				System.out.println("anchorId " + anchorId);

				HSSFRow row = sheet.createRow(roleNo++);
				HSSFCell cellAncorId = row.createCell(rowNo++);
				cellAncorId.setCellValue(anchorId);

				Iterator<String> dateToTimeIterator = achorMicroInfo.keys();
				while (dateToTimeIterator.hasNext()) {
					String date = dateToTimeIterator.next();
					long secondTime = achorMicroInfo.getLong(date);
					long hourTime = secondTime / ONE_HOUR;
					
					
					String rowNoStr = date.substring(date.length()-2,date.length());
				        
				    rowNo = Integer.valueOf(rowNoStr);
					
					HSSFCell itemAnchorTimeCell = row.createCell(rowNo);
					itemAnchorTimeCell.setCellValue(secondTime);
					System.out.println("date " + date + " secondTime " + secondTime + " hourTime " + hourTime + " rowNo " + rowNo);
				}
				rowNo = 0;
				System.out.println(rowNo);
			}
			
			
			// 输出Excel文件
			FileOutputStream output = new FileOutputStream("/Users/hanshihui/Desktop/code/麦时统计精确到秒.xls");
			wb.write(output);
			wb.close();
			output.flush();
			output.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("loadViewerAndGurdData " + e.toString());
			e.printStackTrace();
		}
	}
}