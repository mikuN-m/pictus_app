package jp.wings.nikkeibp.pictus_app.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Task::class], version = 1)
@TypeConverters(Converters::class)
abstract class MyTasksDataBase: RoomDatabase() {
    abstract fun MyTasksDao(): MyTasksDao

    companion object {
        @Volatile
        private var Instances: MyTasksDataBase? = null

        fun getTaskDataBase(context: Context): MyTasksDataBase {
            return Instances ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context,
                    klass = MyTasksDataBase::class.java,
                    name = "tasks"
                )
                    .build()
                    .also { Instances = it }
            }
        }
    }
}