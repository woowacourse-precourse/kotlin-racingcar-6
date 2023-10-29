package racingcar.model

class Car(name: String) {
    private val carName: String
    private var forwardCount: Int

    init{
        this.carName = name
        this.forwardCount = 0
    }

    private fun increaseForwardCount(){
        this.forwardCount++
    }

    public fun getCarName(): String {
        return carName
    }

    public fun getForwardCount(): String {
        return carName
    }
}