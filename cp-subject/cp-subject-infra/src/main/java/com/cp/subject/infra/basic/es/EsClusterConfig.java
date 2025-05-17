package com.cp.subject.infra.basic.es;

import lombok.Data;

/**
 * es集群类
 *
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/11/2 下午1:51
 **/
@Data
public class EsClusterConfig {

    /**
     * 集群名称
     */
    private String name;

    /**
     * 集群节点
     */
    private String nodes;



}
