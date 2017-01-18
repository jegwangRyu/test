package ac.kr.yonsei.algorithmlab.cluster;

import java.util.ArrayList;

public class Structure {

	int clusterID;

	public ArrayList<Node> nodeXYList = new ArrayList<>();

	int minX;
	int minY;
	int MaxY;
	int MaxX;

	public int getClusterID() {
		return clusterID;
	}

	public void setClusterID(int clusterID) {
		this.clusterID = clusterID;
	}

	public int getMinX() {
		return minX;
	}

	public void setMinX(int minX) {
		this.minX = minX;
	}

	public int getMinY() {
		return minY;
	}

	public void setMinY(int minY) {
		this.minY = minY;
	}

	public int getMaxY() {
		return MaxY;
	}

	public void setMaxY(int maxY) {
		MaxY = maxY;
	}

	public int getMaxX() {
		return MaxX;
	}

	public void setMaxX(int maxX) {
		MaxX = maxX;
	}

}
