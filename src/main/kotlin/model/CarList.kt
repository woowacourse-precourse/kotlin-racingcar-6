package model

class CarList(val cars: List<Car>) {
    constructor(input: String) : this(input.split(",").mapIndexed { _, name -> Car(name.trim()) })
}