package racingcar

//class Car(name:String) {
//    var position:Int = 0
//
//    fun move(){
//
//    }
//}
class Car {
    var count = 0
    lateinit var name:String
    fun move(number: Int) {
        if (number >= 4) {
            count += number
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