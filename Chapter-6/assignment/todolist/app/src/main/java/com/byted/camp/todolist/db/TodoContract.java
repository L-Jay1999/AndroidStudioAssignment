package com.byted.camp.todolist.db;

import android.provider.BaseColumns;

/**
 * Created on 2019/1/22.
 *
 * @author xuyingyi@bytedance.com (Yingyi Xu)
 */
public final class TodoContract {

    //  定义表结构和 SQL 语句常量

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE" + FeedEntry.TABLE_NAME + "(" +
                    FeedEntry._ID + "INTEGER PRIMARY KEY," +
                    FeedEntry.CONTENT + " TEXT," +
                    FeedEntry.DATE + " TEXT," +
                    FeedEntry.STATE + " INT," +
                    FeedEntry.PRIORITY + " INT)";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;

    private TodoContract() {
    }

    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "todolist";

        public static final String CONTENT = "content";

        public static final String DATE = "date";

        public static final String STATE = "state";

        public static final String PRIORITY = "priority";
    }
}
