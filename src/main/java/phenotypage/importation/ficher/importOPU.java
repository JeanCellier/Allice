//package phenotypage.importation.ficher;
//
//import phenotypage.importation.poi.Poi_Excel;
//
///**
// * Created by Alex on 16/5/18.
// */
//public class importOPU
//{
//
//	public void importOpu()
//	{
//		String _url = "/Users/Alex/Desktop/16OPU.xlsx";
//		//read fiche
//		Poi_Excel.readExcel(_url, 3, 1);
//		Poi_Excel.readExcel(_url, 3, 3);
//		Poi_Excel.readExcel(_url, 3, 5);
//		Poi_Excel.readExcel(_url, 4, 1);
//		Poi_Excel.readExcel(_url, 4, 3);
//		Poi_Excel.readExcel(_url, 4, 5);
//		Poi_Excel.readExcel(_url, 5, 1);
//		//read  inden donn
//		Poi_Excel.readExcel(_url, 8, 1);
//		Poi_Excel.readExcel(_url, 9, 1);
//		Poi_Excel.readExcel(_url, 10, 1);
//		Poi_Excel.readExcel(_url, 10, 4);
//		Poi_Excel.readExcel(_url, 10, 6);
//		//read tra donn
//		Poi_Excel.readExcel(_url, 14, 3);
//		Poi_Excel.readExcel(_url, 14, 5);
//
//		int start = 17;
//		while (true)
//		{
//			String date = Poi_Excel.readExcel(_url, start, 1);
//			if (date.equals(""))
//			{
//				break;
//			}
//			Poi_Excel.readExcel(_url, start, 2);
//			Poi_Excel.readExcel(_url, start, 3);
//			Poi_Excel.readExcel(_url, start, 4);
//			start++;
//		}
//		Poi_Excel.readExcel(_url, 23, 3);
//		Poi_Excel.readExcel(_url, 24, 2);
//		Poi_Excel.readExcel(_url, 24, 4);
//		Poi_Excel.readExcel(_url, 24, 6);
//		Poi_Excel.readExcel(_url, 25, 2);
//		Poi_Excel.readExcel(_url, 27, 2);
//		Poi_Excel.readExcel(_url, 28, 1);
//		Poi_Excel.readExcel(_url, 29, 2);
//		start = 32;
//		while (true)
//		{
//			String date = Poi_Excel.readExcel(_url, start, 0);
//			if (date.equals(""))
//			{
//				break;
//			}
//			Poi_Excel.readExcel(_url, start, 1);
//			Poi_Excel.readExcel(_url, start, 4);
//			start++;
//		}
//		Poi_Excel.readExcel(_url, 43, 2);
//		Poi_Excel.readExcel(_url, 43, 3);
//		Poi_Excel.readExcel(_url, 43, 4);
//		Poi_Excel.readExcel(_url, 43, 5);
//		Poi_Excel.readExcel(_url, 43, 6);
//		Poi_Excel.readExcel(_url, 43, 7);
//		Poi_Excel.readExcel(_url, 44, 2);
//		Poi_Excel.readExcel(_url, 44, 3);
//		Poi_Excel.readExcel(_url, 44, 4);
//		Poi_Excel.readExcel(_url, 44, 5);
//		Poi_Excel.readExcel(_url, 44, 6);
//		Poi_Excel.readExcel(_url, 44, 7);
//
//
//	}
//
//}
