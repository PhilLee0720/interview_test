package com.lee.dao;

import com.lee.pojo.IPRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPRecordDao {
    List<IPRecord> listIPRecord();

    Integer saveIPRecord(@Param("uri")String uri,@Param("viewNum")Integer viewNum);

    Integer updateIPRecord(@Param("viewNum")Integer viewNum,@Param("uri")String uri);

    IPRecord getIpRecordByUri(@Param("uri")String uri);

}
