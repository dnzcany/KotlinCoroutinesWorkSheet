package com.denobaba.coroutinekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            repeat(100000){
                launch {
                    println("hithere")
                }
            }
        }
        println("run blocking start")
        runBlocking {
            launch {
                delay(5000)
                println("run blocking")
            }
        }
        println("run blocking end")

        println("Global scope start")

        GlobalScope.launch {
            launch {
                println("Global scope")
            }
        }
        println("Global scope end")

        //global scope dont block another codes
        //run blocking block another codes except himself

        main()

    }



    fun main(){

        runBlocking {
            launch {
                delay(5000)
                println("runblockinghere")
                suspendfunctionunderstanding()
            }
        }

        CoroutineScope(Dispatchers.Default).launch {
            delay(2000)
            println("coroutinescoprunning")
        }

        //runblocking can't block CoroutineScope because they are in same block


    }


    suspend fun suspendfunctionunderstanding(){
        coroutineScope {              //call suspend functions another coroutine and use
            launch {
                println("wassap")
            }

        }
    }






}