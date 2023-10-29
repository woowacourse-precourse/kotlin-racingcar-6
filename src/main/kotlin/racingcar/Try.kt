package racingcar

class Try {
    fun tryNumberInput(): Int {
        println("시도할 횟수는 몇 회인가요?")
        var inputedTry = readLine()
        return inputedTry!!.toInt()
    }
}