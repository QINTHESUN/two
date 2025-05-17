package com.cp.subject.domain.util;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * 缓存工具类
 *
 * @Author: q
 * @Description: 提供简单的本地缓存机制，支持从缓存获取数据或在缓存未命中时获取数据并存入缓存
 * @DateTime: 1/10/2024 下午 7:32
 **/
@Component
public class CacheUtil<V> {

    // 创建一个字符串键和字符串值的本地缓存
    private Cache<String, String> localCache =
            CacheBuilder.newBuilder()
                    .maximumSize(5000) // 设置最大缓存条目数为 5000
                    .expireAfterWrite(10, TimeUnit.SECONDS) // 设置写入后 10 秒过期
                    .build();

    /**
     * 根据缓存键从缓存中获取结果，如果未命中则调用提供的函数获取数据并缓存
     *
     * @param cacheKey 缓存键
     * @param clazz    目标类的类型，用于解析 JSON
     * @param function 在缓存未命中时调用的函数
     * @return 返回 List<V> 类型的结果
     */
    public List<V> getResult(String cacheKey, Class<V> clazz,
                             Function<String, List<V>> function) {
        List<V> resultList = new ArrayList<>(); // 初始化结果列表
        String content = localCache.getIfPresent(cacheKey); // 从缓存中获取内容

        // 检查缓存是否命中
        if (StringUtils.isNotBlank(content)) {
            // 如果缓存命中，解析 JSON 字符串为 List<V>
            resultList = JSON.parseArray(content, clazz);
        } else {
            // 如果未命中，调用函数获取数据
            resultList = function.apply(cacheKey);
            // 如果获取到的数据不为空，存入缓存
            if (!CollectionUtils.isEmpty(resultList)) {
                localCache.put(cacheKey, JSON.toJSONString(resultList)); // 将结果转换为 JSON 字符串并缓存
            }
        }
        return resultList; // 返回结果列表
    }
}
