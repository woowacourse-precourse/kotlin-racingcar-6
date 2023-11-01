package racingcar


class Car(val name: String) {
    var position = 0

    fun move(randomNumber:Int) {
        if (randomNumber>=4){
            position += 1
        }

    }

    fun getOutput():String = "$name : ${"-".repeat(position)}\n"

    override fun toString() = "$name"
}


//class Car {
//    var count = 0
//    lateinit var name:String
//    fun move(number: Int) {
//        if (number >= 4) {
//            count += 1
//        }
//    }
//
//    fun getOutput():String = "$name : ${"-".repeat(count)}\n"
//
//
//    override fun toString() = "$name"
//}