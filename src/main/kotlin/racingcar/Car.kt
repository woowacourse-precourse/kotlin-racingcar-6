package racingcar

class Car {
    var count = 0
    lateinit var name:String
    fun move(number: Int) {
        if (number >= 4) {
            count += 1
        }
    }

    fun isValid(){
        if (name.length > 5 || name.isEmpty()){
            throw IllegalArgumentException()
        }
    }

    fun getOutput():String = "$name : ${"-".repeat(count)}\n"


    override fun toString() = "$name"
}