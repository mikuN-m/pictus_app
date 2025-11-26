package jp.wings.nikkeibp.pictus_app.ui.screen

import android.app.DatePickerDialog
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import jp.wings.nikkeibp.pictus_app.TaskViewModel
import jp.wings.nikkeibp.pictus_app.data.task.MyTasks
import jp.wings.nikkeibp.pictus_app.ui.components.NavigationContent
import jp.wings.nikkeibp.pictus_app.util.JsonUtils
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun TaskAdd (
    navController: NavHostController,
    viewModel: TaskViewModel,
    onSaved: () -> Unit,
    modifier: Modifier = Modifier
) {
    var name by remember { mutableStateOf("") }
    var selectedCategories by remember { mutableStateOf<List<String>>(emptyList()) }
    var deadline by remember { mutableStateOf<Date?>(null) }

    val context = LocalContext.current

    // カレンダーで初期値セット（期限がなければ今日）
    val calendar = Calendar.getInstance()
    if (deadline != null) {
        calendar.time = deadline!!
    }

    // DatePickerDialogを生成
    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            calendar.set(year, month, dayOfMonth)
            deadline = calendar.time // 選択された日付をセット
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    Box {
        Column {

//            タスク名
            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("タスク名") }
            )
            Spacer(modifier = Modifier.height(16.dp))

//            カテゴリ選択
            Text("カテゴリーを選択(複数可)")
            val categories = listOf("仕事", "プライベート", "上司", "家族","その他")

            FlowRow {
                categories.forEach { category ->
                    FilterChip(
                        selected = selectedCategories.contains(category),
                        onClick = {
                            selectedCategories =
                                if (selectedCategories.contains(category)) {
                                    selectedCategories - category
                                } else {
                                    selectedCategories + category
                                }
                        },
                        label = { Text(category) }
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

//            期限
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("期限：")
                Text(deadline?.let {
                    val sdf = SimpleDateFormat("yyyy年MM月dd日（E）", Locale.JAPANESE)
                    sdf.format(it)
                } ?: "未設定")

                Button(onClick = {
                    datePickerDialog.show()
                }) {
                    Text("選択")
                }
            }
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    val json = JsonUtils.listToJson(selectedCategories)

                    val task = MyTasks(
                        name = name,
                        category = json,
                        deadline = deadline,
                        fixed = false
                    )
                    viewModel.addTask(task)
                    onSaved()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("保存する")
            }
        }

        NavigationContent(navController = navController)
    }
}
