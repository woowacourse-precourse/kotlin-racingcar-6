package racingcar

import camp.nextstep.edu.missionutils.Randoms

class GameStatus {
    private var listOfCar = mutableListOf<Car>()
    private var countOfTrial: Int = 0

    fun getCountOfTrial(): Int {
        return countOfTrial
    }
    fun initStatus(listOfNames: List<String>, count: Int) {
        addListOfCar(listOfNames)
        countOfTrial = count
    }
    private fun addListOfCar(listOfNames: List<String>) {
        for (name in listOfNames) {
            val newCar = Car(name, INITIAL_CAR_MOVEMENT_COUNT)
            listOfCar.add(newCar)
        }
    }
    fun raceAllCarInList() {
        for (i in 0 until listOfCar.size) {
            forwardCar(i)
        }
    }
    private fun forwardCar(idx: Int) {
        val randomNumber = Randoms.pickNumberInRange(0,9)
        if (randomNumber >= 4) {
            listOfCar[idx].movementCount += 1
        }
    }
    fun printCurrentCarMovement() {
        for (i in 0 until listOfCar.size) {
            val currentCar = listOfCar[i]
            print("${currentCar.name} : ")
            println("-".repeat(currentCar.movementCount))
        }
        println()
    }
    fun printBeatPlayer() {
        val bestPlayers = chooseBestPlayer()
        val playerNameList = mutableListOf<String>()
        for (player in bestPlayers)
            playerNameList.add(player.name)
        println(playerNameList.joinToString())
    }
    private fun chooseBestPlayer(): List<Car> {
        val sortedList = listOfCar.sortedByDescending { it.movementCount }
        val maximumOfMovement = sortedList[0].movementCount
        return sortedList.filter { it.movementCount == maximumOfMovement }
    }
}