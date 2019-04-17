package com.zhu.springboot.utils.sort;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhugu
 * @version 1.0
 * @Date 2019/4/17 14:56
 * @Description 排序工厂
 */
@Component
public class SortFactory implements ApplicationContextAware {
    private static Map<SortType, Sort> sortBeanMap = new ConcurrentHashMap<>(16);
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Sort> map = applicationContext.getBeansOfType(Sort.class);
        map.forEach((key, value) -> sortBeanMap.put(value.getSortType(), value));
    }

    public int[] sorting(SortType sortType, int[] sourceArray) {
        Sort sort = sortBeanMap.get(sortType);
        return sort.sorting(sourceArray);
    }
}
