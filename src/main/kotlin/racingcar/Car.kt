package racingcar

class Car {
    fun makeCars() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        var carname = readLine()
        var cars = carname?.split(",")
        //println(cars)
    }


}