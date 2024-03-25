package com.example.chatapp.data

object DataManager {
    fun getPreviousChat(): ArrayList<MessageDetails> {
        return arrayListOf(
            MessageDetails(true, "Hello Dear, How are you?"),
            MessageDetails(false, "Hello, I'm fine, how can i help you"),
            MessageDetails(true, "What is the best programing language ?"),
            MessageDetails(false, "There are many programming languages in the market that " +
                    "are used in designing and building websites, various applications and other tasks. All " +
                    "these languages are popular in their place and in the way they are used, and many programmers learn and use them."),
            MessageDetails(true, "Hello Dear, How are you?"),
            MessageDetails(false, "Hello, I'm fine, how can i help you"),
            MessageDetails(true, "What is the best programing language ?"),
            MessageDetails(false, "There are many programming languages in the market that " +
                    "are used in designing and building websites, various applications and other tasks. All " +
                    "these languages are popular in their place and in the way they are used, and many programmers learn and use them."),
        )
    }
}