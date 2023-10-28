package racingcar.domain

import javax.swing.text.html.HTML.Attribute.N

class Car(name: String) {
    val name = name
    private var distance = 0

    fun move() {
        val numberGenerator = NumberGenerator()
        if(numberGenerator.createRandomNumber()>=4){
            distance++
        }
    }
    fun getName():String{
        return name
    }
    fun getDistance():Int{
        return distance
    }

    fun printResult(){
        print("$name : ")
        for (i in 1..distance)
            print("-")
        println()
    }
}