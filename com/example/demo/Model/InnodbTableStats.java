package com.example.demo.Model;

import java.util.Date;

public class InnodbTableStats {
    private String databaseName;

    private String tableName;

    private Date lastUpdate;

    private Long nRows;

    private Long clusteredIndexSize;

    private Long sumOfOtherIndexSizes;

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName == null ? null : databaseName.trim();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getnRows() {
        return nRows;
    }

    public void setnRows(Long nRows) {
        this.nRows = nRows;
    }

    public Long getClusteredIndexSize() {
        return clusteredIndexSize;
    }

    public void setClusteredIndexSize(Long clusteredIndexSize) {
        this.clusteredIndexSize = clusteredIndexSize;
    }

    public Long getSumOfOtherIndexSizes() {
        return sumOfOtherIndexSizes;
    }

    public void setSumOfOtherIndexSizes(Long sumOfOtherIndexSizes) {
        this.sumOfOtherIndexSizes = sumOfOtherIndexSizes;
    }
}