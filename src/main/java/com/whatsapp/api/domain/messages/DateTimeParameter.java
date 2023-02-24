package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.whatsapp.api.domain.messages.type.ParameterType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DateTimeParameter extends Parameter {
    private String fallbackValue;
    private String calendar;
    private int month;
    private int hour;
    private int year;
    private int dayOfMonth;
    private int dayOfWeek;
    private int minute;

    public DateTimeParameter() {
        super(ParameterType.DATE_TIME);
    }

    public String getFallbackValue() {
        return fallbackValue;
    }

    public DateTimeParameter setFallbackValue(String fallbackValue) {
        this.fallbackValue = fallbackValue;
        return this;
    }

    public String getCalendar() {
        return calendar;
    }

    public DateTimeParameter setCalendar(String calendar) {
        this.calendar = calendar;
        return this;
    }

    public int getMonth() {
        return month;
    }

    public DateTimeParameter setMonth(int month) {
        this.month = month;
        return this;
    }

    public int getHour() {
        return hour;
    }

    public DateTimeParameter setHour(int hour) {
        this.hour = hour;
        return this;
    }

    public int getYear() {
        return year;
    }

    public DateTimeParameter setYear(int year) {
        this.year = year;
        return this;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public DateTimeParameter setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
        return this;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public DateTimeParameter setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        return this;
    }

    public int getMinute() {
        return minute;
    }

    public DateTimeParameter setMinute(int minute) {
        this.minute = minute;
        return this;
    }
}
