package ac.kr.yonsei.algorithmlab.io;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * �ڹ� ���α׷������� ������ ������ �ҷ����� ������ ����ϴ� �������̽��Դϴ�.
 * 
 * @author iypc
 *
 */
public class LoadInputFile {

	private String fileName;

	private String filePath;

	private BufferedReader reader;

	CSVHelper csv = new CSVHelper();

	public LoadInputFile(String fileName, String filePath) {
		super();
		this.fileName = fileName;
		this.filePath = filePath;

		if (reader == null) {
			try {
				reader = new BufferedReader(new FileReader(filePath + fileName));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public Object loadData() {
		return null;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public BufferedReader getReader() {
		return reader;
	}

	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}

	public CSVHelper getCsv() {
		return csv;
	}

	public void setCsv(CSVHelper csv) {
		this.csv = csv;
	}

	public Object loadData(int dems) {
		return null;
	}
}
