package com.lee.service.impl;

import com.lee.config.MyBatisConfig;
import com.lee.dao.IPRecordDao;
import com.lee.pojo.IPRecord;
import com.lee.service.IPRecordService;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class IPRecordServiceImpl implements IPRecordService {


    @Override
    public List<IPRecord> listIPRecord() throws IOException {
        SqlSession sqlSession = MyBatisConfig.getSqlSession();
        IPRecordDao mapper = sqlSession.getMapper(IPRecordDao.class);
        List<IPRecord> ipRecords = mapper.listIPRecord();
        sqlSession.commit();
        sqlSession.close();
        return ipRecords;
    }

    @Override
    public Integer saveIPRecord(String uri, Integer viewNum) throws IOException {
        SqlSession sqlSession = MyBatisConfig.getSqlSession();
        IPRecordDao mapper = sqlSession.getMapper(IPRecordDao.class);
        Integer i = mapper.saveIPRecord(uri, viewNum);
        sqlSession.commit();
        sqlSession.close();
        return i;

    }

    @Override
    public Integer updateIPRecord(Integer viewNum, String uri) throws IOException {
        SqlSession sqlSession = MyBatisConfig.getSqlSession();
        IPRecordDao mapper = sqlSession.getMapper(IPRecordDao.class);
        Integer i = mapper.updateIPRecord(viewNum, uri);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public IPRecord getIpRecordByUri(String uri) throws IOException {
        SqlSession sqlSession = MyBatisConfig.getSqlSession();
        IPRecordDao mapper = sqlSession.getMapper(IPRecordDao.class);
        IPRecord ipRecordByUri = mapper.getIpRecordByUri(uri);
        sqlSession.commit();
        sqlSession.close();
        return ipRecordByUri;
    }



}
