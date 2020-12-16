import java.io.File

fun main() {
    var validPasswordCount = 0
    val lines = File("src/main/resources/input-day2.txt").readLines()
    for (line in lines) {
        val regex = "(\\d+)-(\\d+) (\\w): (\\w+)*".toRegex()
        val match = regex.find(line)
        if (match != null) {
            val (min, max, letter, password) = match.destructured
            val count = password.count{ c -> c == letter[0] }
            if (count in min.toInt()..max.toInt()) validPasswordCount++
        }
    }
    println("Total valid password is $validPasswordCount")
}
