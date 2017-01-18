/**
 * 
 */
package ac.kr.yonsei.algorithmlab.kernel;

import java.util.TreeSet;

import ac.kr.yonsei.algorithmlab.cluster.Manager;
import ac.kr.yonsei.algorithmlab.cluster.Node;
import ac.kr.yonsei.algorithmlab.cluster.Structure;
import ac.kr.yonsei.algorithmlab.core.Common;
import ac.kr.yonsei.algorithmlab.io.LoadInputFile;
import ac.kr.yonsei.algorithmlab.io.LoadInputFileForVectors;

/**
 * @FileName : BaseFunction.java
 * @Project : 실험_DBSCAN_MC
 * @Date : 2017. 1. 3.
 * @작성자 : iypc
 * @변경이력 :
 * @프로그램 설명 : 반드시 구현해야하는 함수들의 모음
 */
public class BaseFunction {

	/**
	 * @Method Name : setLoadData
	 * @작성일 : 2017. 1. 4.
	 * @작성자 : iypc
	 * @변경이력 :
	 * @Method 설명 : 상태 벡터 리스트를 변형하여 파일로 생성한다.
	 */
	public double[][] setLoadData() {

		LoadInputFile loadInputFileForVectors = new LoadInputFileForVectors(
				Common.labelcsvfileName, Common.baseFilePath);
		double[][] vectors = (double[][]) loadInputFileForVectors.loadData();

		return vectors;

	}

	/**
	 * 
	 * @param vectors
	 * 클러스터별 데이터 초기화
	 */
	public void mapping(double[][] vectors) {
		
		// cluster 개수 카운드
		TreeSet<Double> tempTree = new TreeSet<>();

		for (int i = 0; i < vectors.length; i++) {
			tempTree.add(vectors[i][0]);
		}

		for (Double value : tempTree) {
			System.out.println(value);
		}

		Manager manager = new Manager();

		for (double value : tempTree) {

			Structure structure = new Structure();

			structure.setClusterID((int) value);

			manager.strList.add(structure);
		}
		
		for (int i = 0; i < vectors.length; i++) {

			for (Structure structure : manager.strList) {
				if (vectors[i][0] == structure.getClusterID()) {
					
					/*System.out.println("test value list");
					System.out.println("ClusterID:"+structure.getClusterID());
					System.out.println("\t currentMaxX:" + structure.getMaxX());
					System.out.println("\t currentMinX:" + structure.getMinX());
					System.out.println("\t currentMaxY:" + structure.getMaxY());
					System.out.println("\t currentMinY:" + structure.getMinY());*/
					
					Node node = new Node();
					node.setX((int) vectors[i][1]);
					node.setY((int) vectors[i][2]);

					int currentMaxX = structure.getMaxX();
					int currentMaxY = structure.getMaxY();
					int currentMinX = structure.getMinX();
					int currentMinY = structure.getMinY();

					int inputX = (int) vectors[i][1];
					int inputY = (int) vectors[i][2];

					structure.setMaxX(MaxValue(inputX, currentMaxX));
					structure.setMaxY(MaxValue(inputY, currentMaxY));
					
					if(structure.nodeXYList.size()<=0)
					{
						structure.setMinX(MaxValue(inputX, currentMinX));
						structure.setMinY(MaxValue(inputY, currentMinY));
					}else
					{
						structure.setMinX(MinValue(inputX, currentMinX));
						structure.setMinY(MinValue(inputY, currentMinY));
					}
					
					/*System.out.println("test value list");
					System.out.println("ClusterID:"+structure.getClusterID());
					System.out.println("\t currentMaxX:" + currentMaxX);
					System.out.println("\t currentMinX:" + currentMinX);
					System.out.println("\t currentMaxY:" + currentMaxY);
					System.out.println("\t currentMinY:" + currentMaxY);
					System.out.println("\t inputX:" + inputX);
					System.out.println("\t inputY:" + inputY);
					
					System.out.print("Cluster ID:" + structure.getClusterID());
					System.out.print("\t MaxX:" + structure.getMaxX());
					System.out.print("\t MinX:" + structure.getMinX());
					System.out.print("\t MaxY:" + structure.getMaxY());
					System.out.print("\t MinY:" + structure.getMinY() + "\n");
					*/
					structure.nodeXYList.add(node);
				}
			}
			
			/*for (Structure temp : manager.strList) {
				System.out.print("Cluster ID:" + temp.getClusterID());
				System.out.print("\t MaxX:" + temp.getMaxX());
				System.out.print("\t MinX:" + temp.getMinX());
				System.out.print("\t MaxY:" + temp.getMaxY());
				System.out.print("\t MinY:" + temp.getMinY() + "\n");
			}*/

		}

		for (Structure temp : manager.strList) {
			System.out.print("Cluster ID:" + temp.getClusterID());
			System.out.print("\t MaxX:" + temp.getMaxX());
			System.out.print("\t MinX:" + temp.getMinX());
			System.out.print("\t MaxY:" + temp.getMaxY());
			System.out.print("\t MinY:" + temp.getMinY() + "\n");
		}
	}

