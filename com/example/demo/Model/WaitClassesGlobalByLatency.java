package com.example.demo.Model;

import java.math.BigDecimal;

public class WaitClassesGlobalByLatency {
    private String eventClass;

    private BigDecimal total;

    public String getEventClass() {
        return eventClass;
    }

    public void setEventClass(String eventClass) {
        this.eventClass = eventClass == null ? null : eventClass.trim();
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}