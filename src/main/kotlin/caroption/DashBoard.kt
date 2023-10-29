package caroption

import car.CarConfiguration.DIST_SYMBOL
import car.CarConfiguration.INIT_DIST
import race.RacingSystemValues.CAR_DIST_SEPARATOR
import java.math.BigInteger

class DashBoard {
    private var dist = BigInteger(INIT_DIST)
    fun distPlus() {
        dist++
    }

    fun nowDist() = dist

    fun printDist(name: String, dist: BigInteger) {
        print("${name}$CAR_DIST_SEPARATOR")
        var count = BigInteger(INIT_DIST)
        while (count < dist) {
            print(DIST_SYMBOL)
            count++
        }
        println()
    }
}