	public int MaxValue(int v1, int v2) {

		int result = 0;
		if (v1 < v2) {
			result = v2;
		} else {
			result = v1;
		}

		return result;
	}

	public int MinValue(int v1, int v2) {
		int result = 0;
		if (v1 < v2) {
			result = v1;
		} else {
			result = v2;
		}

		return result;
	}
	/**
	 * @Method Name : setValuesLoadData
	 * @작성일 : 2017. 1. 4.
	 * @작성자 : iypc
	 * @변경이력 :
	 * @Method 설명 :
	 */
	/*
	 * public ClusteringResult setValuesLoadData() {
	 * 
	 * Common.NumberOfTotalNodes = Integer.valueOf(Common.NumberOfTotalNodes);
	 * String numberOfRateSeedeNode =
	 * String.valueOf(Common.NumberOfSeedNodes);// sc.nextLine();
	 * Common.NumberOfSeedNodes = Integer.valueOf(numberOfRateSeedeNode);
	 * 
	 * // 클러스터 센터 리스트 가져오기 LoadInputFile loadInputFileForKMCenters = new
	 * LoadInputFileForKMCenters(Common.fileNameClusterCenter,
	 * Common.baseFilePath); double[][] kmCenters = (double[][])
	 * loadInputFileForKMCenters.loadData();
	 * 
	 * // 클러스터 벡터 리스트 가져오기 LoadInputFile loadInputFileForVectors = new
	 * LoadInputFileForVectors(Common.fileNameEigenVectors,
	 * Common.baseFilePath); double[][] vectors = (double[][])
	 * loadInputFileForVectors.loadData();
	 * 
	 * // 레이블 리스트 가져오기 LoadInputFile loadInputFileForLabels = new
	 * LoadInputFileForLabels(Common.fileNameLabels, Common.baseFilePath);
	 * double[] labels = (double[]) loadInputFileForLabels.loadData();
	 * 
	 * // 각 클러스터 별 totalCount int[] temptotalCountofEachLabel = new
	 * int[Common.NumberOfSeedNodes];
	 * 
	 * for (int i = 0; i < Common.NumberOfSeedNodes; i++) { for (int j = 0; j <
	 * labels.length; j++) { if ((i + 1) == labels[j])
	 * temptotalCountofEachLabel[i]++; } }
	 * 
	 * ClusteringResult clusteringResult = new ClusteringResult();
	 * clusteringResult.kmCenters = kmCenters; clusteringResult.labels = labels;
	 * clusteringResult.temptotalCountofEachLabel = temptotalCountofEachLabel;
	 * clusteringResult.vectors = vectors; return clusteringResult;
	 * 
	 * }
	 */
	/*	*//**
	 * @Method Name : setKgroup
	 * @작성일 : 2017. 1. 4.
	 * @작성자 : iypc
	 * @변경이력 :
	 * @Method 설명 :
	 */
	/*
	 * public ArrayList<KGroup> setKgroup(ClusteringResult clusteringResult) {
	 * 
	 * double[][] kmCenters = clusteringResult.kmCenters; double[] labels =
	 * clusteringResult.labels; int[] temptotalCountofEachLabel =
	 * clusteringResult.temptotalCountofEachLabel; double[][] vectors =
	 * clusteringResult.vectors;
	 * 
	 * ArrayList<KGroup> kGroups = new ArrayList<>(); for (int i = 0; i <
	 * Common.NumberOfSeedNodes; i++) {
	 * 
	 * KGroup group = new KGroup(); group.id = i + 1; group.originalIDX = new
	 * int[temptotalCountofEachLabel[i]]; group.DistanceCenterEachVector = new
	 * double[temptotalCountofEachLabel[i]]; group.vectors = new
	 * double[temptotalCountofEachLabel[i]][Common.NumberOfSeedNodes];
	 * 
	 * for (int j = 0; j < Common.NumberOfSeedNodes; j++) {
	 * group.centerVector[j] = kmCenters[i][j]; }
	 * 
	 * int rowCont = 0; for (int j = 0; j < Common.NumberOfTotalNodes; j++) { if
	 * (group.id == labels[j]) { for (int k = 0; k < Common.NumberOfSeedNodes;
	 * k++) { group.originalIDX[rowCont] = j; group.vectors[rowCont][k] =
	 * vectors[j][k]; } rowCont++; } } kGroups.add(group); }
	 * 
	 * // 유사도 측정 for (int j = 0; j < Common.NumberOfSeedNodes; j++) { KGroup
	 * tempGroup = kGroups.get(j); tempGroup.topDistanceValue = 99999;
	 * tempGroup.topVectorIndex = -1; double[] firstVector =
	 * tempGroup.centerVector; double[][] secondVector = tempGroup.vectors; for
	 * (int i = 0; i < tempGroup.originalIDX.length; i++) {
	 * tempGroup.DistanceCenterEachVector[i] = tempGroup.func(firstVector,
	 * secondVector, i);
	 * 
	 * if (tempGroup.topDistanceValue >= tempGroup.DistanceCenterEachVector[i])
	 * { tempGroup.topVectorIndex = tempGroup.originalIDX[i];// i;
	 * tempGroup.topDistanceValue = tempGroup.DistanceCenterEachVector[i]; } } }
	 * return kGroups;
	 * 
	 * }
	 *//**
	 * @Method Name : wirteResultSeed
	 * @작성일 : 2017. 1. 4.
	 * @작성자 : iypc
	 * @변경이력 :
	 * @Method 설명 :
	 */
	/*
	 * public void wirteResultSeed(ArrayList<KGroup> kGroups) { // 결과 출력 String
	 * emptyString = ""; String resOfSpectral = emptyString; for (int j = 0; j <
	 * Common.NumberOfSeedNodes; j++) { KGroup tempGroup = kGroups.get(j);
	 * System.out.print(tempGroup.topVectorIndex + "\t"); resOfSpectral +=
	 * tempGroup.topVectorIndex + "\t"; } MakeOutPutFile makeOutPutFile = new
	 * MakeOutPutFile(Common.fileNameResultOfSpectral, Common.baseFilePath);
	 * makeOutPutFile.txtfile(resOfSpectral); }
	 *//**
	 * @Method Name : setValuesLoadDataKM
	 * @작성일 : 2017. 1. 4.
	 * @작성자 : iypc
	 * @변경이력 :
	 * @Method 설명 :
	 * @return
	 */
	/*
	 * public ClusteringResult setValuesLoadDataKM() { // 클러스터 센터 리스트 가져오기
	 * LoadInputFile loadInputFileForKMCentersForKM = new
	 * LoadInputFileForKMCenters(Common.fileNameKMClusterCenter,
	 * Common.baseFilePath); double[][] kmCentersForKM = (double[][])
	 * loadInputFileForKMCentersForKM.loadData(Common.dems);
	 * 
	 * // 클러스터 벡터 리스트 가져오기 LoadInputFile loadInputFileForKMVectors = new
	 * LoadInputFileForVectors(Common.fileNameKMVectors, Common.baseFilePath);
	 * double[][] kmvectors = (double[][])
	 * loadInputFileForKMVectors.loadData(Common.dems);
	 * 
	 * // 레이블 리스트 가져오기 LoadInputFile loadInputFileForKMLabels = new
	 * LoadInputFileForLabels(Common.fileNameKMLabels, Common.baseFilePath);
	 * double[] kmlabels = (double[]) loadInputFileForKMLabels.loadData();
	 * 
	 * int[] temptotalCountofEachKMLabel = new int[Common.NumberOfSeedNodes];
	 * 
	 * for (int i = 0; i < Common.NumberOfSeedNodes; i++) { for (int j = 0; j <
	 * kmlabels.length; j++) { if ((i + 1) == kmlabels[j])
	 * temptotalCountofEachKMLabel[i]++; } }
	 * 
	 * ClusteringResult clusteringResult = new ClusteringResult();
	 * clusteringResult.kmCenters = kmCentersForKM; clusteringResult.labels =
	 * kmlabels; clusteringResult.temptotalCountofEachLabel =
	 * temptotalCountofEachKMLabel; clusteringResult.vectors = kmvectors; return
	 * clusteringResult; }
	 *//**
	 * @Method Name : setKgroupKM
	 * @작성일 : 2017. 1. 4.
	 * @작성자 : iypc
	 * @변경이력 :
	 * @Method 설명 :
	 * @param clusteringResult
	 * @return
	 */
	/*
	 * public ArrayList<KGroup> setKgroupKM(ClusteringResult clusteringResult) {
	 * 
	 * double[][] kmCentersForKM = clusteringResult.kmCenters; double[] kmlabels
	 * = clusteringResult.labels; int[] temptotalCountofEachKMLabel =
	 * clusteringResult.temptotalCountofEachLabel; double[][] kmvectors =
	 * clusteringResult.vectors;
	 * 
	 * // 그룹만들기 ArrayList<KGroup> kmGroups = new ArrayList<>(); for (int i = 0;
	 * i < Common.NumberOfSeedNodes; i++) {
	 * 
	 * KGroup group = new KGroup(); group.id = i + 1; group.originalIDX = new
	 * int[temptotalCountofEachKMLabel[i]]; group.DistanceCenterEachVector = new
	 * double[temptotalCountofEachKMLabel[i]]; group.vectors = new
	 * double[temptotalCountofEachKMLabel[i]][Common.dems];
	 * 
	 * for (int j = 0; j < Common.dems; j++) { group.centerKMVector[j] =
	 * kmCentersForKM[i][j]; }
	 * 
	 * int rowCont = 0; for (int j = 0; j < Common.NumberOfTotalNodes; j++) { if
	 * (group.id == kmlabels[j]) { for (int k = 0; k < Common.dems; k++) {
	 * group.originalIDX[rowCont] = j; group.vectors[rowCont][k] =
	 * kmvectors[j][k]; } rowCont++; } } kmGroups.add(group); }
	 * 
	 * // 유사도 측정 for (int j = 0; j < Common.NumberOfSeedNodes; j++) { KGroup
	 * tempGroup = kmGroups.get(j); tempGroup.topDistanceValue = 99999;
	 * tempGroup.topVectorIndex = -1; double[] firstVector =
	 * tempGroup.centerKMVector; double[][] secondVector = tempGroup.vectors;
	 * for (int i = 0; i < tempGroup.originalIDX.length; i++) {
	 * tempGroup.DistanceCenterEachVector[i] = tempGroup.func(firstVector,
	 * secondVector, i);
	 * 
	 * if (tempGroup.topDistanceValue >= tempGroup.DistanceCenterEachVector[i])
	 * { tempGroup.topVectorIndex = tempGroup.originalIDX[i];// i;
	 * tempGroup.topDistanceValue = tempGroup.DistanceCenterEachVector[i]; } } }
	 * 
	 * return kmGroups; }
	 *//**
	 * @Method Name : wirteResultSeedKM
	 * @작성일 : 2017. 1. 4.
	 * @작성자 : iypc
	 * @변경이력 :
	 * @Method 설명 :
	 * @param groups
	 */
	/*
	 * public void wirteResultSeedKM(ArrayList<KGroup> kmGroups) { String
	 * resOfKM = ""; for (int j = 0; j < Common.NumberOfSeedNodes; j++) { KGroup
	 * tempGroup = kmGroups.get(j); System.out.print(tempGroup.topVectorIndex +
	 * "\t"); resOfKM += tempGroup.topVectorIndex + "\t"; } MakeOutPutFile
	 * makeOutPutFileForKM = new MakeOutPutFile(Common.fileNameResultOfKMeans,
	 * Common.baseFilePath); makeOutPutFileForKM.txtfile(resOfKM);
	 * System.out.println();
	 * 
	 * }
	 */

}
