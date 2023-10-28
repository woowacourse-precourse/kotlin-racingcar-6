package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    askCarName()

}

fun askCarName(){
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNames :MutableList<String> = Console.readLine().split(",") as MutableList<String>
    for (carName in carNames){
        if(carName.length>5)
            throw IllegalArgumentException()
    }
}
fun askNumber(){
}

fun printWinner(){

}