package cn.zzliux;

import com.github.houbb.nlp.hanzi.similar.bs.HanziSimilarBs;
import com.github.houbb.nlp.hanzi.similar.util.HanziSimilarHelper;

public class HanZiSimilarBridge {

    private static final HanziSimilarBs helper = HanziSimilarBs.newInstance()
            .jiegouRate(10)
            .sijiaoRate(8)
            .bushouRate(2)
            .bihuashuRate(2)
            .chaiziRate(2);

//    public static void main(String[] args) {
//        System.out.println(similarity("人鬼情未了", "入免情末了"));
//    }


    /**
     * 字符串相似度比较，基于编辑距离计算，不相同的字符使用字形相似度计算
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 返回两字符串的相似度
     */
    public static double similarity(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // 创建一个二维数组来存储编辑距离
        double[][] dp = new double[m + 1][n + 1];

        // 初始化第一行和第一列
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1.0 * i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1.0 * j;
        }

        // 计算编辑距离
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                double similar = helper.similar(str1.charAt(i - 1), str2.charAt(j - 1));
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + (1 - similar);
            }
        }

        // 返回编辑距离
        return 1 - dp[m][n] / Math.max(m, n);
    }
}
