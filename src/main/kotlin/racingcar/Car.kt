package racingcar

class Car(
    val name: String,
    var cntForwards: Int = 0
) {
    override fun toString(): String {
        val dashes = "-".repeat(cntForwards)
        return "$name : $dashes"
    }
}