package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("경주할 자동차 이름을 입력하세요.")
    val carname = readlnOrNull() // 자동차 이름을 입력받음
    val cars = carname?.split(",") // ,를 기준으로 나눔
    val numofcars = cars?.size
    if (numofcars != null)
    {
        var moveCar = Array(size = numofcars) {0}
        println("시도할 횟수는 몇 회인가요?")
        val numoftry = readlnOrNull()?.toInt()
        if (numoftry != null) {
            println("실행 결과")
            for (i in 0 until numoftry){
                generateRandomNumberAndCheckMove(cars, moveCar)
                println("")
            }
            for (j in 0 until numofcars)
            {
                val name = cars[j]
                val total = moveCar[j]
                println("$name : $total")
            }
        }
    }
}

fun generateRandomNumberAndCheckMove(cars : List<String>, carmove : Array<Int>)
{
    for (i in cars.indices)
    {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4) {
            carmove[i] += randomNumber
        }
        val dash = "-".repeat(randomNumber)
        val carname = cars[i]
        println("$carname : $dash")
    }
}