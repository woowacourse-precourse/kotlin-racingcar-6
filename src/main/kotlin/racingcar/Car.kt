package racingcar

class Car {
    private lateinit var name:String
    private var distance = 0

    constructor(name:String){
        this.name = name
    }

    fun getName():String{
        return name
    }
}