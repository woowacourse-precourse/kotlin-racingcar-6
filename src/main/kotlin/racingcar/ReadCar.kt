package racingcar

import camp.nextstep.edu.missionutils.Console
class ReadCar {
    private fun readCarNames(): String {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        return Console.readLine()
    }
    private fun readNumberOfTry(): String {
        println("시도할 횟수는 몇 회인가요?")
        return Console.readLine()
    }

    val carInput = readCarNames()
    val numberOfTry = readNumberOfTry()
}