package racingcar

import camp.nextstep.edu.missionutils.Console

class Racing {
    val carCollection=CarCollection()
    fun startRacing(){
        registerCar()
        moveRacingCar()
        showRacingWinner()
    }
    private fun registerCar(){
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val registerCarNames = Console.readLine()
        val registerCarNamesList=registerCarNames.split(",")
        for (name in registerCarNamesList){
            val carName=CarName(name)
            val car = Car(carName)
            carCollection.putCar(car)
        }
    }
    private fun setRacingNum():RacingNum{
        println("시도할 횟수는 몇 회인가요?")
        val getRacingNum=Console.readLine()
        val racingNum=RacingNum(getRacingNum.toInt())
        return racingNum
    }
    private fun moveRacingCar(){
        val racingNum=setRacingNum()
        println()
        println("실행 결과")
        for (i:Int in 0..racingNum.amount()){
            carCollection.moveCars()
            showRacingResult()
        }
    }
    private fun showRacingResult(){
        carCollection.showResults()
    }
    private fun showRacingWinner(){
        val winnerList=carCollection.getWinner()
        print("최종 우승자 : ")
        for (i:Int in 0..(winnerList.size-1)){
            val winnerName=winnerList[i].name
            if((winnerList.size-1)==i){
                print(winnerName.amount())
            }else if((winnerList.size-1)!=i){
                print("${winnerName.amount()}, ")
            }
        }
        println()
    }
}