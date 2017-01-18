package ac.kr.yonsei.algorithmlab.io;
import java.util.ArrayList;

import ac.kr.yonsei.algorithmlab.core.Common;

/**
 * KMCenters 리스트를 가져옵니다.
 * 
 * @author iypc
 *
 */
public class LoadInputFileForKMCenters extends LoadInputFile {

	public LoadInputFileForKMCenters(String fileName, String filePath) {
		super(fileName, filePath);
	}

	@SuppressWarnings("static-access")
	@Override
	public Object loadData() {
		ArrayList<String> values = null;
		int rowCount = 0;
		double[][] kmCenters = new double[Common.NumberOfSeedNodes][Common.NumberOfSeedNodes];
		try {
			while ((values = super.csv.parseLine(super.getReader())) != null) {
				if (!(rowCount <= 0)) {
					for (int i = 1; i < values.size(); i++) {
						kmCenters[rowCount - 1][i - 1] = Double.valueOf(values.get(i).trim());
					}
				}
				rowCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kmCenters;
	}
	@SuppressWarnings("static-access")
	@Override
	public Object loadData(int dems) {
		ArrayList<String> values = null;
		int rowCount = 0;
		double[][] kmCenters = new double[Common.NumberOfSeedNodes][dems];
		try {
			while ((values = super.csv.parseLine(super.getReader())) != null) {
				if (!(rowCount <= 0)) {
					for (int i = 1; i < values.size(); i++) {
						kmCenters[rowCount - 1][i - 1] = Double.valueOf(values.get(i).trim());
					}
				}
				rowCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kmCenters;
	}
}
