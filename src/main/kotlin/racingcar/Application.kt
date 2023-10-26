package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("경주할 자동차 이름을 입력하세요.")
    val carname = readlnOrNull() // 자동차 이름을 입력받음
    val cars = carname?.split(",") // ,를 기준으로 나눔
    val numofcars = cars?.size
    if (numofcars != null)
    {
        val moveCar = Array(size = numofcars) {0}
        println("시도할 횟수는 몇 회인가요?")
        val numoftry = readlnOrNull()?.toInt()
        if (numoftry != null) {
            println("실행 결과")
            for (i in 0 until numoftry){
                generateRandomNumber(cars, moveCar)
                println("")
            }

            printWinner(cars, moveCar)
        }
    }
}

fun generateRandomNumber(cars : List<String>, carmove : Array<Int>)
{
    for (i in cars.indices)
    {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        checkMove(randomNumber, i, carmove)
        val dash = "-".repeat(randomNumber)
        val carname = cars[i]
        println("$carname : $dash")
    }
}

fun checkMove(randomnum : Int, index : Int, carmove : Array<Int>)
{
    if (randomnum >= 4) {
        carmove[index] += randomnum
    }
}

fun printWinner(cars : List<String>, carmove : Array<Int>) {
    val maxnumber = carmove.max()
    val winners = mutableListOf<String>()
    for (i in carmove.indices)
    {
        if(carmove[i] == maxnumber)
        {
            winners.add(cars[i])
        }
    }
    val winnersString = winners.joinToString(", ")
    println("최종 우승자 : $winnersString")
}