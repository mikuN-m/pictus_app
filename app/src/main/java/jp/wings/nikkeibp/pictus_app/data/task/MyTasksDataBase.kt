package jp.wings.nikkeibp.pictus_app.data.task

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [MyTasks::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class MyTasksDatabase : RoomDatabase() {

    abstract fun myTasksDao(): MyTasksDao

    companion object {
        @Volatile
        private var instance: MyTasksDatabase? = null

        fun getMyTasksDatabase(context: Context): MyTasksDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    MyTasksDatabase::class.java,
                    "tasks"
                ).build().also { instance = it }
            }
        }
    }
}
