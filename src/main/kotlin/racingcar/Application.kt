package racingcar

import racingcar.domain.Car
import racingcar.domain.Winner

fun main() {
    var hyundai = Car("현대")
    var tesla = Car("테슬라")
    var kia = Car("기아")
    hyundai.move(5)
    tesla.move(3)
    kia.move(5)

    hyundai.move(5)
    tesla.move(3)
    kia.move(5)
    var winners = Winner(mutableListOf(hyundai,tesla,kia))
    winners.getWinners()
    println(winners.toString())
}
