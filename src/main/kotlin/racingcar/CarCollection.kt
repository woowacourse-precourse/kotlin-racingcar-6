package racingcar

class CarCollection {
    private val carList:MutableList<Car> = mutableListOf()
    private val winnerList:MutableList<Car> = mutableListOf()
    fun putCar(car:Car){
        carList.add(car)
    }
    fun moveCars(){
        for(car in carList){
            car.moveCar()
        }
    }
    fun showResults(){
        for(car in carList){
            car.showResult()
        }
        println()
    }
    fun checkWinner(car1:Car,car2:Car){
        if(car1.location<car2.location){
            winnerList.clear()
            winnerList.add(car2)
        }else if(car1.location==car2.location){
            winnerList.add(car2)
        }
    }
    fun getWinner():MutableList<Car>{
        winnerList.add(carList[0])
        for(i:Int in 1..(carList.size-1)){
            checkWinner(winnerList[0],carList[i])
        }
        return winnerList
    }
}