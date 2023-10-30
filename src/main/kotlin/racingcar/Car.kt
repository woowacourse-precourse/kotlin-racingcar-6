package racingcar

class Car(
    private val moveStrategy: MoveStrategyInterface = BasicMoveStrategy(),
    private val speed: Int = 1,
    initLocation: Int = 0
) {
    var location: Int = initLocation
        private set
}