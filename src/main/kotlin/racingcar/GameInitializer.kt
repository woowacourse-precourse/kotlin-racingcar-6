package racingcar

class GameInitializer {

    fun init(cars: Cars, round: Round) {
        setPlayerCars(cars)
        setRoundCount(round)
    }

    private fun setPlayerCars(cars: Cars) {
        println(START_INFO)
        cars.init()
    }

    private fun setRoundCount(round: Round) {
        println(ROUND_COUNT_QUESTION)
        round.init()
    }

    companion object {
        const val START_INFO = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val ROUND_COUNT_QUESTION = "시도할 횟수는 몇 회인가요?"
    }
}