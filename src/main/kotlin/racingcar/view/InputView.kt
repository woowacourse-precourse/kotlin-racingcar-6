package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    companion object ErrorMessage {
        const val NULL: String = "빈 값 입니다."
        const val CONTAIN_ZERO = "0은 입력될 수 없습니다."
        const val NUMERIC = "숫자만 입력이 가능합니다."
        const val FIVE_LETTER = "이름은 5자리 이하만 입력이 가능합니다."
    }

    fun inputName(): List<String> {
        val list = Console.readLine().split(',').map { it.trim() }
        checkNameFormat(list)
        return list
    }

    fun inputCount(): Int {
        val count = Console.readLine()
        checkCount(count)
        return count.toInt()
    }

    fun checkCount(count: String) {
        if(!isNumeric(count)) { throw IllegalArgumentException(NUMERIC) }
        if(isZero(count)) { throw IllegalArgumentException(CONTAIN_ZERO) }
    }
    private fun isNumeric(count: String): Boolean = count.toIntOrNull() != null
    private fun isZero(count: String): Boolean = count.toInt() == 0

    fun checkNameFormat(list: List<String>) {
        for(i in list) {
            if(!isFiveLetter(i)) { throw IllegalArgumentException(FIVE_LETTER) }
            if(isBlank(i)) { throw IllegalArgumentException(NULL)}
        }
    }
    private fun isFiveLetter(str: String): Boolean = str.length <= 5
    private fun isBlank(str: String): Boolean = str.isBlank()
}