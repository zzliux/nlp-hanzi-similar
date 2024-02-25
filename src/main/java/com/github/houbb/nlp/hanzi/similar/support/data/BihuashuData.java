package com.github.houbb.nlp.hanzi.similar.support.data;

import com.github.houbb.heaven.util.io.StreamUtil;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.nlp.hanzi.similar.api.IHanziData;
import com.github.houbb.nlp.hanzi.similar.constant.HanziSimilarDataConst;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 笔画数数据
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class BihuashuData implements IHanziData<Integer> {

    private Map<String, Integer> MAP;

    BihuashuData(String data) {
        List<String> lines = Arrays.asList(data.split("\\r?\\n"));
        MAP = new HashMap<>(lines.size());

        for (String line : lines) {
            String[] strings = line.split(StringUtil.BLANK);
            if (strings.length > 1) {
                MAP.put(strings[0], Integer.valueOf(strings[1]));
            }
        }
    }

    @Override
    public Map<String, Integer> dataMap() {
        return MAP;
    }

}
