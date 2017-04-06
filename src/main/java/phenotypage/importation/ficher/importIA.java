//package phenotypage.importation.ficher;
//
//import phenotypage.importation.poi.Poi_Excel;
//
///**
// * Created by Alex on 16/5/18.
// */
//public class importIA
//{
//	public void importIa()
//	{
//		String _url = "/Users/Alex/Desktop/16TRA.xlsx";
//		//read fiche
//		Poi_Excel.readExcel(_url, 2, 1);
//		Poi_Excel.readExcel(_url, 2, 3);
//		Poi_Excel.readExcel(_url, 2, 6);
//		Poi_Excel.readExcel(_url, 3, 1);
//		Poi_Excel.readExcel(_url, 3, 4);
//		Poi_Excel.readExcel(_url, 3, 7);
//
//		Poi_Excel.readExcel(_url, 6, 1);
//		Poi_Excel.readExcel(_url, 7, 1);
//		Poi_Excel.readExcel(_url, 8, 2);
//		Poi_Excel.readExcel(_url, 8, 4);
//		Poi_Excel.readExcel(_url, 8, 6);
//
//		//read inse
//		Poi_Excel.readExcel(_url, 12, 1);
//		Poi_Excel.readExcel(_url, 12, 4);
//		Poi_Excel.readExcel(_url, 13, 1);
//		Poi_Excel.readExcel(_url, 13, 4);
//		Poi_Excel.readExcel(_url, 13, 6);
//		Poi_Excel.readExcel(_url, 15, 6);
//		Poi_Excel.readExcel(_url, 17, 3);
//		Poi_Excel.readExcel(_url, 18, 3);
//
//
//		//read tra
//		Poi_Excel.readExcel(_url, 21, 1);
//		Poi_Excel.readExcel(_url, 21, 6);
//
//		int start = 24;
//		while (true)
//		{
//			String date = Poi_Excel.readExcel(_url, start, 1);
//			if (date.equals(""))
//			{
//				break;
//			}
//			Poi_Excel.readExcel(_url, start, 2);
//			Poi_Excel.readExcel(_url, start, 4);
//			Poi_Excel.readExcel(_url, start, 5);
//			start++;
//		}
//
//		start = 35;
//		while (true)
//		{
//			String date = Poi_Excel.readExcel(_url, start, 1);
//			if (date.equals(""))
//			{
//				break;
//			}
//			Poi_Excel.readExcel(_url, start, 2);
//			Poi_Excel.readExcel(_url, start, 5);
//			start++;
//		}
//
//	}
//
//
//}
