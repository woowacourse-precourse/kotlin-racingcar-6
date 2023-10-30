package car

import caroption.DashBoard
import caroption.Engine

object CarFactory {
    fun makeCar(name: String) = Car(Engine(), DashBoard(name))
}
