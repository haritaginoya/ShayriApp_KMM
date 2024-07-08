package com.example.firstapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.firstapp.android.ui.theme.ui.theme.FirstAppTheme

var array = arrayOf("")

class PageShayri : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAppTheme {

                array = intent.getStringArrayExtra("array")!!
                Greeting2(array)

            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Greeting2(array: Array<String>) {
    Surface(modifier = Modifier.fillMaxSize()) {
//        LazyRow(
//            modifier = Modifier
//                .padding(20.dp)
//                .fillMaxSize()
//        ) {
//            items(array.size) {
//                Surface(
//                    color = Color.Gray, modifier = Modifier
//                        .padding(20.dp).fillMaxHeight()
//                ) {
//                    Column {
//                        Text(
//                            text = "तुम्हारी मुस्कान से ही शुरू हुई हमारी कहानी, हर लम्हा प्यार में जीते हैं हम \uD83D\uDE0A❤\uFE0F",
//                            fontSize = 30.sp
//                        )
//                    }
//                }
//            }
//
//        }
        val pagerState = rememberPagerState(pageCount = {
            array.size
        })
        HorizontalPager(state = pagerState) { page ->
            // Our page content
            Text(
                text = array[page],
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxSize(),
                fontSize = 40.sp,
                lineHeight = 50.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    FirstAppTheme {
        Greeting2(array)
    }
}