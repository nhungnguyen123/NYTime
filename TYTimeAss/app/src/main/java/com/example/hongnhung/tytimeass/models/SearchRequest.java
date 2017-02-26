package com.example.hongnhung.tytimeass.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hongnhung on 26/02/2017.
 */

public class SearchRequest implements Parcelable {
    private int page = 1;
    private String query;
    private String beginDate;
    private String order = "Newest";
    private boolean hasArts;
    private boolean hasFashionAndstyle;
    private boolean hasSorts;

    public SearchRequest() {

    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public boolean isHasArts() {
        return hasArts;
    }

    public void setHasArts(boolean hasArts) {
        this.hasArts = hasArts;
    }

    public boolean isHasFashionAndstyle() {
        return hasFashionAndstyle;
    }

    public void setHasFashionAndstyle(boolean hasFashionAndstyle) {
        this.hasFashionAndstyle = hasFashionAndstyle;
    }

    public boolean isHasSorts() {
        return hasSorts;
    }

    public void setHasSorts(boolean hasSorts) {
        this.hasSorts = hasSorts;
    }

    public void nextPage() {
        page = page + 1;
    }

    public void  resetpage()
    {
        page=0;
    }
    protected SearchRequest(Parcel in) {
        page = in.readInt();
        query = in.readString();
        beginDate = in.readString();
        order = in.readString();
        hasArts = in.readByte() != 0;
        hasFashionAndstyle = in.readByte() != 0;
        hasSorts = in.readByte() != 0;
    }

    public static final Creator<SearchRequest> CREATOR = new Creator<SearchRequest>() {
        @Override
        public SearchRequest createFromParcel(Parcel in) {
            return new SearchRequest(in);
        }

        @Override
        public SearchRequest[] newArray(int size) {
            return new SearchRequest[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(page);
        dest.writeString(query);
        dest.writeString(beginDate);
        dest.writeString(order);
        dest.writeByte((byte) (hasArts ? 1 : 0));
        dest.writeByte((byte) (hasFashionAndstyle ? 1 : 0));
        dest.writeByte((byte) (hasSorts ? 1 : 0));
    }


    public Map<String, String> toQueryMap() {
        Map<String, String> options = new HashMap<>();
        if (query != null) options.put("q", query);
        if (beginDate != null) options.put("begin_date", beginDate);
        if (order != null) options.put("sort", order.toLowerCase());
        if (getNewDesk() != null) options.put("fq", "news_desk:(" + getNewDesk() + ")");
        options.put("page", String.valueOf(page));
        return options;

    }

    public String getNewDesk() {
        if (!hasArts && !hasFashionAndstyle && !hasSorts) return null;
        String value = "";
        if (hasArts) value += "\"Arts\" ";
        if (hasSorts) value += "\"Sports\" ";
        if (hasFashionAndstyle) value += "\"Fashion & Style\" ";
        return value.trim();


    }
}
