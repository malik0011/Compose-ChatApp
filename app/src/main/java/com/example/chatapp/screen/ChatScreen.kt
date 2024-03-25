package com.example.chatapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapp.R
import com.example.chatapp.data.DataManager
import com.example.chatapp.data.MessageDetails
import com.example.chatapp.ui.theme.MyBlue
import com.example.chatapp.ui.theme.MyGray
import com.example.chatapp.ui.theme.MyGray2
import com.example.chatapp.ui.theme.MyGray3
import com.example.chatapp.ui.theme.MyGreen
import com.example.chatapp.ui.theme.OffWhite

@Preview
@Composable
fun ChatScreen() {
    //top screen
    Box() {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(1f)
                    .background(Color.White)
            ) {
                TopBar()
                ChatSection()
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp, 0.dp, 0.dp, 30.dp),
            contentAlignment = Alignment.BottomCenter,
        ) {
            InputSection()
        }
    }
}

@Composable
fun ChatSection() {
    val dataList = DataManager.getPreviousChat()

    LazyColumn(content = {
        items(dataList) {
            if (it.isMyText) ItemMyChat(chat = it)
            else ItemOtherChat(chat = it)
        }
    }, modifier = Modifier
        .fillMaxHeight(1f)
        .padding(12.dp, 0.dp, 0.dp, 0.dp)
    )
}

@Composable
fun TopBar(){
    Column(verticalArrangement = Arrangement.SpaceEvenly) {
        Row(
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_back) ,
                contentDescription = "back" ,
                modifier = Modifier
                    .size(40.dp)
                    .padding(6.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_robot),
                contentDescription = "photo",
                Modifier
                    .size(40.dp, 40.dp)
                    .padding(10.dp, 0.dp, 0.dp, 0.dp)
            )
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(.70f)
            ) {
                Text(
                    text = "Jhon Doe.",
                    color = MyBlue,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_dot),
                        contentDescription = "online status",
                        modifier = Modifier
                            .size(10.dp)
                            .padding(0.dp, 0.dp, 5.dp, 0.dp),
                        colorFilter = ColorFilter.tint(MyGreen)
                    )
                    Text(text = "Online", color = MyGreen)
                }

            }
            Image(
                painter = painterResource(id = R.drawable.ic_mute),
                contentDescription = "mute",
                Modifier
                    .size(40.dp)
                    .padding(10.dp, 0.dp, 0.dp, 0.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_logout),
                contentDescription = "mute",
                Modifier
                    .size(40.dp)
                    .padding(12.dp, 0.dp, 0.dp, 0.dp)
            )
        }
        Box(
            Modifier
                .fillMaxWidth(1f)
                .background(Color.LightGray)
                .size(1.dp)
                .padding(10.dp, 20.dp, 0.dp, 0.dp)
        )
    }
}

@Composable
fun ItemMyChat(chat: MessageDetails) {
    Box(
        contentAlignment = Alignment.CenterEnd,
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth(1f)
            .padding(10.dp, 20.dp, 20.dp, 20.dp)

    ) {
        ChatText(
            chatText = chat.text,
            Color.White,
            modifier = Modifier
                .background(color = MyBlue, shape = RoundedCornerShape(25.dp, 0.dp, 25.dp, 25.dp))
        )
    }
}

@Composable
fun ItemOtherChat(chat: MessageDetails) {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxWidth(1f)
            .padding(10.dp, 10.dp, 20.dp, 18.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_robot) ,
                contentDescription = "Chat Image",
                Modifier
                    .size(30.dp)
                    .align(Alignment.Bottom)
                    .padding(0.dp, 0.dp, 12.dp, 0.dp)
            )
            ChatText(
                chatText = chat.text,
                MyGray3,
                modifier = Modifier
                .background(color = MyGray2, shape = RoundedCornerShape(25.dp, 25.dp, 25.dp, 0.dp))
            )
        }
    }
}

@Composable
fun ChatText(chatText: String, textColor: Color, modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        Text(
            text = chatText,
            color = textColor,
            modifier = Modifier.padding(25.dp, 20.dp)
        )
    }
}

@Composable
fun InputSection() {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
    ) {
        Card(
            colors = CardDefaults.cardColors(Color.Transparent),
            shape = CardDefaults.elevatedShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(10.dp)
                .background(
                    color = OffWhite,
                    shape = RoundedCornerShape(50.dp, 50.dp, 50.dp, 50.dp)
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(Color.Transparent)
            ) {
                HintEditText(
                    Modifier
                        .fillMaxWidth(.75f)
                        .height(40.dp)
                        .align(Alignment.CenterVertically)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_mic),
                    contentDescription = "Mic",
                    colorFilter = ColorFilter.tint(MyGray),
                    modifier = Modifier
                        .size(30.dp)
                        .fillMaxWidth(.15f)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_send),
                    contentDescription = "Mic",
                    Modifier
                        .size(35.dp)
                        .fillMaxWidth(.15f)
                        .padding(0.dp, 0.dp, 2.dp, 0.dp)
                )
            }

        }
    }
}

@Composable
fun HintEditText(modifier: Modifier) {
    val inputState = remember { mutableStateOf("") }
    val hint = "Write your message"
    val backgroundColor = Color.Transparent // Change the background color here

    Box(
        modifier = modifier
            .background(color = backgroundColor),
        contentAlignment = Alignment.CenterStart
    ) {
        BasicTextField(
            value = inputState.value,
            onValueChange = { inputState.value = it },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        if (inputState.value.isEmpty()) {
            Text(
                text = hint,
                color = Color.Gray,
                modifier = Modifier.padding(start = 16.dp),
            )
        }
    }
}