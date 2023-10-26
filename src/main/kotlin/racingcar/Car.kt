package racingcar

class Car(
    val name: String,
    var cntForwards: Int = 4
) {
    override fun toString(): String {
        val dashes = "-".repeat(cntForwards)
        return "$name : $dashes"
    }
}