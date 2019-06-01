package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
  cancleCoroutine()
}

private fun cancleCoroutine() {
  runBlocking {

    val job = launch {
      repeat(1000) {
        i -> println("I'm sleeping $i ...")
        delay(500L)
      }
    }
    delay(1300L) //延迟一段时间
    println("main: I'm tired of waiting!")
    job.cancel() //取消任务
    job.join()// 等待任务执行结束
    println("main: Now I can quit.")
  }
}

//取消是协作的

//协程的取消是协作的。一段协程代码必须协作才能被取消。所有kolinx.coroutines中的挂起函数
//都是可被取消的。它们检查协程的取消

private fun cancleCoroutine2() {
  runBlocking {
    val startTime = System.currentTimeMillis()

  }

}