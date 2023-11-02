package racingcar.model

data class Car(
	val name: String,
	var location: Int
) {
	fun move() {
		this.location++
	}
}