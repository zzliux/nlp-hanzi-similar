package cn.zzliux;

import com.github.houbb.heaven.util.io.StreamUtil;
import com.github.houbb.nlp.hanzi.similar.bs.HanziSimilarBs;
import com.github.houbb.nlp.hanzi.similar.constant.HanziSimilarDataConst;

public class HanZiSimilarBridge {

    private HanziSimilarBs helper;

    public static void main(String[] args) {
        HanZiSimilarBridge b = new HanZiSimilarBridge();
        b.init(
                StreamUtil.getFileContent(HanziSimilarDataConst.BIAHUASHU),
                StreamUtil.getFileContent(HanziSimilarDataConst.BUSHOU),
                StreamUtil.getFileContent(HanziSimilarDataConst.JIEGOU),
                StreamUtil.getFileContent(HanziSimilarDataConst.SIJIAO),
                StreamUtil.getFileContent(HanziSimilarDataConst.USER_DEFINE)
        );
        System.out.println(b.similarity("防御", "告死灯灯"));
        System.out.println(b.similarity("人鬼情未了", "入免晴末子"));
        System.out.println(b.similarity("未", "末"));
    }

    public HanZiSimilarBridge() {
    }

    public void init(String bihuashuData, String bushouPath, String jiegouData, String sijiaoData, String userDefineData) {
        helper = HanziSimilarBs.newInstance(
                        bihuashuData,
                        bushouPath,
                        jiegouData,
                        sijiaoData,
                        userDefineData
                )
                .bihuashuRate(2)
                .bushouRate(2)
                .jiegouRate(10)
                .sijiaoRate(8);
    }


    /**
     * 字符串相似度比较，基于编辑距离计算，不相同的字符使用字形相似度计算
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 返回两字符串的相似度
     */
    public double similarity(String str1, String str2) {
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
