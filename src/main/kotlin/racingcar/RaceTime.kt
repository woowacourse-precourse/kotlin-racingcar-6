package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

class RaceTime {
    private lateinit var timeInput: String
    private var time: Int = 0

    // 시도 횟수 결정
    fun getRaceTime(): Int {
        println(MessageConstants.INPUT_TIMES)
        timeInput = readLine()

        return try {
            time = timeInput.toInt()
            if (time < 1) {
                throw IllegalArgumentException("0보다 큰 숫자를 입력하세요.")
            }
            time
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("유효한 숫자를 입력하세요.")
        }
    }
}