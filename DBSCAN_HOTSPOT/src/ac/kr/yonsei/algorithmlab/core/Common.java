package ac.kr.yonsei.algorithmlab.core;

/**
 * @FileName : Common.java
 * @Project : ����_DBSCAN_MC
 * @Date : 2017. 1. 3.
 * @�ۼ��� : ryu
 * @�����̷� :
 * @���α׷� ���� : �����ؾ��� ����: outputFilePath inputfilename NoOfNodes nOfClusters nodeN
 */
public class Common {

	private static Common cm;

	public static String pre = "22";

	public static String post = "100";

	public static int dems = 3;
	
	public static int lineNo = 10000;
	
	public static int realLineNo = 0;

	public static int NumberOfSeedNodes = 0;

	public static int NumberOfTotalNodes = 0;

	public static String baseFilePath = "C:\\Users\\ryu\\Desktop\\NCCU\\";
	
	public static String labelcsvfileName = "label_" + pre + "_" + post
			+ ".csv";

	public Common() {

	}

	public static Common getInstance() {
		if (cm == null) {
			cm = new Common();
		}
		return cm;
	}

}
