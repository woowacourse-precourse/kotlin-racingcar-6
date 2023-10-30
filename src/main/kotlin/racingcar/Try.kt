package racingcar

class Try {
    fun tryNumberInput(): Int {
        var numberOfAttempts = 0
        println("시도할 횟수는 몇 회인가요?")  // TODO 잘못 입력 받았을 경우 throw문 구현
        try {
            numberOfAttempts = readLine()!!.toInt()
        } catch (e: NumberFormatException) {
            //throw IllegalArgumentException()
            println("오류")
        }
        return numberOfAttempts
    }
}