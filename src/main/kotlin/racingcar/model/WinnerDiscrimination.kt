package racingcar.model

class WinnerDiscrimination {
    fun answer(scoreBoard: List<String>, cars: List<String>): MutableList<String> {
        var max = 0
        var winnerIndices = mutableListOf<Int>()
        var winnerCars = mutableListOf<String>()

        for ((index, score) in scoreBoard.withIndex()) {
            if (score.length > max) {
                max = score.length
                winnerIndices = mutableListOf(index)
            } else if (score.length == max) {
                winnerIndices.add(index)
            }
        }

        for (selectedIndex in winnerIndices) {
            winnerCars.add(cars[selectedIndex])
        }

        return winnerCars
    }
}