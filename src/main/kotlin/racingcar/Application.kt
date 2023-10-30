package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val userInput = Console.readLine()
    val users = userInput.split(",")

    for (i in 0..users.size){
        if (users[i].length > 5){
            throw IllegalArgumentException("잘못된 값을 입력하였습니다.")
        }
    }

    val userCars:Array<RacingCar> = arrayOf(RacingCar(users[0]), RacingCar(users[1]), RacingCar(users[2]))

    println("시도할 횟수는 몇 회인가요?")
    val cnt = Console.readLine()
}
