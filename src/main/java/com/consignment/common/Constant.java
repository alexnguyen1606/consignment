package com.consignment.common;

import java.time.ZoneId;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 13,2020
 */
public class Constant {
    public static final String CHECK_IN = "CHECK_IN";
    public static final String CHECK_OUT = "CHECK_OUT";
    public static  final String TIME_ZONE="Asia/Ho_Chi_Minh";
    public static final ZoneId zoneId =  ZoneId.of(Constant.TIME_ZONE);
    public static final Integer ENABLE= 1;
}
