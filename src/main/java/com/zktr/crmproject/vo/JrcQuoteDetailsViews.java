package com.zktr.crmproject.vo;

import com.zktr.crmproject.pojos.Quotedetails;

import java.util.List;

public class JrcQuoteDetailsViews {

    private List<Quotedetails> quotedetail;
    private List<Integer> dels;

    public List<Quotedetails> getQuotedetail() {
        return quotedetail;
    }

    public void setQuotedetail(List<Quotedetails> quotedetail) {
        this.quotedetail = quotedetail;
    }

    public List<Integer> getDels() {
        return dels;
    }

    public void setDels(List<Integer> dels) {
        this.dels = dels;
    }

    public JrcQuoteDetailsViews(List<Quotedetails> quotedetail, List<Integer> dels) {
        this.quotedetail = quotedetail;
        this.dels = dels;
    }

    public JrcQuoteDetailsViews() {
    }
}
