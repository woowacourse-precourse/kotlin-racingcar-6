package racingcar.model

class CarProgressInit {
    fun progress(carNums: Int): List<String> {
        val carProgress = mutableListOf<String>()
        repeat(carNums) {
            carProgress.add(Constants.EMPTY_SPACE)
        }
        return carProgress
    }
}