package racingcar

import java.util.*

fun main() {
    //동기적으로 수행하도록 해야 함
    val racing = Racing()
    racing.ready()
    racing.start()
}
