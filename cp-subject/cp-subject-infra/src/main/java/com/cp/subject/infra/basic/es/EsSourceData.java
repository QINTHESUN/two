package com.cp.subject.infra.basic.es;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/11/2 下午2:05
 **/
@Data
public class EsSourceData implements Serializable {

    private String docId;

    private Map<String,Object> data;


}
