package racingcar

import camp.nextstep.edu.missionutils.Console

fun printRace(cars: Array<RacingCar>){
    for (i in 0..cars.size-1){
        cars[i].getRandomNum()
        cars[i].updateMoveCnt()
        cars[i].printResult()
    }
    println("")
}

fun findWinner(cars: Array<RacingCar>): ArrayList<String>{
    val winner = ArrayList<RacingCar>()

    winner.add(cars[0])
    println("test")

    for (i in 1..cars.size-1){
        if (winner[0].getMoveCnt() < cars[i].getMoveCnt()){
            winner.clear()
            winner.add(cars[i])
        }
        else if(winner[0].getMoveCnt() == cars[i].getMoveCnt()) winner.add(cars[i])
    }

    val winners = ArrayList<String>()
    for (i in 0..winner.size-1){
        winners.add(winner[i].name)
    }

    return winners
}

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val userInput = Console.readLine()
    val users = userInput.split(",")

    for (i in 0..users.size-1){
        if (users[i].length > 5) throw IllegalArgumentException("잘못된 값을 입력하였습니다.")
    }

    val userCars = Array<RacingCar>(users.size){RacingCar("")}
    for (i in 0..users.size-1){
        userCars[i] = RacingCar(users[i])
    }

    println("시도할 횟수는 몇 회인가요?")
    val cnt = Console.readLine().toInt()

    println("\n실행 결과")
    for (i in 1..cnt){
        printRace(userCars)
    }
    val winners = findWinner(userCars)
    val result = winners.joinToString(",")

    println("최종 우승자 : $result")


}
