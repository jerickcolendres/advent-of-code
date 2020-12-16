import java.io.File

fun main() {
    val lines = File("src/main/resources/input-day13.txt").readLines()
    val departsAt = lines[0].toInt()
    val busList = lines[1].split(",")
    var timeStamp = 0
    var busArrived = false
    while(!busArrived) {
        timeStamp++
        busList.filter {it != "x" }.forEach {
            val bus = it.toInt()
            if (timeStamp > departsAt && timeStamp % bus == 0) {
                busArrived = true
                println("Bus #$bus arrived at $timeStamp")
                val waitingTime = timeStamp - departsAt
                println("Earliest waiting time is $waitingTime")
                println("Result = " + bus * waitingTime)
            }
        }
    }
}
