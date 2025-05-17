package com.cp.subject.domain.handler.subject;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.cp.subject.common.enums.SubjectInfoTypeEnum;
import javafx.fxml.Initializable;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目类型工厂
 *
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/23 下午2:02
 **/
@Component
public class SubjectTypeHandlerFactory implements InitializingBean {


    @Resource
    private List<SubjectTypeHandler>  subjectTypeHandlerList;

    private Map<SubjectInfoTypeEnum, SubjectTypeHandler> handlerMap = new HashMap<>();


    public SubjectTypeHandler getHandler(int subjectType) {
        SubjectInfoTypeEnum code = SubjectInfoTypeEnum.getByCode(subjectType);
        if (code == null) {
            throw new IllegalArgumentException("没有找到题目的类型");
        }
        return handlerMap.get(code);
    }



    @Override
    public void afterPropertiesSet() throws Exception {
        for (SubjectTypeHandler subjectTypeHandler : subjectTypeHandlerList) {
            handlerMap.put(subjectTypeHandler.getHandlerType(), subjectTypeHandler);
        }
    }
}
