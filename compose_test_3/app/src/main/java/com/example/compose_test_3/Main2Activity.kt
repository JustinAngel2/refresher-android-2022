package com.example.compose_test_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.compose_test_3.R
import java.lang.reflect.Method

class Main2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val composeView = findViewById<ComposeView>(R.id.compose_view)
        composeView.setContent {
            Column {
                Button(onClick = { println("[foo] compsoe onClick")} ) {
                    Text(text = "foo")
                }
                AndroidView(factory = { ctx ->
                    //Here you can construct your View
                    android.widget.Button(ctx).apply {
                        text = "MyAndroidButton"
                        layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
                        setOnClickListener {
                            println("[foo] android view onClick")
                        }
                    }
                }, modifier = Modifier.padding(8.dp))
            }
        }
    }
}