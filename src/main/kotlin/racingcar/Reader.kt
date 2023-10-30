package racingcar

import camp.nextstep.edu.missionutils.Console

class Reader {
    fun read(): String = try {
        Console.readLine()
    } catch (e: Exception) {
        throw IllegalArgumentException(ERROR_MESSAGE)
    }

    companion object {
        private const val ERROR_MESSAGE = " 입력 오류: 유효한 입력이 아닙니다."
    }
}