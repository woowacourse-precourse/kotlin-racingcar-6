package racingcar

import Cars

class RacingManager {
    private val cars= Cars().makeCar()
    fun startGame(){
        val ranNum = RandomNumCreator()
        val inputManager = InputManager()
        for (index in 1..inputManager.readRepeatNum()){
            for (car in cars) {
                car.move(ranNum.creator()) // 0부터 9까지의 무작위 숫자 전달
            }
            println()
        }
    }
}