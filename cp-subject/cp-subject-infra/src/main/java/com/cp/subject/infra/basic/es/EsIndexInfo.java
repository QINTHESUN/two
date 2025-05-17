package com.cp.subject.infra.basic.es;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/11/2 下午1:56
 **/
@Data
public class EsIndexInfo implements Serializable {

    /**
     * 集群名称
     */
    private String clusterName;


    /**
     * 索引名称
     */
    private String indexName;


}
