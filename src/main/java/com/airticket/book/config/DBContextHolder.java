package com.airticket.book.config;

public class DBContextHolder {
    private static final ThreadLocal<String> contexHolder = new ThreadLocal<String>();


    /**
     * set datasource
     * @param dbType DBTypeEnum
     */
    public static void setDBType(DBTypeEnum dbType) {
        contexHolder.set(dbType.getValue());
    }

    /**
     * get datasource
     * @return String
     */
    public static String getDBType() {
        return contexHolder.get();
    }

    /**
     * clear all datasource
     */
    public static void clearDBType() {
        contexHolder.remove();
    }
}
