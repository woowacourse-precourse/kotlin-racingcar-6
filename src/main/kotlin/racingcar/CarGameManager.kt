package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import racingcar.Constants.Companion.EXECUTION_RESULT_MESSAGE
import racingcar.Constants.Companion.FINAL_WINNER_MESSAGE
import racingcar.Constants.Companion.FORWARD_CONDITION
import racingcar.Constants.Companion.INPUT_PROMPT_MESSAGE
import racingcar.Constants.Companion.MAX_NUMBER
import racingcar.Constants.Companion.MIN_NUMBER
import racingcar.Constants.Companion.TRY_COUNT_PROMPT_MESSAGE

class CarGameManager {

    // 전반적인 게임의 구동을 담당.
    fun play() {
        println(INPUT_PROMPT_MESSAGE)
        val carNames = getInputUser()
        val carNamesList = carNames.split(",")
        Validator().validateUserInput(carNamesList.map { it.trim() })
        println(TRY_COUNT_PROMPT_MESSAGE)
        val tryCount = getInputUser().toInt()
        println(EXECUTION_RESULT_MESSAGE)
        val carListCount = carNamesList.size
        val carResultList = MutableList(carListCount) { "" }

        for (countTry in 0 until tryCount) {

            for (countList in 0 until carListCount) {
                val randomNumber = generateRandomNumber()
                if (randomNumber >= FORWARD_CONDITION) carResultList[countList] += "-"
                println("${carNamesList[countList]} : ${carResultList[countList]}")
            }
            println()
        }

        val winnerListLength = carResultList.max().length
        val winnersList = mutableListOf<String>()

        for (countList in 0 until  carListCount) {
            if (winnerListLength == carResultList[countList].length) {
                winnersList.add(carNamesList[countList])
            }
        }
        println("$FINAL_WINNER_MESSAGE${winnersList.joinToString(", ")}")
    }

    // 사용자의 자동차 이름, 시도횟수를 입력 받는 기능
    private fun getInputUser(): String {
        return Console.readLine()
    }

    // 0 - 9 사이의 무작위 값을 부여하는 기능
    private fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
    }

    // 전진하는 자동차 이름과 함께 출력하는 기능

    // 우승자 판별 후 출력 기능 (공동 우승자일시 쉼표(,)구분)


}