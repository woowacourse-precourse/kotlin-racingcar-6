package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class RacingCarGame {
    private val carInput: String = Console.readLine()

    val numberOfTry: Int = Console.readLine().toInt()
    val carList: List<String> = carInput.split(',')
    private val gameProgressEmpty = emptyList<String>()
    private val gameProgress = gameProgressEmpty.toMutableList()

    private fun setProgress(){
        for(carName in carList){
            gameProgress.add("$carName: ")
        }
    }

    private fun isNameNotExceed5Letters() {
        for (carName in carList) {
            if (carName.length > 5) {
                throw IllegalArgumentException("이름은 5자 이하여야 합니다.")
            }
        }
    }
    private fun go(index: Int){
        gameProgress[index] = gameProgress[index].plus('-')
    }
    private fun goOrNot(){
        for (i in carList.indices) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (randomNumber >= 4) {
                go(i)
            }
        }
    }
    fun gameStart(){
        isNameNotExceed5Letters()
        setProgress()

        for (i in 0..< numberOfTry){
            goOrNot()
        }

        for (i in carList.indices) {
            println(gameProgress[i])
        }
    }
}
