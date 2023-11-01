package racingcar.model

class Car(val name: Name, val position: Position): Comparable<Car> {
    fun doRace() {
        position.moveByRandom()
    }

    fun getCarNameString(): String {
        return name.getNameString()
    }

    fun getPositionNumber(): Int {
        return position.getPositionNumber()
    }

    override fun compareTo(other: Car): Int {
        return position.getPositionNumber() - other.position.getPositionNumber()
    }

    override fun equals(other: Any?): Boolean {
        other as Car
        return position.getPositionNumber() == other.position.getPositionNumber()
    }
}