package racingcar

import camp.nextstep.edu.missionutils.Console
import org.mockito.internal.matchers.Null

class Racing {
    fun startRacing(){

    }
    private fun registerCar(){
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carCollection=CarCollection()
        val registerCarNames = Console.readLine()
        val registerCarNamesList=registerCarNames.split(",")
        for (name in registerCarNamesList){
            val carName=CarName(name)
            val car = Car(carName)
            carCollection.putCar(car)
        }
    }
    fun setRacingNum(){
        println("시도할 횟수는 몇 회인가요?")
        val getRacingNum=Console.readLine()
        val intRacingNum=RacingNum(getRacingNum.toInt())
    }
    fun showRacingResult(){

    }
    fun showRacingWinner(){

    }
}