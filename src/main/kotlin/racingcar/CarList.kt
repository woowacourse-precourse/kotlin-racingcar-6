data class CarList(private var cars : MutableList<Car>, private var count : Int){


    fun setCount(count: Int){
        this.count = count
    }

    fun getCars() : MutableList<Car>{
        return cars
    }

    fun addCar(name : String){
        cars.add(Car(name,0,""))
    }

    fun carSimul(){

        for (i in 0..< count) {

            execute()

            Print.printCarState()

            println()//한줄 내리기

        }

        println()

    }

    private fun execute(){

        for(car in cars){

            if(NumCheck.randomCheck()){
                forward(car)
            }

        }

    }






}