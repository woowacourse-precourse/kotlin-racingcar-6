package racingcar
import camp.nextstep.edu.missionutils.Console
class Game {
    var carList: MutableList<Car> = mutableListOf()
    var tryMove: Int
    var currentStep: Int = 0
    init {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val names = Console.readLine()
        val nameList = names.split(Regex(",\\s*"))
        for (name in nameList) {
            // 예외상황은 Car 생성시 체크 추가
            carList.add(Car(name))
        }

        val moves = Console.readLine()
        try {
            tryMove = moves.toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException("non-digit was input")
        }
    }
}