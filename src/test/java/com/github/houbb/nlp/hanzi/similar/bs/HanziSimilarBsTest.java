package com.github.houbb.nlp.hanzi.similar.bs;

import com.github.houbb.nlp.hanzi.similar.constant.HanziSimilarDataConst;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class HanziSimilarBsTest {

    @Test
    public void simpleTest() {
        double rate = HanziSimilarBs.newInstance(
                    HanziSimilarDataConst.BIAHUASHU,
                    HanziSimilarDataConst.BUSHOU,
                    HanziSimilarDataConst.JIEGOU,
                    HanziSimilarDataConst.SIJIAO,
                    HanziSimilarDataConst.USER_DEFINE
                )
                .jiegouRate(10)
                .sijiaoRate(8)
                .bushouRate(6)
                .bihuashuRate(2)
                .similar('末', '未');

        System.out.println(rate);
    }

}
