package racingcar.model

class Car(
    val name: String,
    var position: Int
) {

    fun move(moveStep: MoveStep) {
        position += moveStep.move()
        println("$name : " + "-".repeat(position))
    }
}