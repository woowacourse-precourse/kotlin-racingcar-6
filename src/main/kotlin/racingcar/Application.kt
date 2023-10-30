package racingcar

import racingcar.domain.Car

fun main() {
    var hyundai = Car("현대")
    hyundai.move(5)
    hyundai.move(5)
    hyundai.move(5)
    println(hyundai.toString())
}
