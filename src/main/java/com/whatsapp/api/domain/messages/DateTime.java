package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.CalendarType;

/**
 * The type Date time.
 */
@JsonInclude(Include.NON_NULL)
public class DateTime {

    @JsonProperty("fallback_value")
    private String fallbackValue;
    @JsonProperty("calendar")
    private CalendarType calendar;
    @JsonProperty("month")
    private Integer month;
    @JsonProperty("hour")
    private Integer hour;
    @JsonProperty("year")
    private Integer year;
    @JsonProperty("day_of_month")
    private Integer dayOfMonth;
    @JsonProperty("day_of_week")
    private Integer dayOfWeek;
    @JsonProperty("minute")
    private Integer minute;


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
    public DateTime setFallbackValue(String fallbackValue) {
        this.fallbackValue = fallbackValue;
        return this;
    }

    /**
     * Gets calendar.
     *
     * @return the calendar
     */
    public CalendarType getCalendar() {
        return calendar;
    }

    /**
     * Sets calendar.
     *
     * @param calendar the calendar
     * @return the calendar
     */
    public DateTime setCalendar(CalendarType calendar) {
        this.calendar = calendar;
        return this;
    }

    /**
     * Gets month.
     *
     * @return the month
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * Sets month.
     *
     * @param month the month
     * @return the month
     */
    public DateTime setMonth(Integer month) {
        this.month = month;
        return this;
    }

    /**
     * Gets hour.
     *
     * @return the hour
     */
    public Integer getHour() {
        return hour;
    }

    /**
     * Sets hour.
     *
     * @param hour the hour
     * @return the hour
     */
    public DateTime setHour(Integer hour) {
        this.hour = hour;
        return this;
    }

    /**
     * Gets year.
     *
     * @return the year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Sets year.
     *
     * @param year the year
     * @return the year
     */
    public DateTime setYear(Integer year) {
        this.year = year;
        return this;
    }

    /**
     * Gets day of month.
     *
     * @return the day of month
     */
    public Integer getDayOfMonth() {
        return dayOfMonth;
    }

    /**
     * Sets day of month.
     *
     * @param dayOfMonth the day of month
     * @return the day of month
     */
    public DateTime setDayOfMonth(Integer dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
        return this;
    }

    /**
     * Gets day of week.
     *
     * @return the day of week
     */
    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    /**
     * Sets day of week.
     *
     * @param dayOfWeek the day of week
     * @return the day of week
     */
    public DateTime setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        return this;
    }

    /**
     * Gets minute.
     *
     * @return the minute
     */
    public Integer getMinute() {
        return minute;
    }

    /**
     * Sets minute.
     *
     * @param minute the minute
     * @return the minute
     */
    public DateTime setMinute(Integer minute) {
        this.minute = minute;
        return this;
    }
}
