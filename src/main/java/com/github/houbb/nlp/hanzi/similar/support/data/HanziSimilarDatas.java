package com.github.houbb.nlp.hanzi.similar.support.data;

import com.github.houbb.nlp.hanzi.similar.api.IHanziData;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public final class HanziSimilarDatas {

    private static BihuashuData bihuashuData;

    private static BushouData bushouData;

    private static JiegouData jiegouData;

    private static SijiaoData sijiaoData;

    private static UserDefineData userDefineData;

    private HanziSimilarDatas() {
    }

    /**
     * 笔画数
     *
     * @return 实现
     */
    public static IHanziData<Integer> bihuashu(String data) {
        if (bihuashuData == null) {
            bihuashuData = new BihuashuData(data);
        }
        return bihuashuData;
    }

    /**
     * 部首
     *
     * @return 实现
     */
    public static IHanziData<String> bushou(String data) {
        if (bushouData == null) {
            bushouData = new BushouData(data);
        }
        return bushouData;
    }


    /**
     * 结构
     *
     * @return 实现
     */
    public static IHanziData<String> jiegou(String data) {
        if (jiegouData == null) {
            jiegouData = new JiegouData(data);
        }
        return jiegouData;
    }

    /**
     * 四角
     *
     * @return 实现
     */
    public static IHanziData<String> sijiao(String path) {
        if (sijiaoData == null) {
            sijiaoData = new SijiaoData(path);
        }
        return sijiaoData;
    }

    /**
     * 用户自定义
     *
     * @return 实现
     */
    public static IHanziData<Double> userDefine(String data) {
        if (userDefineData == null) {
            userDefineData = new UserDefineData(data);
        }
        return userDefineData;
    }
}
