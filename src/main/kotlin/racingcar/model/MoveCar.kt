package racingcar.model

class MoveCar(private val generateRandomNumber: GenerateRandomNumber) {
    fun calculateScore(carScore: MutableMap<String, Int>) {
        carScore.forEach { (name, score) ->
            val randomNumber = generateRandomNumber.generate()
            if (randomNumber >= 4) {
                // 이동 o
                carScore[name] = score + 1
            } else if (randomNumber < 4) {
                // 이동 x
            }
        }
    }
}