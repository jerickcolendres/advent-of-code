import java.io.File

fun main() {
    val lines = File("src/main/resources/input-day3.txt").readLines()
    var treeCount = 0
    var pos = 0;
    for ((index, value) in lines.iterator().withIndex()) {
        if (index > 0 && pos < value.length && value[pos] == '#')
            treeCount++
        if (pos >= value.length)
            pos = 0
        pos += 3
    }
    println("Total number of tree is $treeCount")
}
