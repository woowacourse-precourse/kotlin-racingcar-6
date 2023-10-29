package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

// 시도 횟수 결정
fun getRaceTime(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val timeInput = readLine()
    val time = timeInput?.toInt() ?: throw IllegalArgumentException("유효한 숫자를 입력하세요.")

    if (time < 1)
        throw IllegalArgumentException("0보다 큰 숫자를 입력하세요.")

    return time
}