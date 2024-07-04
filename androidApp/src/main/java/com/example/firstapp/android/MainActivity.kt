package com.example.firstapp.android

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstapp.android.design.AppColors

var shayariCategories = arrayOf(
    "Love Shayari",
    "Sad Shayari",
    "Romantic Shayari",
    "Friendship Shayari",
    "Motivational Shayari",
    "Funny Shayari",
    "Heart Touching Shayari",
    "Bewafa Shayari",
    "Dard Shayari",
    "Attitude Shayari",
    "Life Shayari",
    "Good Morning Shayari",
    "Good Night Shayari",
    "Birthday Shayari",
    "Anniversary Shayari",
    "Patriotic Shayari",
    "Religious Shayari",
    "Ghazal Shayari",
    "Two Line Shayari",
    "Holi Shayari"
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = Color.Gray
                ) {
                    GreetingView(shayariCategories, this)

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GreetingView(shayariCategories: Array<String>, context: Context? = null) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "SHAYRI 2024",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }, colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Gray)
        )
    }, content = {

        LazyColumn(modifier = Modifier.padding(it)) {
            items(shayariCategories.size) { i ->
                Surface(
                    onClick = {
                        var intent = Intent(context, Shayri::class.java)
                        intent.putExtra("pos",i)
                        intent.putExtra("category",shayariCategories[i])
                        context!!.startActivity(intent)
                    },
                    shape = RoundedCornerShape(5.dp),
                    modifier = Modifier.padding(5.dp),
                    color = AppColors.categorycolor
                ) {
                    Text(
                        text = shayariCategories[i],
                        fontSize = 25.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                    )

                }
            }

        }

    }, bottomBar = {
    })

}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView(shayariCategories)
    }
}
