package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val cars = getCarList()
    
}

fun getCarList() = Console.readLine().split(",")