package racingcar
import camp.nextstep.edu.missionutils.Console.readLine
class inputTrys {
fun getinputTrys(): Int {
    while (true) {
        print("시도할 횟수는 몇 회인가요? ")
        val userInput = readLine()

        try {
            val numberOfAttempts = userInput?.toInt() ?: 0

            if (numberOfAttempts > 0) {
            return numberOfAttempts
            } else {
            println("유효하지 않은 입력입니다. 양의 정수를 입력하세요.")
            }
            } catch (e: NumberFormatException) {
            println("유효하지 않은 입력입니다. 양의 정수를 입력하세요.")
            }
        }
    }
}
