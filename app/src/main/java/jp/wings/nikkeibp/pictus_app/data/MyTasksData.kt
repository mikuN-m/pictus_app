package jp.wings.nikkeibp.pictus_app.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class MyTasks(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, // 自動採番ID

    @ColumnInfo(name = "name")
    val name: String, // タスク名

//    val category: String, // カテゴリ（例：仕事、健康など）
//
//    val fatigueLevel: Int, // 疲労度（例：1〜10）
//
//    val deadline: Date?, // 期限（null可）
//
//    val fixed: Boolean // 固定タスクかどうか
)
