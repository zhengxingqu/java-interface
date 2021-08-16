package com.example.demo.Model;

import java.math.BigDecimal;
import java.util.Date;

public class StatementsWithFullTableScans {
    private String db;

    private Long execCount;

    private Long noIndexUsedCount;

    private Long noGoodIndexUsedCount;

    private BigDecimal noIndexUsedPct;

    private Long rowsSent;

    private Long rowsExamined;

    private BigDecimal rowsSentAvg;

    private BigDecimal rowsExaminedAvg;

    private Date firstSeen;

    private Date lastSeen;

    private String digest;

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db == null ? null : db.trim();
    }

    public Long getExecCount() {
        return execCount;
    }

    public void setExecCount(Long execCount) {
        this.execCount = execCount;
    }

    public Long getNoIndexUsedCount() {
        return noIndexUsedCount;
    }

    public void setNoIndexUsedCount(Long noIndexUsedCount) {
        this.noIndexUsedCount = noIndexUsedCount;
    }

    public Long getNoGoodIndexUsedCount() {
        return noGoodIndexUsedCount;
    }

    public void setNoGoodIndexUsedCount(Long noGoodIndexUsedCount) {
        this.noGoodIndexUsedCount = noGoodIndexUsedCount;
    }

    public BigDecimal getNoIndexUsedPct() {
        return noIndexUsedPct;
    }

    public void setNoIndexUsedPct(BigDecimal noIndexUsedPct) {
        this.noIndexUsedPct = noIndexUsedPct;
    }

    public Long getRowsSent() {
        return rowsSent;
    }

    public void setRowsSent(Long rowsSent) {
        this.rowsSent = rowsSent;
    }

    public Long getRowsExamined() {
        return rowsExamined;
    }

    public void setRowsExamined(Long rowsExamined) {
        this.rowsExamined = rowsExamined;
    }

    public BigDecimal getRowsSentAvg() {
        return rowsSentAvg;
    }

    public void setRowsSentAvg(BigDecimal rowsSentAvg) {
        this.rowsSentAvg = rowsSentAvg;
    }

    public BigDecimal getRowsExaminedAvg() {
        return rowsExaminedAvg;
    }

    public void setRowsExaminedAvg(BigDecimal rowsExaminedAvg) {
        this.rowsExaminedAvg = rowsExaminedAvg;
    }

    public Date getFirstSeen() {
        return firstSeen;
    }

    public void setFirstSeen(Date firstSeen) {
        this.firstSeen = firstSeen;
    }

    public Date getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest == null ? null : digest.trim();
    }
}