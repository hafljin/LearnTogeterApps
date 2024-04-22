package com.example.learntogeterapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogeterapps.ui.theme.LearnTogeterAppsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogeterAppsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    TopScreen(
//                        messageTitle = "Jetpack Compose tutorial",
//                        messageTop = "Jetpack Compose tutorial\n" +
//                                "Jetpack Compose is a modern toolkit for building native Android UI. " +
//                                "Compose simplifies and accelerates UI development on Android with less code," +
//                                " powerful tools, and intuitive Kotlin APIs.",
//                        messageDisp = "In this tutorial, you build a simple UI component with declarative functions." +
//                                " You call Compose functions to say what elements you want and the Compose compiler does the rest. " +
//                                "Compose is built around Composable functions. These functions let you define your app\\'s " +
//                                "UI programmatically because they let you describe how it should look and provide data dependencies," +
//                                " rather than focus on the process of the UI\\'s construction, " +
//                                "such as initializing an element and then attaching it to a parent. To create a Composable function, " +
//                                "you add the @Composable annotation to the function name."
//                    )
                    TaskManager(
                        iconSize = 48,
                        color = Color.Green,
                        messageCenter = "All tasks completed",
                        messageBody = "Nice work!"
                    )
                }
            }
        }
    }
}

@Composable
fun TopScreen(
    messageTitle: String,
    messageTop: String,
    messageDisp: String,
    modifier: Modifier = Modifier
) {
    val topImage = painterResource(R.drawable.bg_compose_background)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        //top image
        Image(
            painter = topImage,
            contentDescription = "null"
        )
        Spacer(modifier = Modifier.height(8.dp))
        // title
        Text(
            messageTitle,
            Modifier.padding(8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        // body
        Text(
            messageTop,
            Modifier.padding(8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        // discriptions
        Text(
            messageDisp.take(20000),// maxLength使えないのであり得ない文字数を入れる
            Modifier.padding(8.dp)
        )
    }
}

@Composable
fun TaskManager(
    iconSize:Int,
    color: Color,
    messageCenter: String,
    messageBody: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = "Check Icon",
            modifier = Modifier.size(iconSize.dp),
            tint = color

        )
        Text(
            messageCenter,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(24.dp,24.dp,0.dp,8.dp)
        )
        Text(
            messageBody,
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnTogeterAppsTheme {
        TopScreen(
            messageTitle = "Jetpack Compose tutorial",
            messageTop = "Jetpack Compose tutorial\n" +
                    "Jetpack Compose is a modern toolkit for building native Android UI. " +
                    "Compose simplifies and accelerates UI development on Android with less code," +
                    " powerful tools, and intuitive Kotlin APIs.",
            messageDisp = "In this tutorial, you build a simple UI component with declarative functions." +
                    " You call Compose functions to say what elements you want and the Compose compiler does the rest. " +
                    "Compose is built around Composable functions. These functions let you define your app\\'s " +
                    "UI programmatically because they let you describe how it should look and provide data dependencies," +
                    " rather than focus on the process of the UI\\'s construction, " +
                    "such as initializing an element and then attaching it to a parent. To create a Composable function, " +
                    "you add the @Composable annotation to the function name.",
        )
    }
}

@Preview(showBackground = true)
@Composable
fun IconPreview(){
    LearnTogeterAppsTheme {
      TaskManager(
          iconSize = 48,
          color = Color.Green,
          messageCenter = "All tasks completed",
          messageBody = "Nice work!"
      )
    }
}