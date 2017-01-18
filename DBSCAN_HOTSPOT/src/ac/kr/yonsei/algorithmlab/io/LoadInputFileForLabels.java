package ac.kr.yonsei.algorithmlab.io;
import java.util.ArrayList;

import ac.kr.yonsei.algorithmlab.core.Common;

/**
 * KMCenters 리스트를 가져옵니다.
 * 
 * @author iypc
 *
 */
public class LoadInputFileForLabels extends LoadInputFile {

	public LoadInputFileForLabels(String fileName, String filePath) {
		super(fileName, filePath);
	}

	@SuppressWarnings("static-access")
	@Override
	public Object loadData() {
		ArrayList<String> values = null;
		int rowCount = 0;
		double[] labels = new double[Common.NumberOfTotalNodes];
		try {
			while ((values = super.csv.parseLine(super.getReader())) != null) {
				if (!(rowCount <= 0)) {
					//System.out.println(values.get(1).trim());
					labels[rowCount - 1] = Double.valueOf(values.get(1).trim());
				}
				rowCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return labels;
	}
}
