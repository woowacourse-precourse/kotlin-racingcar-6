package racingcar.model

class Winners (winnersList: MutableList<Car>){
    var winners: MutableList<Car> = mutableListOf()

    init {
        this.winners = winnersList
    }
}