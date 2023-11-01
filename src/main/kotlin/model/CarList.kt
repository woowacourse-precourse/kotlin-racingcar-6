package model

class CarList(val carList: List<Car>) {
    constructor(input: String) : this(input.split(",").mapIndexed { _, name -> Car(name.trim()) })

    fun move(index: Int, speed: Int) {
        carList[index].move(speed)
    }

    fun findWinnerList(carList: CarList): String {
        val maxPosition: Int = carList.carList.maxOf { it.position }
        return carList.carList.filter { it.position == maxPosition }.joinToString(separator = ", ") { it.name }
    }
}