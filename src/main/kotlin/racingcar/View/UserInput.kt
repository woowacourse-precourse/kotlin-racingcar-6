package racingcar.View
import camp.nextstep.edu.missionutils.Console

class UserInput {

    fun inputCarName(): String {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

        return Console.readLine()
    }
    fun inputRoundNumber():String {
        println("시도할 횟수는 몇 회인가요?")

        return Console.readLine()
    }
}