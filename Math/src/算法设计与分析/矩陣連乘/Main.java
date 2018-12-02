package 算法设计与分析.矩陣連乘;

public class Main {
	/**
     * 此方法用来求解矩阵连乘的最小数乘次数
     * 
     * @param p
     *            传入的要连乘的矩阵的维数信息的数组
     * @return String型的矩阵的最小数层次数信息
     */
    public static String matrixChain(int p[]) {

        int n = p.length - 1;  //为p的实际最大下标
        int m[][] = new int[n + 1][n + 1];
        int s[][] = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }
        for (int r = 2; r <= n; r++) // r为当前计算的链长（子问题规模）
        {
            for (int i = 1; i <= n - r + 1; i++)// n-r+1为最后一个r链的前边界
            {
                int j = i + r - 1;// 计算前边界为r，链长为r的链的后边界

                m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];// 将链ij划分为A(i) *( A[i+1:j] )
                s[i][j] = i;

                for (int k = i + 1; k < j; k++) {
                    // 将链ij划分为( A[i:k] )* (A[k+1:j])
                    int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (t < m[i][j]) {
                        m[i][j] = t;
                        s[i][j] = k;
                    }
                }
            }
        }

        String answer = "";
        answer = answer + "此矩阵连乘所需的最小次数为：" + m[1][n] + "\n";
        matrixTraceBack(1, n, s);

        return answer;

    }

    private static void matrixTraceBack(int i, int j, int s[][]) {

        if (i == j) {
            return;
        }
        matrixTraceBack(i, s[i][j], s);
        matrixTraceBack(s[i][j] + 1, j, s);

        int x = s[i][j] + 1;
        System.out.print("Multipy A" + i + "," + s[i][j]);
        System.out.println(" and A" + x + "," + j);

    }
}
