package racingcar

class Car(
    val name: String,
    var cntForwards: Int = 0
) : Comparable<Car> {
    override fun toString(): String {
        val dashes = "-".repeat(cntForwards)
        return "$name : $dashes"
    }

    override fun compareTo(other: Car): Int {
        return other.cntForwards - this.cntForwards
    }
}