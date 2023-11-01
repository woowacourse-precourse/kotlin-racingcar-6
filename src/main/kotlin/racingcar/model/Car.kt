package racingcar.model

import racingcar.domain.movestrategy.BasicMoveStrategy
import racingcar.domain.movestrategy.MoveStrategyInterface

class Car(
    val name: String,
    private val moveStrategy: MoveStrategyInterface = BasicMoveStrategy(),
    private val speed: Int = 1,
    initLocation: Int = 0
) {
    var location: Int = initLocation
        private set


    fun move() {
        location = moveStrategy.calculateLocation(speed, location)
    }
}