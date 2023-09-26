package com.lee.service;

import com.lee.pojo.IPRecord;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;

public interface IPRecordService {



    List<IPRecord> listIPRecord() throws IOException;

    Integer saveIPRecord(@Param("uri")String uri, @Param("viewNum")Integer viewNum) throws IOException;

    Integer updateIPRecord(@Param("viewNum")Integer viewNum,@Param("uri")String uri) throws IOException;

    IPRecord getIpRecordByUri(@Param("uri")String uri) throws IOException;
}
