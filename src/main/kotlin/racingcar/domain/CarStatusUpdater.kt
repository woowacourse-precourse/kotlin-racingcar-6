package racingcar.domain

class CarStatusUpdater {
    fun moveCarForward(carStatus: MutableMap<String, String>, carName: String) {
        val judgment = Judgment()
        val numberGenerator = NumberGenerator()
        val randomNumber = numberGenerator.createRandomNumber()

        if (judgment.canMoveForward(randomNumber)) {
            carStatus[carName] = carStatus[carName] + "-"
        }
    }
}
