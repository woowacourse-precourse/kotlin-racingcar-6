package racingcar

data class Cars(var name: String, var go: Int)

class Car {
    fun makeCars(): Array<Cars?> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        var carname = readLine()  // TODO 잘못 입력 받았을 경우 throw문 구현
        var carNameList = carname?.split(",")
        var carCnt = carNameList!!.size  // 차의 개수

        var carList = Array<Cars?>(carCnt) { null }  // Cars 클래스가 들어갈 배열 생성
        for (i in 0 until carCnt) {
            val cars = Cars(carNameList[i], 0)  // 차 이름, 전진 횟수 초기화
            carList[i] = cars
            //println("${i + 1}번째 차: ${carList[i]!!.name}")
        }

        return carList
    }
}