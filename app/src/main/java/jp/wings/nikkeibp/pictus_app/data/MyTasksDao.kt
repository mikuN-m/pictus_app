package jp.wings.nikkeibp.pictus_app.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MyTasksDao {
    @Query("SELECT * FROM tasks")
    fun getAll(): Flow<List<MyTasks>>

    @Insert
    suspend fun insertTask(myTask: MyTasks)

    @Delete
    suspend fun deleteAllMyTasks(allMyTasks: List<MyTasks>)
}