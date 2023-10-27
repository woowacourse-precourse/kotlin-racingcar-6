package racingcar.view

import camp.nextstep.edu.missionutils.Console
class InputView {
    private fun inputCarName() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val cars = Console.readLine()
        // TODO RacingCar 객체 생성
    }
    private fun inputTryCount() {
        println("시도할 횟수는 몇 회인가요?")
        val tryCnt = Console.readLine()
        // TODO Game 실행 코드 구현
    }

    fun playGame() {
        inputCarName()
        inputTryCount()
    }
}