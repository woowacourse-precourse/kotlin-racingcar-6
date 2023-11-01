package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import racingcar.data.Car

class GameHandler(
    private val io: IOHandler,
    private val analyzer: Analyzer,
) {

    private lateinit var cars: List<Car>
    private var moveCount: Int = NOT_YET_SET

    fun start() {
        set()
        play()
    }

    private fun set() {
        setCar()
        setMoveCount()
    }

    private fun setCar()  {
        io.show(SENTENCE_FOR_GETTING_NAME, true)

        cars = io.getCarNames().map { name ->
            Car(name)
        }
    }

    private fun setMoveCount() {
        io.show(SENTENCE_FOR_GETTING_MOVEMENT, true)

        moveCount = io.getMoveCount()
    }

    private fun play() {
        io.show(EMPTY_SENTENCE_FOR_LINE_BREAK, true)
        io.show(SENTENCE_FOR_RESULT, true)

        repeat(moveCount) {
            moveCars(cars)

            io.showLocation(cars)
            io.show(EMPTY_SENTENCE_FOR_LINE_BREAK, true)
        }
        io.showWinner(analyzer.judgeWinner(cars))
    }

    private fun moveCars(cars: List<Car>) {
        for (car in cars) {
            if (analyzer.isMoveAllowed(getRandomNum())) {
                car.move()
            }
        }
    }

    private fun getRandomNum(): Int = Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM)

    companion object {
        private const val NOT_YET_SET = Int.MIN_VALUE
        private const val SENTENCE_FOR_GETTING_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val SENTENCE_FOR_GETTING_MOVEMENT = "시도할 횟수는 몇 회인가요?"
        private const val SENTENCE_FOR_RESULT = "실행 결과"
        private const val EMPTY_SENTENCE_FOR_LINE_BREAK = ""
        private const val MIN_RANDOM_NUM = 0
        private const val MAX_RANDOM_NUM = 9
    }
}