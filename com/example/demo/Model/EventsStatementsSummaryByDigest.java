package com.example.demo.Model;

import java.util.Date;

public class EventsStatementsSummaryByDigest {
    private String schemaName;

    private String digest;

    private Long countStar;

    private Long sumTimerWait;

    private Long minTimerWait;

    private Long avgTimerWait;

    private Long maxTimerWait;

    private Long sumLockTime;

    private Long sumErrors;

    private Long sumWarnings;

    private Long sumRowsAffected;

    private Long sumRowsSent;

    private Long sumRowsExamined;

    private Long sumCreatedTmpDiskTables;

    private Long sumCreatedTmpTables;

    private Long sumSelectFullJoin;

    private Long sumSelectFullRangeJoin;

    private Long sumSelectRange;

    private Long sumSelectRangeCheck;

    private Long sumSelectScan;

    private Long sumSortMergePasses;

    private Long sumSortRange;

    private Long sumSortRows;

    private Long sumSortScan;

    private Long sumNoIndexUsed;

    private Long sumNoGoodIndexUsed;

    private Date firstSeen;

    private Date lastSeen;

    private String digestText;

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName == null ? null : schemaName.trim();
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest == null ? null : digest.trim();
    }

    public Long getCountStar() {
        return countStar;
    }

    public void setCountStar(Long countStar) {
        this.countStar = countStar;
    }

    public Long getSumTimerWait() {
        return sumTimerWait;
    }

    public void setSumTimerWait(Long sumTimerWait) {
        this.sumTimerWait = sumTimerWait;
    }

    public Long getMinTimerWait() {
        return minTimerWait;
    }

    public void setMinTimerWait(Long minTimerWait) {
        this.minTimerWait = minTimerWait;
    }

    public Long getAvgTimerWait() {
        return avgTimerWait;
    }

    public void setAvgTimerWait(Long avgTimerWait) {
        this.avgTimerWait = avgTimerWait;
    }

    public Long getMaxTimerWait() {
        return maxTimerWait;
    }

    public void setMaxTimerWait(Long maxTimerWait) {
        this.maxTimerWait = maxTimerWait;
    }

    public Long getSumLockTime() {
        return sumLockTime;
    }

    public void setSumLockTime(Long sumLockTime) {
        this.sumLockTime = sumLockTime;
    }

    public Long getSumErrors() {
        return sumErrors;
    }

    public void setSumErrors(Long sumErrors) {
        this.sumErrors = sumErrors;
    }

    public Long getSumWarnings() {
        return sumWarnings;
    }

    public void setSumWarnings(Long sumWarnings) {
        this.sumWarnings = sumWarnings;
    }

    public Long getSumRowsAffected() {
        return sumRowsAffected;
    }

    public void setSumRowsAffected(Long sumRowsAffected) {
        this.sumRowsAffected = sumRowsAffected;
    }

    public Long getSumRowsSent() {
        return sumRowsSent;
    }

    public void setSumRowsSent(Long sumRowsSent) {
        this.sumRowsSent = sumRowsSent;
    }

    public Long getSumRowsExamined() {
        return sumRowsExamined;
    }

    public void setSumRowsExamined(Long sumRowsExamined) {
        this.sumRowsExamined = sumRowsExamined;
    }

    public Long getSumCreatedTmpDiskTables() {
        return sumCreatedTmpDiskTables;
    }

    public void setSumCreatedTmpDiskTables(Long sumCreatedTmpDiskTables) {
        this.sumCreatedTmpDiskTables = sumCreatedTmpDiskTables;
    }

    public Long getSumCreatedTmpTables() {
        return sumCreatedTmpTables;
    }

    public void setSumCreatedTmpTables(Long sumCreatedTmpTables) {
        this.sumCreatedTmpTables = sumCreatedTmpTables;
    }

    public Long getSumSelectFullJoin() {
        return sumSelectFullJoin;
    }

    public void setSumSelectFullJoin(Long sumSelectFullJoin) {
        this.sumSelectFullJoin = sumSelectFullJoin;
    }

    public Long getSumSelectFullRangeJoin() {
        return sumSelectFullRangeJoin;
    }

    public void setSumSelectFullRangeJoin(Long sumSelectFullRangeJoin) {
        this.sumSelectFullRangeJoin = sumSelectFullRangeJoin;
    }

    public Long getSumSelectRange() {
        return sumSelectRange;
    }

    public void setSumSelectRange(Long sumSelectRange) {
        this.sumSelectRange = sumSelectRange;
    }

    public Long getSumSelectRangeCheck() {
        return sumSelectRangeCheck;
    }

    public void setSumSelectRangeCheck(Long sumSelectRangeCheck) {
        this.sumSelectRangeCheck = sumSelectRangeCheck;
    }

    public Long getSumSelectScan() {
        return sumSelectScan;
    }

    public void setSumSelectScan(Long sumSelectScan) {
        this.sumSelectScan = sumSelectScan;
    }

    public Long getSumSortMergePasses() {
        return sumSortMergePasses;
    }

    public void setSumSortMergePasses(Long sumSortMergePasses) {
        this.sumSortMergePasses = sumSortMergePasses;
    }

    public Long getSumSortRange() {
        return sumSortRange;
    }

    public void setSumSortRange(Long sumSortRange) {
        this.sumSortRange = sumSortRange;
    }

    public Long getSumSortRows() {
        return sumSortRows;
    }

    public void setSumSortRows(Long sumSortRows) {
        this.sumSortRows = sumSortRows;
    }

    public Long getSumSortScan() {
        return sumSortScan;
    }

    public void setSumSortScan(Long sumSortScan) {
        this.sumSortScan = sumSortScan;
    }

    public Long getSumNoIndexUsed() {
        return sumNoIndexUsed;
    }

    public void setSumNoIndexUsed(Long sumNoIndexUsed) {
        this.sumNoIndexUsed = sumNoIndexUsed;
    }

    public Long getSumNoGoodIndexUsed() {
        return sumNoGoodIndexUsed;
    }

    public void setSumNoGoodIndexUsed(Long sumNoGoodIndexUsed) {
        this.sumNoGoodIndexUsed = sumNoGoodIndexUsed;
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

    public String getDigestText() {
        return digestText;
    }

    public void setDigestText(String digestText) {
        this.digestText = digestText == null ? null : digestText.trim();
    }
}