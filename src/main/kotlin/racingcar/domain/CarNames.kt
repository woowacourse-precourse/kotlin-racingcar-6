package racingcar.domain

import racingcar.utils.InputChecker

class CarNames(
    private val inputChecker: InputChecker,
    private var nameList: List<String> = emptyList()
) {
    fun inputCarNames(input: String): List<String> {
        nameList = inputChecker.checkInputNames(input).split(",")

        return nameList
    }

    fun getNameList(): List<String> = nameList
}