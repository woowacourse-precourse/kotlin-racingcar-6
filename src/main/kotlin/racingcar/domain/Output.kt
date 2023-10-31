package racingcar.domain

class Output(private val cars: Cars) {

    fun printState() {
        val carStateList = cars.getAdvanceStateList()
        cars.carList.forEachIndexed { index, car ->
            println("${car.name} : ${"-".repeat(carStateList[index])}")
        }
    }

    fun printResult() {
        val maxState = cars.getAdvanceStateList().max()
        val winnerList = cars.carList.filter { it.advanceState == maxState }.map { it.name }

        print("최종 우승자 : ${winnerList.joinToString(", ")}")
    }

}