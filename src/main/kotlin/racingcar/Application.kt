package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    gameStart()
}
fun gameStart(){
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carName = Console.readLine()
    val cars = carName.split(',')
    checkName(cars)

    println("시도할 횟수는 몇 회인가요?")
    val repeat = Console.readLine()
    checkNum(repeat)
}
fun checkNum(repeat: String) {
    when(repeat.toIntOrNull()){
        null -> throw IllegalArgumentException("숫자가 아니거나 null값입니다.")
        else -> true
    }
}
fun checkName(cars: List<String>) {
    for(i in cars.indices){
        checkError(cars[i])
    }
}
fun checkError(input: String) {
    if(input.length>5 || input.length<0){
        throw IllegalArgumentException("이름이 5자가 넘어가거나 값이 없습니다.")
    }
    if(input.contains(" ")){
        throw IllegalArgumentException(",뒤에 공백이 있습니다.")
    }

}