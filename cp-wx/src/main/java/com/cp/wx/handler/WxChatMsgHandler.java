package com.cp.wx.handler;

import java.util.Map;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/30 下午2:49
 **/
public interface WxChatMsgHandler {

    WxChatMsgTypeEnum getMsgType();

    String dealMsg(Map<String,String> messageMap);



}
