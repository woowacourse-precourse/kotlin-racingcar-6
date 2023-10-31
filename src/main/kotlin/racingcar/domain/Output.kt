package racingcar.domain

class Output(private val cars: Cars) {

    fun printState() {
        val carStateList = cars.getAdvanceStateList()
        cars.carList.forEachIndexed { index, car ->
            println("${car.name} : ${"-".repeat(carStateList[index])}")
        }
    }


}