package racingcar

import racingcar.domain.CarListBuilder

fun main() {
    val carListBuilder = CarListBuilder
    PlayRacing(carListBuilder).start()
}
