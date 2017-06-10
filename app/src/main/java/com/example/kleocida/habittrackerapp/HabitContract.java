package com.example.kleocida.habittrackerapp;

import android.provider.BaseColumns;

/**
 * Created by Kleocida on 2017. 06. 10..
 */

public final class HabitContract {
    private HabitContract() {}
    static final class HabitDbEntry implements BaseColumns {

        //TABLE NAME
        static final String DB_HABIT_TABLE_NAME = "habits";

        //TABLE COLUMNS
        static final String HABIT_ID = BaseColumns._ID;
        static final String DOG_WALKING = "dogwalking";
        static final String WALKING_LENGTH = "length";
    }
}
