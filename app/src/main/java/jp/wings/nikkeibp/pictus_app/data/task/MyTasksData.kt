package jp.wings.nikkeibp.pictus_app.data.task

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "tasks")
data class MyTasks(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, // 自動採番ID

    val name: String, // タスク名
    val category: String, // カテゴリ（例：仕事、健康など）
    val deadline: Date?, // 期限（null可）
    val fixed: Boolean, // 固定タスクかどうか
    val fatigueLevel: Int // 疲労度
)