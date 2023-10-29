package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import racingcar.data.Car

class GameHandler(private val io: IOHandler) {

    private lateinit var cars: List<Car>
    private var moveCount: Int = NOT_YET_SET

    fun start() {
        setGame()
        playGame()
    }

    private fun setGame() {
        setCar()
        setMoveCount()
    }

    private fun setCar()  {
        io.show(SENTENCE_FOR_GETTING_NAME)

        val result = mutableListOf<Car>()

        val names = io.getCarName()
        for (name in names) {
            result.add(Car(name))
        }
        cars = result.toList()
    }

    private fun setMoveCount() {
        io.show(SENTENCE_FOR_GETTING_MOVEMENT)
        moveCount = io.getMoveCount()
    }

    private fun playGame() {
        io.show(SENTENCE_FOR_RESULT)

        repeat(moveCount) {
            moveCars(cars)
            showLocation(cars)
        }
    }

    private fun moveCars(cars: List<Car>) {
        for (car in cars) {
            if (judgeCanMove()) {
                car.move()
            }
        }
    }

    private fun judgeCanMove(): Boolean = getRandomNum() >= MIN_PASSING_NUM

    private fun getRandomNum(): Int = Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM)

    private fun showLocation(cars: List<Car>) {
        for (car in cars) {
            io.show(car)
            io.show(LINE_BREAK)
        }
        io.show(LINE_BREAK)
    }

    companion object {
        private const val SENTENCE_FOR_GETTING_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"
        private const val SENTENCE_FOR_GETTING_MOVEMENT = "시도할 횟수는 몇 회인가요?\n"
        private const val SENTENCE_FOR_RESULT = "실행 결과\n"
        private const val NOT_YET_SET = Int.MIN_VALUE
        private const val MIN_RANDOM_NUM = 0
        private const val MAX_RANDOM_NUM = 9
        private const val MIN_PASSING_NUM = 4
        private const val LINE_BREAK = "\n"
    }
}