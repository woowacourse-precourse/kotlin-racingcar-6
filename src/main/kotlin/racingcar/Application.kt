package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("경주할 자동차 이름을 입력하세요.")
    val inputString = readlnOrNull() // 자동차 이름을 입력받음
    val carname = if (inputString.isNullOrBlank()) throw IllegalArgumentException("잘못된 값을 입력하였습니다.") else inputString
    val cars = carname.split(",") // ,를 기준으로 나눔
    if (cars.any { it.length > 5 }) {
        throw IllegalArgumentException("잘못된 값을 입력하였습니다.")
    }
    val numofcars = cars.size
    val moveCar = Array(size = numofcars) {0}
    println("시도할 횟수는 몇 회인가요?")
    val inputnum = readlnOrNull()
    val numoftry = try {
        if (inputnum.isNullOrBlank()) { // null or blank 체크 후 아니면 int로 변환
            throw IllegalArgumentException("잘못된 값을 입력하였습니다.")
        } else {
            inputnum.toInt()
        }
    } catch (e: IllegalArgumentException) {
        // 숫자로 변환할 수 없는 경우 예외 처리
        throw IllegalArgumentException("잘못된 값을 입력하였습니다.")
    }
    resultRace(numoftry, cars, moveCar)
}

fun generateRandomNumber(cars : List<String>, carmove : Array<Int>)
{
    for (i in cars.indices)
    {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        checkMove(randomNumber, i, carmove) // 이동 조건 체크
        val dash = "-".repeat(carmove[i])
        val carname = cars[i]
        println("$carname : $dash")
    }
}

fun checkMove(randomnum : Int, index : Int, carmove : Array<Int>)
{
    if (randomnum >= 4) {
        carmove[index] += 1
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

fun resultRace(numoftry : Int, cars : List<String>, carmove : Array<Int>){
    println("실행 결과")
    for (i in 0 until numoftry){
        generateRandomNumber(cars, carmove)
        println("")
    }

    printWinner(cars, carmove)
}