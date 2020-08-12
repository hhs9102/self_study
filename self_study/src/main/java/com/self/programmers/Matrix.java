package com.self.programmers;

public class Matrix {
	public int[][] solution(int[][] arr1, int[][] arr2){
		int[][] result = new int[arr1.length][arr2[0].length];
		
		for(int x=0; x<arr1.length; x++){
			for(int y=0; y<arr1[x].length; y++){
				for(int k=0;k<arr1[0].length;k++){
					result[x][y]+=arr1[x][k]*arr2[k][y];
                }
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		Matrix m = new Matrix();
	}

}
