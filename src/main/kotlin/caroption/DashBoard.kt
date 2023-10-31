package caroption

import car.CarConfiguration.DIST_SYMBOL
import car.CarConfiguration.INIT_DIST
import race.RacingSystemValues.CAR_DIST_SEPARATOR
import java.math.BigInteger

class DashBoard(private val carName: String) {
    private var dist = BigInteger(INIT_DIST)
    fun distPlus() {
        dist++
    }

    fun distInfo(): StringBuilder {
        val distInput = StringBuilder()
        distInput.append("${carName}$CAR_DIST_SEPARATOR")
        var count = BigInteger(INIT_DIST)
        while (count < dist) {
            distInput.append(DIST_SYMBOL)
            count++
        }
        distInput.appendLine()
        return distInput
    }

    fun carName() = carName

    fun nowDist() = dist
}
