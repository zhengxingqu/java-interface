package com.example.demo.Model;

import java.util.Date;

public class InnodbIndexStats {
    private String databaseName;

    private String tableName;

    private String indexName;

    private Date lastUpdate;

    private String statName;

    private Long statValue;

    private Long sampleSize;

    private String statDescription;

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

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName == null ? null : indexName.trim();
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getStatName() {
        return statName;
    }

    public void setStatName(String statName) {
        this.statName = statName == null ? null : statName.trim();
    }

    public Long getStatValue() {
        return statValue;
    }

    public void setStatValue(Long statValue) {
        this.statValue = statValue;
    }

    public Long getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(Long sampleSize) {
        this.sampleSize = sampleSize;
    }

    public String getStatDescription() {
        return statDescription;
    }

    public void setStatDescription(String statDescription) {
        this.statDescription = statDescription == null ? null : statDescription.trim();
    }
}