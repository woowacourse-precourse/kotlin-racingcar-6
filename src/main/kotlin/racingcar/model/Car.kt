package racingcar.model

class Car(val name: String) : Movement {
    override fun moveForward() = 1

    override fun stop() = 0

}

