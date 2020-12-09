package com.zqq.datastructure;

import java.io.IOException;

public class SparesArrTest {
    public static void main(String[] args) throws IOException {
        //创建原始数组
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[2][4] = 2;
        System.out.println("********原始的二维数组********");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.print("\t" + data);
            }
            System.out.println();
        }
        //二维转稀疏数组
        //1.遍历二维数组的到有效数据
        int count = 0;//记录第几个有效值
        for (int[] row : chessArr1) {
            for (int data : row) {
                if (data != 0)
                    count++;
            }
        }
        System.out.println("有效数据个数为：" + count);
        //2.创建对应的稀疏数组
        int sparseArr[][] = new int[count + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = count;
        //遍历二维数组将有效数据存储到稀疏数组中
        int row = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    row++;
                    sparseArr[row][0] = i;
                    sparseArr[row][1] = j;
                    sparseArr[row][2] = chessArr1[i][j];
                }
            }
        }


        System.out.println("*****得到的稀疏数组为******** ");
        for (int [] sparseArrRow:sparseArr){
              for (int data1:sparseArrRow){
                  System.out.print("\t"+data1);
              }
            System.out.println();
        }
        //将稀疏数组转换为二维数组
        int chessArr2[][]=new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i <sparseArr.length ; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];

        }
        //回复后的二维数组
        System.out.println("*****回复后的二维数组为******** ");

        for (int[] chessArr2Row : chessArr2) {
            for (int data : chessArr2Row) {
                System.out.print("\t"+data);
            }
            System.out.println();
        }

    }
}
