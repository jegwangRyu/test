package ac.kr.yonsei.algorithmlab.core.ui;

import java.util.Scanner;

public class Console {

	Scanner scanner = new Scanner(System.in);

	private String fileName;

	private String filePath;

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

	public Console() {

	}

	public Console(String string, String string2) {
	}

	public void eventProcessing() {
		// message();
	}

}
