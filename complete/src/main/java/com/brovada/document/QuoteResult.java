package com.brovada.document;

import com.google.common.collect.Lists;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class QuoteResult {

    private static int SUCCESS = 0;
    private static int TIMEOUT = 1;
    private static int INVALID_DATA = 2;

    private double totalPremium;
    private Date created;
    private List<String> notes = Lists.newArrayList();
    private long status;
    private Date expiry;
    private String quoteMethod;
    private String referrer;


    public static QuoteResult success(double totalPremium) {
        return new QuoteResult(SUCCESS).withTotalPremium(totalPremium);
    }

    public static QuoteResult timeout() {
        return new QuoteResult(TIMEOUT);
    }

    public static QuoteResult invalid() {
        return new QuoteResult(INVALID_DATA);
    }

    private QuoteResult(long status) {
        this.created = new Date();
    }

    public QuoteResult withTotalPremium(double total){
        this.totalPremium = total;
        return this;
    }

    public QuoteResult expiring(Date expiry) {
        this.expiry = expiry;
        return this;
    }

    // TODO : add other getter/setters...
}
