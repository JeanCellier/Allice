package phenotypage.importation.poi;

/**
 * Created by Alex on 16/5/12.
 */

import org.apache.poi.ss.usermodel.*;
import phenotypage.importation.util.NumberUtils;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

public class Poi_Excel
{
	static SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
	static Map<String, CellStyle> styleMap = new HashMap<String, CellStyle>(); //map excel

	public static String readExcel(String filePath, int x, int y)
	{
		Workbook book = null;
		String value = "";

		try
		{
			book = getExcelWorkbook(filePath);
			Sheet sheet = getSheetByNum(book, 1);
			Row row = null;
			row = sheet.getRow(x);
			if (row != null)
			{
				Cell cell = null;
				StringBuilder sb = null;
				cell = row.getCell(y);
				if (cell != null)
				{
					int type = cell.getCellType();
					switch (type)
					{
						case 0:
							if (DateUtil.isCellDateFormatted(cell))
							{
								Date date = cell.getDateCellValue();
								value = sFormat.format(date);
							}
							else
							{
								double tempValue = cell.getNumericCellValue();
								value = String.valueOf(tempValue);
							}
							break;
						case 1:
							value = cell.getStringCellValue();
							break;
						case 2:
							value = cell.getCellFormula();
							break;
						case 3:
							value = cell.getStringCellValue();
							break;
						case 4:
							boolean tempValue = cell.getBooleanCellValue();
							value = String.valueOf(tempValue);
							break;
						case 5:
							byte b = cell.getErrorCellValue();
							value = String.valueOf(b);
						default:
							break;
					}
					System.out.println(value);
				}
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return value;
	}


	/**
	 * read excel
	 *
	 * @param filePath excel
	 */
	public static void readExcel(String filePath)
	{
		Workbook book = null;
		try
		{
			book = getExcelWorkbook(filePath);
			Sheet sheet = getSheetByNum(book, 1);
			System.out.println("sheet name：" + sheet.getSheetName());

			int lastRowNum = sheet.getLastRowNum();

			Row row = null;
			for (int i = 0; i <= lastRowNum; i++)
			{
				row = sheet.getRow(i);
				if (row != null)
				{
					System.out.println("lire ligne" + (i + 1) + "：");
					int lastCellNum = row.getLastCellNum();
					Cell cell = null;
					StringBuilder sb = null;
					for (int j = 0; j < lastCellNum; j++)
					{
						cell = row.getCell(j);
						if (cell != null)
						{
							sb = new StringBuilder("context " + (j + 1) + "：");
							String type_cn = null;
							String type_style = cell.getCellStyle().getDataFormatString().toUpperCase();
							String type_style_cn = getCellStyleByChinese(type_style);
							int type = cell.getCellType();
							String value = "";
							switch (type)
							{
								case 0:
									if (DateUtil.isCellDateFormatted(cell))
									{
										type_cn = "NUMBER-DATE";
										Date date = cell.getDateCellValue();
										value = sFormat.format(date);
									}
									else
									{
										type_cn = "NUMBER";
										double tempValue = cell.getNumericCellValue();
										value = String.valueOf(tempValue);
									}
									break;
								case 1:
									type_cn = "STRING";
									value = cell.getStringCellValue();
									break;
								case 2:
									type_cn = "FORMULA";
									value = cell.getCellFormula();
									break;
								case 3:
									type_cn = "BLANK";
									value = cell.getStringCellValue();
									break;
								case 4:
									type_cn = "BOOLEAN";
									boolean tempValue = cell.getBooleanCellValue();
									value = String.valueOf(tempValue);
									break;
								case 5:
									type_cn = "ERROR";
									byte b = cell.getErrorCellValue();
									value = String.valueOf(b);
								default:
									break;
							}
							sb.append(value + ",context：" + type_cn + ",type：" + type_style_cn);
							System.out.println(sb.toString());
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	/**
	 * @param type_style
	 * @return
	 */
	private static String getCellStyleByChinese(String type_style)
	{
		String cell_style_cn = "";
		if (type_style.contains("GENERAL"))
		{
			cell_style_cn = "general";
		}
		else if (type_style.equals("_ * #,##0.00_ ;_ * \\-#,##0.00_ ;_ * \"-\"??_ ;_ @_ "))
		{
			cell_style_cn = "pro";
		}
		else if (type_style.equals("0"))
		{
			cell_style_cn = "int";
		}
		else if (type_style.contains("YYYY/MM") || type_style.contains("YYYY\\-MM"))
		{
			cell_style_cn = "data";
		}
		else if (type_style.equals("0.00%"))
		{
			cell_style_cn = "/100";
		}
		else
		{
			cell_style_cn = "unknow:" + type_style;
//			cell_style_cn = type_style;
		}
		return cell_style_cn;
	}


	/**
	 * test write excel
	 *
	 * @throws IOException
	 */
	public static void testWrite(String srcFilePath, String tarFilePath)
	{
		FileOutputStream out = null;
		try
		{
			Workbook book = getExcelWorkbook(srcFilePath);
			Sheet sheet = getSheetByNum(book, 1);

			Map<String, String> map = new HashMap<String, String>();
			List<Map<String, String>> list = new LinkedList<Map<String, String>>();
			map.put("A", "4,INT");
			map.put("B", "toto,GENERAL");
			map.put("C", "18,INT");
			map.put("D", "1990-03-10,DATE");
			map.put("E", "0.056,PERCENT");
			map.put("F", "4800,DOUBLE");
			list.add(map);

			int startRow = 6;
			boolean result = writeToExcel(list, sheet, startRow);
			if (result)
			{
				out = new FileOutputStream(tarFilePath);
				book.write(out);
				System.out.println(" done！");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				out.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param list
	 */
	public static boolean writeToExcel(List<Map<String, String>> list, Sheet sheet, int startRow)
	{
		boolean result = false;
		try
		{
			Map<String, String> map = null;
			Row row = null;
			for (int i = 0; i < list.size(); i++)
			{
				map = list.get(i);
				row = sheet.getRow(startRow - 1);
				if (row == null)
				{
					row = sheet.createRow(startRow - 1);
				}
				startRow++;
				Cell cell = null;

				BigDecimal db = null;
				for (Map.Entry<String, String> entry : map.entrySet())
				{
					String key = entry.getKey();
					int colNum = NumberUtils.toNum_new(key) - 1;

					String value_type = entry.getValue();
					String value = value_type.split(",")[0];
					String style = value_type.split(",")[1];

					cell = row.getCell(colNum);
					if (cell == null)
					{
						cell = row.createCell(colNum);
					}
					if (style.equals("GENERAL"))
					{
						cell.setCellValue(value);
					}
					else
					{
						if (style.equals("DOUBLE") || style.equals("INT"))
						{
							db = new BigDecimal(value, java.math.MathContext.UNLIMITED);
							cell.setCellValue(db.doubleValue());
						}
						else if (style.equals("PERCENT"))
						{
							db = new BigDecimal(value, java.math.MathContext.UNLIMITED);
							cell.setCellValue(db.doubleValue());
						}
						else if (style.equals("DATE"))
						{
							Date date = sFormat.parse(value);
							cell.setCellValue(date);
						}
						cell.setCellStyle(styleMap.get(style));
					}
				}
			}
			result = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return result;
	}

	/**
	 * excelWorkbook
	 *
	 * @throws IOException
	 */
	public static Workbook getExcelWorkbook(String filePath) throws IOException
	{
		Workbook book = null;
		File file = null;
		InputStream fis = null;

		try
		{
			file = new File(filePath);
			if (!file.exists())
			{
				throw new RuntimeException("file not exist.");
			}
			else
			{
				fis = new FileInputStream(file);
				book = WorkbookFactory.create(fis);
				initStyleMap(book);
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
		finally
		{
			if (fis != null)
			{
				fis.close();
			}
		}
		return book;
	}

	/**
	 * get sheet by index
	 *
	 * @param number
	 */
	public static Sheet getSheetByNum(Workbook book, int number)
	{
		Sheet sheet = null;
		try
		{
			sheet = book.getSheetAt(number - 1);
//			if(sheet == null){
//				sheet = book.createSheet("Sheet"+number);
//			}
		}
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
		return sheet;
	}

	/**
	 * Map
	 */


	public static void initStyleMap(Workbook book)
	{
		DataFormat hssfDF = book.createDataFormat();

		CellStyle doubleStyle = book.createCellStyle();
		doubleStyle.setDataFormat(hssfDF.getFormat("_ * #,##0.00_ ;_ * \\-#,##0.00_ ;_ * \"-\"??_ ;_ @_ "));
		styleMap.put("DOUBLE", doubleStyle);

		CellStyle intStyle = book.createCellStyle();
		intStyle.setDataFormat(hssfDF.getFormat("0"));
		styleMap.put("INT", intStyle);

		CellStyle yyyyMMddStyle = book.createCellStyle();
		yyyyMMddStyle.setDataFormat(hssfDF.getFormat("yyyy-MM-dd"));
		styleMap.put("DATE", yyyyMMddStyle);

		CellStyle percentStyle = book.createCellStyle();
		percentStyle.setDataFormat(hssfDF.getFormat("0.00%"));
		styleMap.put("PERCENT", percentStyle);
	}

}
