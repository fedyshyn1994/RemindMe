package com.qoobico.remindme.dto;

import java.util.Date;

public class TicketDTO {

    private long id;
    private String title;
    private Date remindDate;

    public TicketDTO(String title) {
        this.title = title;
    }

    public TicketDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getRemindDate() {
        return remindDate;
    }

    public void setRemindDate(Date remindDate) {
        this.remindDate = remindDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
