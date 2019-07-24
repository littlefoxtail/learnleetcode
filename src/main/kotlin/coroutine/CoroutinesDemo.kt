//package coroutine
//
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.coroutineScope
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.runBlocking
//
//fun main(args: Array<String>) {
//  nineSuspend()
//}
//
//private fun firstSuspend() {
//  // 本质上，协程是轻量级的线程
//  // 可以使用一些协程操作来替换一些线程操作
//  GlobalScope.launch {
//    //    是一个特别的挂起函数，它不会造成线程阻塞，但是挂起函数只能在协程中使用
//    delay(1000L)
//    print("Hello!")
//  }
//  print("Hello,")
//  Thread.sleep(2000L)
//}
//
//
//private fun secondSuspend() {
//  GlobalScope.launch {
//    delay(1000L)
//    println("World!")
//  }
//  println("Hello,")
//
//  runBlocking {//这个函数阻塞了主线程
//    delay(2000L)
//  }
//}
//
//private fun thirdSuspend() {
////  runBlocking<Unit>{...}作为一个适配器被用来启动最高优先级的主协程
//  runBlocking<Unit> {
//    GlobalScope.launch {
//      delay(1000L)
//      println("World!")
//    }
//
//    println("Hello,")
//    delay(2000L)
//  }
//}
//
//private fun fourthSuspend() {
//
//  runBlocking {
//    val job = GlobalScope.launch {
//      delay(1000L)
//      println("World!")
//    }
//
//    println("Hello,")
//    job.join() //等待直到子协程结束，这样写的话，主协程与后台任务时间没有任何关联
//  }
//}
//
//private fun fiveSuspend() {
////  一个外部的协程没有在所有的协程在它们的作用域内启动完成后执行完毕
//  runBlocking {
//    launch {//在runBlocking作用域内启动一个新协程
//      delay(1000L)
//      println("World!")
//    }
//
//    println("Hello,")
//  }
//}
//
////作用域构建器
//
////可以使用coroutineScope构建起来声明你自己的作用域。它启动一个新的协程作用域并且在所有
////子协程结执行结束后并没有执行完毕。runBlocking和coroutineScope主要不同之处在于后者在
////等待所有子协程执行完毕并没有使当前线程阻塞
//private fun sixSuspend() {
//  runBlocking {
//    launch {
//      delay(200L)
//      println("Task from runBlocking")
//    }
//
//    coroutineScope {//创建一个新的协程作用域
//      launch {
//        delay(500L)
//        println("Task from nested launch")
//      }
//
//      delay(100L)
//      println("Task from coroutine scope") //该行将在嵌套启动之前执行打印
//
//    }
//
//    println("Coroutine scope is over")
//  }
//}
//
//private fun sevenSuspend() {
//  runBlocking {
//    launch { doWorld() }
//    println("Hello,")
//  }
//}
//
///**
// * 挂起函数，可以像普通的函数一样使用内部协程
// */
//suspend fun doWorld() {
//  delay(1000L)
//  println("World!")
//}
//
///**
// * 协程是轻量的
// */
//private fun eightSuspend() {
//  runBlocking {
//    repeat(100_000) {//启动大量的线程
//      launch {
//        delay(1000L)
//        print(".")
//      }
//    }
//  }
//}
//
///**
// * 像守护线程一样的全局协程
// */
//private fun nineSuspend() {
//  runBlocking {
//    GlobalScope.launch {
//      repeat(1000) {
//        i -> println("i'm sleeping $i ...")
//        delay(500L)
//      }
//    }
//    delay(1300L)
//  }
//}
//
//
