package ac.kr.yonsei.algorithmlab.core;

import ac.kr.yonsei.algorithmlab.kernel.BaseFunction;

/**
 * 
 * @FileName : TestMain.java
 * @Project : makeDBforNCCU
 * @Date : 2016. 12. 30.
 * @�ۼ��� : ryu
 * @�����̷� :
 * @���α׷� ���� :
 */
public class Controller {

	public static void main(String[] args) {

		// ���ϸ� �Է�
		// ��� �Է�
		BaseFunction baseFunction = new BaseFunction();

		// �迭 ����
		double[][] vectors = baseFunction.setLoadData();

		// create cluster information
		baseFunction.mapping(vectors);

	}

}
