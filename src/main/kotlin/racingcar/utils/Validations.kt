package racingcar.utils

object Validations {
    fun inputTrial(num: String): Int {
        val result: Int
        try {
            result = num.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("문자가 아닌 숫자를 입력하세요.")
        }
        return result
    }

    fun inputCarName(name: String): String {
        val names = name.split(",")
        val result = names.joinToString(",")
        if(result.length > 5) {
            throw IllegalArgumentException("")
        }
        return  name
    }
}