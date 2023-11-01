package model

class CarList(val carList: List<Car>) {
    constructor(input: String) : this(input.split(",").mapIndexed { _, name -> Car(name.trim()) })

    fun move(index: Int, speed: Int) {
        carList[index].move(speed)
    }
}