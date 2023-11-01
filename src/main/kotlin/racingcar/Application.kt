package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val cars = Console.readLine()
    val racingCars = RacingCarValidator.instance.checkCars(cars)
    println("시도할 횟수는 몇 회인가요?")
    val trying = Console.readLine()
    val tryTimes = RacingCarValidator.instance.checkTrying(trying)
    RacingGames().checkTime(racingCars, tryTimes)
}
