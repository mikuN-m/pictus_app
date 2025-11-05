import jp.wings.nikkeibp.pictus_app.data.MyTasks
import jp.wings.nikkeibp.pictus_app.data.MyTasksDao
import jp.wings.nikkeibp.pictus_app.data.MyTasksDataBase

class MyTasksRepository(private val myTasksDao: MyTasksDao) {
    fun getAll() = myTasksDao.getAll()

    suspend fun insertMyTask(myTasks: MyTasks) = myTasksDao.insertTask(myTasks)

    suspend fun deleteAllMyTasks(allMyTasks: List<MyTasks>) = myTasksDao.deleteAllMyTasks(allMyTasks)
}