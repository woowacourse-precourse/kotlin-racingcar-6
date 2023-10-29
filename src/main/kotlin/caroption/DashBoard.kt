package caroption

import car.CarConfiguration.DIST_SYMBOL
import car.CarConfiguration.INIT_DIST
import java.math.BigInteger

class DashBoard {
    private var dist = BigInteger.valueOf(INIT_DIST)
    fun distPlus() {
        dist++
    }

    fun nowDist() = dist

    fun printDist(dist: BigInteger) {
        var count = BigInteger.ZERO
        while(count < dist) {
            print(DIST_SYMBOL)
        }
    }
}
