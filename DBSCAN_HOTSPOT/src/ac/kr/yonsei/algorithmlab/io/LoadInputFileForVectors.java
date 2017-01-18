package ac.kr.yonsei.algorithmlab.io;

import java.util.ArrayList;

import ac.kr.yonsei.algorithmlab.core.Common;

/**
 * KMCenters 리스트를 가져옵니다.
 * 
 * @author iypc
 *
 */
public class LoadInputFileForVectors extends LoadInputFile {

	public LoadInputFileForVectors(String fileName, String filePath) {
		super(fileName, filePath);
	}

	@SuppressWarnings("static-access")
	@Override
	public Object loadData() {
		ArrayList<String> values = null;
		int rowCount = 0;
		double[][] vectors = new double[Common.lineNo][Common.dems];
		try {
			while ((values = super.csv.parseLine(super.getReader())) != null) {
				if (!(rowCount <= 0)) {
					for (int i = 1; i < values.size(); i++) {
						/* System.out.print("["+rowCount+"]"+"["+i+"]"+values.get(i).trim()+"\t");*/
						vectors[rowCount - 1][i - 1] = Double.valueOf(values
								.get(i).trim());
					}
					/* System.out.println();*/
				}
				rowCount++;
			}

			Common.lineNo = rowCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vectors;
	}

	@SuppressWarnings("static-access")
	public Object loadData(int dems) {
		ArrayList<String> values = null;
		int rowCount = 0;
		double[][] vectors = new double[Common.NumberOfTotalNodes][dems];
		try {
			while ((values = super.csv.parseLine(super.getReader())) != null) {
				if (!(rowCount <= 0)) {
					for (int i = 1; i < values.size(); i++) {
						// System.out.print("["+rowCount+"]"+"["+i+"]"+values.get(i).trim()+"\t");
						vectors[rowCount - 1][i - 1] = Double.valueOf(values
								.get(i).trim());
					}
					// System.out.println();
				}
				rowCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vectors;
	}
}
