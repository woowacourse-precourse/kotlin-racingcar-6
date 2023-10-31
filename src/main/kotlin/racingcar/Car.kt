package racingcar

class Car(name : String) {
    private val name : String = name
    private var loc = 0

    fun move(){
        loc++
    }

    fun getName() = name

    fun getLocation() = loc

    fun displayLocation() {
        print("$name : ")
        repeat(loc){
            print("-")
        }
        println()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Car) return false
        return name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}