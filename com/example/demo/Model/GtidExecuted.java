package com.example.demo.Model;

public class GtidExecuted {
    private String sourceUuid;

    private Long intervalStart;

    private Long intervalEnd;

    public String getSourceUuid() {
        return sourceUuid;
    }

    public void setSourceUuid(String sourceUuid) {
        this.sourceUuid = sourceUuid == null ? null : sourceUuid.trim();
    }

    public Long getIntervalStart() {
        return intervalStart;
    }

    public void setIntervalStart(Long intervalStart) {
        this.intervalStart = intervalStart;
    }

    public Long getIntervalEnd() {
        return intervalEnd;
    }

    public void setIntervalEnd(Long intervalEnd) {
        this.intervalEnd = intervalEnd;
    }
}