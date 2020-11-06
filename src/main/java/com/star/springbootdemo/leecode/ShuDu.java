package com.star.springbootdemo.leecode;

/**
 * @Author: StarC
 * @Date: 2020/4/23 15:30
 * @Description:
 */
public class ShuDu {

    private int[][] matrix;

    public ShuDu(int[][] matrix) {
        this.matrix = matrix;
    }

    public static void main(String[] args) {
        // �ų���������������
        int[][] sudoku1 = {
                {0, 8, 0, 0, 0, 0, 6, 0, 0},
                {0, 0, 0, 4, 0, 0, 0, 0, 9},
                {0, 7, 0, 0, 0, 0, 8, 0, 5},
                {4, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 3, 0, 0, 6, 0, 0, 9, 0},
                {0, 0, 0, 7, 2, 0, 1, 0, 0},
                {0, 9, 3, 2, 0, 0, 0, 6, 4},
                {8, 1, 0, 3, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 5, 0, 0, 0}};

        int[][] sudoku2 = {
                {0, 0, 0,  0, 0, 0,  0, 0, 0},
                {0, 0, 0,  0, 0, 0,  0, 0, 0},
                {0, 0, 0,  0, 0, 0,  0, 0, 0},

                {0, 0, 0,  0, 0, 0,  0, 0, 0},
                {0, 0, 0,  0, 0, 0,  0, 0, 0},
                {0, 0, 0,  0, 0, 0,  0, 0, 0},

                {0, 0, 0,  0, 0, 0,  0, 0, 0},
                {0, 0, 0,  0, 0, 0,  0, 0, 0},
                {0, 0, 0,  0, 0, 0,  0, 0, 0}
        };
        int[][] sudoku = {
                {0, 5, 0,  0, 0, 0,  0, 2, 0},
                {4, 0, 0,  2, 0, 6,  0, 0, 7},
                {0, 0, 8,  0, 3, 0,  1, 0, 0},

                {0, 1, 0,  0, 0, 0,  0, 6, 0},
                {0, 0, 9,  0, 0, 0,  5, 0, 0},
                {0, 7, 0,  0, 0, 0,  0, 9, 0},

                {0, 0, 5,  0, 8, 0,  3, 0, 0},
                {7, 0, 0,  9, 0, 1,  0, 0, 4},
                {0, 2, 0,  0, 0, 0,  0, 7, 0}
        };
        ShuDu s = new ShuDu(sudoku);
        s.backTrace(0, 0);
    }

    /**
     * �����㷨
     *
     * @param i �к�
     * @param j �к�
     */
    private void backTrace(int i, int j) {
        if (i == 8 && j == 9) {
            //�Ѿ��ɹ��ˣ���ӡ���鼴��
            System.out.println("��ȡ��ȷ��");
            printArray();
            return;
        }

        //�Ѿ�������ĩβ�ˣ���û����β���ͻ���
        if (j == 9) {
            i++;
            j = 0;
        }

        //���i��j���ǿո���ô�Ž�����ո���ֵ���߼�
        if (matrix[i][j] == 0) {
            for (int k = 1; k <= 9; k++) {
                //�жϸ�i��j�з�1-9�е�����һ�����Ƿ����������
                if (check(i, j, k)) {
                    //����ֵ�����ÿո�Ȼ�������һ���ո�
                    matrix[i][j] = k;
                    backTrace(i, j + 1);//j==9-->��������i++;
                    //��ʼ���ÿո�
                    matrix[i][j] = 0;
                }
            }
        } else {
            //�����λ���Ѿ���ֵ�ˣ��ͽ�����һ���ո���м���
            backTrace(i, j + 1);
        }
    }

    /**
     * �жϸ�ĳ��ĳ�и�ֵ�Ƿ���Ϲ���
     *
     * @param row    ����ֵ���к�
     * @param line   ����ֵ���к�
     * @param number ����ֵ
     * @return
     */
    private boolean check(int row, int line, int number) {
        //�жϸ��и����Ƿ����ظ�����
        for (int i = 0; i < 9; i++) {
            if (matrix[row][i] == number || matrix[i][line] == number) {
                return false;
            }
        }
        //�ж�С�Ź����Ƿ����ظ�
        int tempRow = row / 3;
        int tempLine = line / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[tempRow * 3 + i][tempLine * 3 + j] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * ��ӡ����
     */
    public void printArray() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
