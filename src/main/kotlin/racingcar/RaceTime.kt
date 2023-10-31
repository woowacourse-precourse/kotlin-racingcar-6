package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

class RaceTime {
    private lateinit var timeInput: String
    private var time: Int = 0

    // 시도 횟수 결정
    fun getRaceTime(): Int {
        println("시도할 횟수는 몇 회인가요?")
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