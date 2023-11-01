package racingcar.model

class CarProgress {
    fun initialize(carNums: Int): List<String> {
        val carProgress = mutableListOf<String>()
        repeat(carNums) {
            carProgress.add(Constants.EMPTY_SPACE)
        }
        return carProgress
    }
}