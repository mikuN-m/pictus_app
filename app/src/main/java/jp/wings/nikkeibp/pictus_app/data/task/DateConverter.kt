package jp.wings.nikkeibp.pictus_app.data.task

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {

    // Long → Date
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    // Date → Long
    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}