//package phenotypage.importation.ficher;
//
//import phenotypage.importation.poi.Poi_Excel;
//
///**
// * Created by Alex on 16/5/18.
// */
//public class importTRA
//{
//	public void importTra()
//	{
//		String _url = "/Users/Alex/Desktop/16TRA.xlsx";
//		//read fiche
//		Poi_Excel.readExcel(_url, 2, 1);
//		Poi_Excel.readExcel(_url, 2, 4);
//		Poi_Excel.readExcel(_url, 2, 6);
//		Poi_Excel.readExcel(_url, 3, 1);
//		Poi_Excel.readExcel(_url, 3, 3);
//		Poi_Excel.readExcel(_url, 3, 6);
//
//
//		//read identification
//		Poi_Excel.readExcel(_url, 6, 1);
//		Poi_Excel.readExcel(_url, 7, 1);
//		Poi_Excel.readExcel(_url, 8, 1);
//		Poi_Excel.readExcel(_url, 8, 4);
//		Poi_Excel.readExcel(_url, 8, 6);
//		Poi_Excel.readExcel(_url, 9, 1);
//
//		//traitement_acte rece
//		Poi_Excel.readExcel(_url, 12, 1);
//		Poi_Excel.readExcel(_url, 12, 4);
//
//
//		int start = 15;
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
//		//evaluation
//		Poi_Excel.readExcel(_url, 22, 1);
//		Poi_Excel.readExcel(_url, 23, 1);
//		Poi_Excel.readExcel(_url, 24, 1);
//		Poi_Excel.readExcel(_url, 23, 5);
//
//		//embryon
//		Poi_Excel.readExcel(_url, 27, 1);
//		Poi_Excel.readExcel(_url, 27, 4);
//		Poi_Excel.readExcel(_url, 28, 1);
//		Poi_Excel.readExcel(_url, 28, 4);
//		Poi_Excel.readExcel(_url, 28, 6);
//		Poi_Excel.readExcel(_url, 29, 1);
//		Poi_Excel.readExcel(_url, 30, 1);
//		Poi_Excel.readExcel(_url, 31, 1);
//
//		//suive de gestion
//		start = 36;
//		while (true)
//		{
//			String date = Poi_Excel.readExcel(_url, start, 1);
//			if (date.equals(""))
//			{
//				break;
//			}
//			Poi_Excel.readExcel(_url, start, 2);
//			Poi_Excel.readExcel(_url, start, 3);
//			start++;
//		}
//
//		//remarques
//
//
//	}
//}
