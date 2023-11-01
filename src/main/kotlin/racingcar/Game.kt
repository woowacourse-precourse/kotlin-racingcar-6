package racingcar

import camp.nextstep.edu.missionutils.Console

class Game {
    private lateinit var carList: List<Car>
    private var tryNumber: Int = 0

    private enum class ProgressMessage(val message: String) {
        RequestCarName("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        RequestTryNumber("시도할 횟수는 몇 회인가요?"),
        DescribeNextResult("\n실행결과");

        fun show() {
            println(this.message)
        }
    }

    fun run() {
        ProgressMessage.RequestCarName.show()
        getCarList()

        ProgressMessage.RequestTryNumber.show()
        getTryNumber()

        ProgressMessage.DescribeNextResult.show()
        startRace()
        showWinnerList()
    }

    private fun initCarList(inputCarList: List<Car>) {
        this.carList = inputCarList
    }

    private fun initTryNumber(inputNumber: Int) {
        this.tryNumber = inputNumber
    }

    private fun getCarList() {
        val carList = Console.readLine().split(",")
        verifyCarList(carList)
        initCarList(carList.map { Car(it) })
    }

    private fun getTryNumber() {
        val tryNumber = Console.readLine()
        verifyTryNumber(tryNumber)
        initTryNumber(tryNumber.toInt())
    }

    private fun startRace() {
        repeat(tryNumber) {
            carList.forEach {
                it.tryToMoveForward()
                it.showResult()
            }
            print("\n")
        }
    }

    private fun makeWinnerList(): List<String> {
        var winnerList = mutableListOf<String>()
        var winnerLocation = 0

        for (car in carList) {
            var carLocation = car.getLocation()
            if (carLocation > winnerLocation) {
                winnerLocation = carLocation
                winnerList = mutableListOf()
                winnerList.add(car.getName())
            } else if (carLocation == winnerLocation) {
                winnerList.add(car.getName())
            }
        }

        return winnerList
    }

    private fun showWinnerList() {
        var winnerList = makeWinnerList()
        println("최종 우승자 : ${winnerList.joinToString(", ")}")
    }
}