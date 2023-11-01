package racingcar.domain

class CarStatusUpdater {
    fun moveCarForward(carStatus: MutableMap<String, String>, carName: String, randomNumber: Int) {
        val judgment = Judgment()

        if (judgment.canMoveForward(randomNumber)) {
            carStatus[carName] = carStatus[carName] + "-"
        }
    }
}
