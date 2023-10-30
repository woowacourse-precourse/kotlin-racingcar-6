package racingcar.model

class Car(name: String) {
    private val carName: String
    private var forwardCount: Int

    init{
        this.carName = name
        this.forwardCount = 0
    }

    fun getCarName(): String {
        return carName
    }

    fun getForwardCount(): Int {
        return forwardCount
    }

    fun increaseForwardCount(){
        this.forwardCount++
    }
}