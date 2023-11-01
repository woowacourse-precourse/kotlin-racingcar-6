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
            count += 1
        }
    }

    fun getOutput():String = "$name : ${"-".repeat(count)}\n"


    override fun toString() = "$name"
}