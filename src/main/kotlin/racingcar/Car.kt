package racingcar

data class Cars(var name: String, var go: Int)

class Car {
    fun makeCars() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        var carname = readLine()  // TODO 잘못 입력 받았을 경우 throw문 구현
        var carNameList = carname?.split(",")

        //val theNumberOfCar = carNameList?.size!!  // 이름의 개수가 자동차의 개수
        /*
        //println(carNameList) ok
        //println(theNumberOfCars)
        val cars = Array<Cars?>(theNumberOfCar) { null }
        for (i in 0 until theNumberOfCar) {
            cars[i]?.name = carNameList[i]
        }
         */
    }
}