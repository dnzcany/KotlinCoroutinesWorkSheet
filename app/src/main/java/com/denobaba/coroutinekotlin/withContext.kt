package com.denobaba.coroutinekotlin

import kotlinx.coroutines.*


fun main(){

    runBlocking {

        launch(Dispatchers.Default) {
            println("Context ${coroutineContext}")

            //same launch,different threaths
            withContext(Dispatchers.IO){
                println("Context ${coroutineContext}")
            }
        }


    }

}