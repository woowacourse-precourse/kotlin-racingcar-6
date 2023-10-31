package racingcar

import racingcar.domain.CarListBuilder

fun main() {
    val carList = CarListBuilder
    PlayRacing(carList).start()
}
