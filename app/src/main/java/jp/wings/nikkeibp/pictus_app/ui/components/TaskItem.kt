package jp.wings.nikkeibp.pictus_app.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jp.wings.nikkeibp.pictus_app.data.task.MyTasks
import jp.wings.nikkeibp.pictus_app.util.JsonUtils
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun TaskItem (task: MyTasks) {
    // カテゴリ（JSON → List<String>）
    val categories = JsonUtils.jsonToList(task.category)
    val categoryText = categories.joinToString(" / ")

    // 日付フォーマット
    val formattedDate = task.deadline?.let {
        SimpleDateFormat("yyyy年MM月dd日 (E)", Locale.JAPANESE).format(it)
    } ?: "未設定"

    Column(){
        // タスク名
        Text(text = task.name)

        // カテゴリ
        Text(text = "カテゴリ: $categoryText")

        // 期限
        Text(text = "期限: $formattedDate")

        Spacer(modifier = Modifier.height(16.dp))
    }
}