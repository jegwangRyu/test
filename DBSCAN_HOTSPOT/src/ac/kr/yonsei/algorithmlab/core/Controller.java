package ac.kr.yonsei.algorithmlab.core;

import java.util.ArrayList;

import ac.kr.yonsei.algorithmlab.kernel.BaseFunction;

/**
 * 
 * @FileName : TestMain.java
 * @Project : makeDBforNCCU
 * @Date : 2017. 01. 24.
 * @�ۼ��� : ryu
 * @�����̷� :
 * @���α׷� ���� :
 */
public class Controller {

	public static void main(String[] args) {

		// ���ϸ� �Է�
		BaseFunction baseFunction = new BaseFunction();

		// ���� 1���� �迭 ����
		double[][] vectors = baseFunction.setLoadData();

		// ���� 1���� �迭 ���� �� Ŭ������ ����
		baseFunction.mapping(vectors);

		// ���� ������ �ҷ��� hot spot�� ���� args: iteration ���� ��
		ArrayList<double[][]> dataList = baseFunction.setLoadFileList(0, 20);

		
		if(dataList==null||dataList.size()<=0)
		{
			//���Ͽ� �����Ͱ� ���� ���
			System.out.println("Null Point Exeption Error!");
			return;
		}
		
		for (double[][] ds : dataList) {
			baseFunction.mapping(ds);
		}
	}
}
