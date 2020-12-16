import java.io.File

fun main() {
    val lines = File("src/main/resources/input-day1.txt").readLines()
    outerLoop@ for (x in lines) {
        for (y in lines) {
            for (z in lines) {
                val num1 = x.toInt()
                val num2 = y.toInt()
                val num3 = z.toInt()
                if (num1 + num2 + num3 == 2020) {
                    println("$num1 * $num2 * $num3= " + num1 * num2 * num3)
                    break@outerLoop
                }
            }
        }
    }
}
