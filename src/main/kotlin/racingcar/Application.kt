package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("경주할 자동차 이름을 입력하세요.")
    val carname = readLine()
    val cars = carname?.split(",")
    println("시도할 횟수는 몇 회인가요?")
    val numoftry = readLine()?.toInt()
    if (numoftry != null) {
        println("실행 결과")
        for (i in 0..numoftry){

        }
    }

}

fun generateRandomNumber(cars : List<String>)
{
    for (i in 0..cars.size)
    {
        for (car in cars){
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            val dash = "-".repeat(randomNumber)
            println("${car} : ${dash}")
        }
    }
}
