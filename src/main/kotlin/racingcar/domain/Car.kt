package racingcar.domain

class Car(val name: String) : Move {
    override fun moveForward() = 1

    override fun stop() = 0

}

