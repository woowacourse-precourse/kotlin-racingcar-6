import java.math.BigInteger

object Racing {
    fun racingSetting(carList: List<Car>, round: BigInteger) {
        var count = BigInteger.ZERO
        println("실행 결과")
        while (count < round) {
            racingStart(carList)
            count++
        }
    }

    private fun racingStart(carList: List<Car>) {
        for(car in carList){
            if(car.isGo()){
                car.lengthPlus()
            }
            car.printName()
            car.printLength()
        }
        println()
    }
}
