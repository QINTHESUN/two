package com.cp.wx.handler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/30 下午3:27
 **/
@Component
public class WxChatMsgFactory implements InitializingBean {

    @Resource
    private List<WxChatMsgHandler> wxChatMsgHandlerList;

    private Map<WxChatMsgTypeEnum, WxChatMsgHandler> handlerMap = new HashMap<>();


    public WxChatMsgHandler getHandlerByMsgType(String msgType) {
        WxChatMsgTypeEnum type = WxChatMsgTypeEnum.getByMsgType(msgType);
        return handlerMap.get(type);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        for (WxChatMsgHandler wxChatMsgHandler : wxChatMsgHandlerList) {
            handlerMap.put(wxChatMsgHandler.getMsgType(), wxChatMsgHandler);
        }
    }
}
