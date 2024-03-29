package com.capstone.cendekiaone.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.capstone.cendekiaone.R
import com.capstone.cendekiaone.ui.navigation.Screen
import com.capstone.cendekiaone.ui.theme.myFont
import com.capstone.cendekiaone.ui.theme.myFont2

@Composable
fun TopAppComponent(
    modifier: Modifier = Modifier,
    navController: NavController // Add the NavController parameter
) {
    ProvideTextStyle(
        value = TextStyle(
            fontFamily = myFont, // Replace with your desired fontFamily
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp // Adjust the fontSize as needed
        )
    ) {
        Row(
            modifier = modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "CendikiaOne",
                style = TextStyle(
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = myFont2
                ),
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            Spacer(modifier = Modifier.weight(1f))

            IconButton(
                onClick = { navController.navigate(Screen.Notification.route) },
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .size(40.dp)
            ) {
                val icon: Painter = painterResource(id = R.drawable.ic_notification_outline)
                Icon(
                    painter = icon,
                    contentDescription = "Icon Notification",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }

            Spacer(modifier = Modifier.width(4.dp))

            IconButton(
                onClick = { navController.navigate(Screen.Chat.route) },
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .size(40.dp)
            ) {
                val icon: Painter = painterResource(id = R.drawable.ic_chat_outline)
                Icon(
                    painter = icon,
                    contentDescription = "Icon Chat",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}

@Preview
@Composable
fun TopAppComponentPreview() {
    val navController = rememberNavController()
    TopAppComponent(
        modifier = Modifier,
        navController = navController
    )
}