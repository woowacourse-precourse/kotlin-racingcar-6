package racingcar.model

class Car(
    name: String,
    var position: Int
) {

    fun move(moveStep: MoveStep) {
        position += moveStep.move()
    }
}