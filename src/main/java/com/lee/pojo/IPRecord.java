package com.lee.pojo;

import java.util.Objects;

public class IPRecord {
    //主键自增ID
    private Integer id;
    //访问接口
    private String uri;

    //访问数
    private Integer viewNum;

    public IPRecord() {
    }

    public IPRecord(Integer id, String uri, Integer viewNum) {
        this.id = id;
        this.uri = uri;
        this.viewNum = viewNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IPRecord)) return false;
        IPRecord ipRecord = (IPRecord) o;
        return Objects.equals(id, ipRecord.id) && Objects.equals(uri, ipRecord.uri) && Objects.equals(viewNum, ipRecord.viewNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uri, viewNum);
    }

    @Override
    public String toString() {
        return "IPRecord{" +
                "id=" + id +
                ", uri='" + uri + '\'' +
                ", viewNum=" + viewNum +
                '}';
    }
}
