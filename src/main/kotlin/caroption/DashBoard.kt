package caroption

import CarConfiguration.DIST_SYMBOL
import CarConfiguration.INIT_DIST

class DashBoard {
    private var dist = INIT_DIST
    fun distPlus() {
        dist++
    }
    fun nowDist() = dist

    fun printDist() {
        print(DIST_SYMBOL)
    }
}