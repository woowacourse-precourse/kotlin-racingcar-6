package car

import InputValue.CAR_DELIMITER
import caroption.DashBoard
import caroption.Engine

object CarFactory {
    fun makeCar(input: String): List<Car> {
        val carList = mutableListOf<Car>()
        input.split(CAR_DELIMITER).forEach { name ->
            carList.add(Car(Engine(), DashBoard(name)))
        }
        return carList
    }
}
