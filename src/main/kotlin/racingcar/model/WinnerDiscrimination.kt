package racingcar.model

class WinnerDiscrimination {
    fun answer(scoreBoard: List<Int>, cars: List<String>): MutableList<String> {
        var max = 0
        var winnerIndices = mutableListOf<Int>()
        var winnerCars = mutableListOf<String>()

        for ((index, score) in scoreBoard.withIndex()) {
            if (score > max) {
                max = score
                winnerIndices = mutableListOf(index)
            } else if (score == max) {
                winnerIndices.add(index)
            }
        }


        for (selectedIndex in winnerIndices) {
            winnerCars.add(cars[selectedIndex])
        }

        return winnerCars
    }
}