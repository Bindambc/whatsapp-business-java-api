package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.whatsapp.api.domain.messages.type.ParameterType;

/**
 * The type Date time parameter.
 */
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

    /**
     * Instantiates a new Date time parameter.
     */
    public DateTimeParameter() {
        super(ParameterType.DATE_TIME);
    }

    /**
     * Gets fallback value.
     *
     * @return the fallback value
     */
    public String getFallbackValue() {
        return fallbackValue;
    }

    /**
     * Sets fallback value.
     *
     * @param fallbackValue the fallback value
     * @return the fallback value
     */
    public DateTimeParameter setFallbackValue(String fallbackValue) {
        this.fallbackValue = fallbackValue;
        return this;
    }

    /**
     * Gets calendar.
     *
     * @return the calendar
     */
    public String getCalendar() {
        return calendar;
    }

    /**
     * Sets calendar.
     *
     * @param calendar the calendar
     * @return the calendar
     */
    public DateTimeParameter setCalendar(String calendar) {
        this.calendar = calendar;
        return this;
    }

    /**
     * Gets month.
     *
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Sets month.
     *
     * @param month the month
     * @return the month
     */
    public DateTimeParameter setMonth(int month) {
        this.month = month;
        return this;
    }

    /**
     * Gets hour.
     *
     * @return the hour
     */
    public int getHour() {
        return hour;
    }

    /**
     * Sets hour.
     *
     * @param hour the hour
     * @return the hour
     */
    public DateTimeParameter setHour(int hour) {
        this.hour = hour;
        return this;
    }

    /**
     * Gets year.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets year.
     *
     * @param year the year
     * @return the year
     */
    public DateTimeParameter setYear(int year) {
        this.year = year;
        return this;
    }

    /**
     * Gets day of month.
     *
     * @return the day of month
     */
    public int getDayOfMonth() {
        return dayOfMonth;
    }

    /**
     * Sets day of month.
     *
     * @param dayOfMonth the day of month
     * @return the day of month
     */
    public DateTimeParameter setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
        return this;
    }

    /**
     * Gets day of week.
     *
     * @return the day of week
     */
    public int getDayOfWeek() {
        return dayOfWeek;
    }

    /**
     * Sets day of week.
     *
     * @param dayOfWeek the day of week
     * @return the day of week
     */
    public DateTimeParameter setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        return this;
    }

    /**
     * Gets minute.
     *
     * @return the minute
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Sets minute.
     *
     * @param minute the minute
     * @return the minute
     */
    public DateTimeParameter setMinute(int minute) {
        this.minute = minute;
        return this;
    }
}
