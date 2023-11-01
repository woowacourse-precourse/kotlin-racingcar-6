package racingcar

class GameManager(
    val nameList: List<String>,
    val tryCount: Int,
    var carsList: MutableList<Car>
) {
    constructor(nameList: List<String>, tryCount: Int) : this(nameList, tryCount, mutableListOf()) {
        createCarList(nameList)
    }

    private fun createCarList(nameList: List<String>) {
        for (name in nameList) {
            this.carsList.add(Car(name, ""))
        }
    }

    fun raceStart() {
        println("실행 결과")
        for (round in 0 until tryCount) {
            oneRoundResult()
        }
        // 최종 우승 차량을 출력
        // printWinners()
    }

    private fun oneRoundResult() {
        for (car in this.carsList) {
            car.chooseGoOrStop()
            car.howFarHaveGone()
        }
        println()
    }

    private fun printWinners() {
        // 우승자를 찾아내어야 함
        println("최종 우승자 : ")
    }
}