package com.lee.util;

import com.lee.pojo.IPRecord;
import com.lee.service.IPRecordService;
import com.lee.service.impl.IPRecordServiceImpl;

import java.io.IOException;

public class IPRecordUtil {
    private static IPRecordService ipRecordService =  new IPRecordServiceImpl();
    public static void modifyInterRecord(String uri) throws IOException {
        IPRecord ipRecordByUri = ipRecordService.getIpRecordByUri(uri);
        if(ipRecordByUri == null){
            ipRecordService.saveIPRecord(uri,1);
        }else{
            ipRecordService.updateIPRecord(ipRecordByUri.getViewNum()+1,uri);
        }
    }
}
