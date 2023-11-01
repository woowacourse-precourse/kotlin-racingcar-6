package model

class CarList(val cars: List<Car>) {
    constructor(input: String) : this(input.split(",").mapIndexed { _, name -> Car(name.trim()) })

    fun move(index: Int, speed: Int) {
        cars[index].move(speed)
    }
}