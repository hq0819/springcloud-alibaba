package com.hq.sentinelHandlers;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class SentinelFlowHandler {

public static String flowhander(BlockException e){
    return "当前人数过多！";
}


    public static String fallback(){
        return "当前人数过多！";
    }


}
