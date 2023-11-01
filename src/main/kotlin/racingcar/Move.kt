package racingcar

class Move(private val cars: MutableList<Car>) {

    val randomNumber = RandomNumber()

    fun moveCar() {
        for (car in this.cars) {
            val randomNum = randomNumber.createRandomNumber()
            if (randomNum >= 4) {
                car.forward()
            }
            println("${car.name} : ${"-".repeat(car.distance)}")
        }
        println()
    }

    fun compareMoveNumber() {
        val maxDistance = cars.maxOf { it.distance }
        println(maxDistance)
        val sameDistance = cars.filter { maxDistance == it.distance }
        val winner = sameDistance.joinToString(",") { it.name }
        println("최종 우승자 : $winner")
    }
}