package jp.wings.nikkeibp.pictus_app.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, // 自動採番ID

    val name: String, // タスク名

    val category: String, // カテゴリ（例：仕事、健康など）

    val fatigueLevel: Int, // 疲労度（例：1〜10）

    val deadline: Date?, // 期限（null可）

    val fixed: Boolean // 固定タスクかどうか
)
