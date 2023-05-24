package com.denobaba.coroutinekotlin

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        launch {              //if we write like that, we doesn't say what we can do when run blocking end,
                                             // with jobs, we can say for example cancel this coroutine and close.
            delay(2000)
            println("chivas")
        }
    }

    val job1 = runBlocking {
        launch {
            delay(5000)
            println("hijob")
        }
    }

    job1.invokeOnCompletion {
        println("myjobend")
    }

    job1.cancel() // for closing coroutines
}



