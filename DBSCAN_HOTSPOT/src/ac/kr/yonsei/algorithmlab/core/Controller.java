package ac.kr.yonsei.algorithmlab.core;

import java.util.ArrayList;

import ac.kr.yonsei.algorithmlab.kernel.BaseFunction;

/**
 * 
 * @FileName : TestMain.java
 * @Project : makeDBforNCCU
 * @Date : 2017. 01. 24.
 * @작성자 : ryu
 * @변경이력 :
 * @프로그램 설명 :
 */
public class Controller {

	public static void main(String[] args) {

		// 파일명 입력
		BaseFunction baseFunction = new BaseFunction();

		// 파일 1개의 배열 생성
		double[][] vectors = baseFunction.setLoadData();

		// 파일 1개의 배열 생성 후 클러스터 매핑
		baseFunction.mapping(vectors);

		// 여러 파일을 불러와 hot spot을 구성 args: iteration 시작 끝
		ArrayList<double[][]> dataList = baseFunction.setLoadFileList(0, 20);

		
		if(dataList==null||dataList.size()<=0)
		{
			//파일에 데이터가 없는 경우
			System.out.println("Null Point Exeption Error!");
			return;
		}
		
		for (double[][] ds : dataList) {
			baseFunction.mapping(ds);
		}
	}
}
