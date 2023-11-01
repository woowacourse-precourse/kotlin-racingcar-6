package racingcar

 class Move(private val cars: MutableList<Car>) {
     //val cars: MutableList<Car>

    val randomNumber = RandomNumber()
    //val randomNum = randomNumber.createRandomNumber() //랜덤수 생성

    fun moveCar() {
        for (car in this.cars) {
            val randomNum = randomNumber.createRandomNumber()
            if (randomNum >= 4) {
                car.forward()
            }
            println("${car.name} : ${"-".repeat(car.distance)}")
            //println(randomNum)
        }
        println()
    }

}