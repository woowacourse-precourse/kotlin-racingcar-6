package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingCarValidator {
    fun validateCarName(checkName: String) {
        if(checkName.isEmpty() || checkName.length > 5) {
            throw IllegalArgumentException()
        }
    }
    fun checkCars(cars:String):List<String>{
        val racingCars = cars.split(',')
        for(racingCar in racingCars){
            RacingCarValidator().validateCarName(racingCar)
        }
        return racingCars
    }
    fun checkTrying(tries:String):Int{
        if (tries.isBlank()) {
            throw IllegalArgumentException()
        }
        try{
            return tries.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException()
        }
    }
    companion object {
        val instance = RacingCarValidator()
    }
}
fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분")
    val cars = Console.readLine()
    val racingCars = RacingCarValidator.instance.checkCars(cars)
    println("시도 할 횟수는 몇 회인가요?")
    val trying = Console.readLine()
    val tryTimes = RacingCarValidator.instance.checkTrying(trying)
    RacingGames().checkTime(racingCars, tryTimes)
}
