package racingcar.domain

class Game() {


    fun start(cars: List<Car>?) {

        cars!!.forEach { car ->
            val randomNum = car.getRandoms()
            car.move(randomNum) }
        cars.forEach { car ->
            println(car.getResult())}

    }

}