package racingcar
import camp.nextstep.edu.missionutils.Console
class Game {
    private var carList: MutableList<Car> = mutableListOf()
    private var maxStep: Int
    private var currentStep: Int = 0
    init {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val names = Console.readLine()
//        println(names)
        val nameList = names.split(Regex(",\\s*"))
        for (name in nameList) {
            // 예외상황은 Car 생성시 체크 추가
            carList.add(Car(name))
        }

        println("시도할 횟수는 몇 회인가요?")
        val moves = Console.readLine()
//        println(moves)
        try {
            maxStep = moves.toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException("non-digit was input")
        }
    }
    private fun isEnd(): Boolean {
        return maxStep == currentStep
    }
    private fun findWinner(): List<String>{
        var maxPos = 0
        var winners: MutableList<String> = mutableListOf()
        for(car in carList) {
            if(maxPos < car.getPos()) {
                maxPos = car.getPos()
                winners = mutableListOf(car.getName())
            }
            else if(maxPos == car.getPos()) {
                winners.add(car.getName())
            }

        }
        return winners
    }
    fun run() {
        println("\n실행 결과")
        while(!isEnd()) {
            for(car in carList){
                // Car class의 move호출시 랜덤값에 따라 전진하는 코드 추가
                car.move()
                car.printCar()
            }
            println()
            currentStep += 1
        }
        val winners = findWinner()
        println("최종 우승자 : "+winners.joinToString(", "))
    }

}