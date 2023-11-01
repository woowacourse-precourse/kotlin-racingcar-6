package racingcar

import java.lang.IllegalArgumentException

fun main() {

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n")
    val carNames =  readLine()
    var carArray  = splitCarNames(carNames)

    if (carArray != null) {
        checkNames(carArray)
    }

    println("시도할 횟수는 몇 회인가요?\n")

    var gameNum = readLine()?.toInt()

    val gamePlay = GamePlay(gameNum,carArray)

    print("최종 우승자 : ")

    val separator = ", "
    val winner = gamePlay.winnerList.joinToString(separator)
    print(winner)


}


fun splitCarNames(carNames : String?) : List<String>?{
    return carNames?.split(",")
}


fun checkNames(carList : List<String>){
    carList.forEach {  car ->
        if(car.length > 5 || car.length == 0) throw IllegalArgumentException("자동차 이름은 5자리 이하여야 합니다.")
    }
}
