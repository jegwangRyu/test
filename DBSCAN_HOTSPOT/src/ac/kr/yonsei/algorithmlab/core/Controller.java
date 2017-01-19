package ac.kr.yonsei.algorithmlab.core;

import ac.kr.yonsei.algorithmlab.kernel.BaseFunction;

/**
 * 
 * @FileName : TestMain.java
 * @Project : makeDBforNCCU
 * @Date : 2016. 12. 30.
 * @작성자 : ryu
 * @변경이력 :
 * @프로그램 설명 :
 */
public class Controller {

	public static void main(String[] args) {

		// 파일명 입력
		// 경로 입력
		BaseFunction baseFunction = new BaseFunction();

		// 배열 생성
		double[][] vectors = baseFunction.setLoadData();

		// create cluster information
		baseFunction.mapping(vectors);

	}

}
