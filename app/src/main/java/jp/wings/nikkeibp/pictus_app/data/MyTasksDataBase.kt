package jp.wings.nikkeibp.pictus_app.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MyTasks::class], version = 1)
abstract class MyTasksDataBase: RoomDatabase() {
    abstract fun MyTasksDao(): MyTasksDao

    companion object {
        @Volatile
        private var instance: MyTasksDataBase? = null

        fun getMyTasksDatabase(context: Context): MyTasksDataBase {
            return instance ?:synchronized(this) {
                Room.databaseBuilder(
                    context = context,
                    klass = MyTasksDataBase::class.java,
                    name = "tasks"
                )
                    .build()
                    .also { instance = it }
            }
        }
    }
}