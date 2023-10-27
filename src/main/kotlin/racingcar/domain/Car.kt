package racingcar.domain

class Car (index : Int, name:String){
    val index = index
    val name = name
    var distance = 0

    fun move(){
    }

    fun getName(): String{
        return name
    }
}