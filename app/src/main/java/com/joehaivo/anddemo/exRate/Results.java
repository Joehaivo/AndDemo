/**
 * Copyright 2017 bejson.com
 */
package com.joehaivo.anddemo.exRate;

import java.util.List;

/**
 * Auto-generated: 2017-09-06 13:22:35
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Results {


    private List<Rate> rate = null;

    public Results() {
    }


    public Results(List<Rate> rate) {
        this.rate = rate;
    }

    /**
     * @return The rate
     */
    public List<Rate> getRate() {
        return rate;
    }

    /**
     * @param rate The rate
     */
    public void setRate(List<Rate> rate) {
        this.rate = rate;
    }

    public Results withRate(List<Rate> rate) {
        this.rate = rate;
        return this;
    }

//    @Override
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this);
//    }
//
//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder().append(rate).toHashCode();
//    }
//
//    @Override
//    public boolean equals(Object other) {
//        if (other == this) {
//            return true;
//        }
//        if ((other instanceof Results) == false) {
//            return false;
//        }
//        Results rhs = ((Results) other);
//        return new EqualsBuilder().append(rate, rhs.rate).isEquals();
//    }
}