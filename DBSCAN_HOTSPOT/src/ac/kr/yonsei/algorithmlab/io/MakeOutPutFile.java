package ac.kr.yonsei.algorithmlab.io;


import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class MakeOutPutFile {

	// 파일명
	private String fileName;

	// 파일 경로
	private String filePath;

	// PrintStream
	private PrintStream ps;

	public MakeOutPutFile(String fileName, String filePath) {
		super();
		this.fileName = fileName;
		this.filePath = filePath;

		if (this.ps == null) {
			try {
				this.ps = new PrintStream(filePath + fileName);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

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

	public PrintStream getps() {
		return ps;
	}

	public void setps(PrintStream ps) {
		this.ps = ps;
	}

	public void txtfile(String str) {
		try {
			this.ps = new PrintStream(filePath + fileName);
			ps.print(str);
			ps.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void txtfile(ArrayList<String> strArray) {

		for (String str : strArray) {
			ps.print(str);
		}
		ps.close();
	}

	public void csvfile(int label[]) {
		try {
			this.ps = new PrintStream(filePath + fileName);

			for (int i = 0; i < label.length; i++) {
				ps.print(label[i]);
			}
			ps.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public void csvfile(String label[]) {
		try {
			this.ps = new PrintStream(filePath + fileName);

			for (int i = 0; i < label.length; i++) {
				ps.print(label[i]);
			}
			ps.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
