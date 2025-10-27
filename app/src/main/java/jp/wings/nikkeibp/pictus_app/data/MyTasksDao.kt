package jp.wings.nikkeibp.pictus_app.data

import androidx.room.*

@Dao
interface MyTasksDao {
    @Query("SELECT * FROM tasks")
    fun getAll(): List<Task>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(task: Task)

    @Delete
    fun delete(task: Task)
}