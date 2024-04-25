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
 * 用户自定义数据
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class UserDefineData implements IHanziData<Double> {

    private Map<String, Double> MAP;

    UserDefineData(String data) {
        List<String> lines = Arrays.asList(data.split("\\r?\\n"));
        MAP = new HashMap<>(lines.size());

        for (String line : lines) {
            String[] strings = line.split(StringUtil.BLANK);
            if (strings.length > 1) {
                if (strings[0].length() == 2) {
                    MAP.put(strings[0], Double.valueOf(strings[1]));
                    MAP.put(new StringBuffer(strings[0]).reverse().toString(), Double.valueOf(strings[1]));
                }
            }
        }
    }

    @Override
    public Map<String, Double> dataMap() {
        return MAP;
    }

}
