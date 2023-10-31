package racingcar

import java.lang.IllegalArgumentException

fun main() {

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n")
    val carNames =  readLine()
    var carArray  = carNames?.split(",")

    if (carArray != null) {
        checkNames(carArray)
    }





}



fun checkNames(carList : List<String>){
    carList.forEach {  car ->
        if(car.length > 5) throw IllegalArgumentException("자동차 이름은 5자리 이하여야 합니다.")
    }
}
