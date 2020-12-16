import java.io.File

fun main() {
    val lines = File("src/main/resources/input-day14.txt").readLines()
    var currentMask = ""
    var memoryMap: MutableMap<Long, Long> = mutableMapOf()
    for (line in lines) {
        if (line.contains("mask")) {
            // Extract mask value and set current mask
            val maskMatch = Regex("mask = ([10X].*)$").find(line)
            if (maskMatch != null) {
                val (value) = maskMatch.destructured
                currentMask = value
                println("Current mask = $currentMask")
            }
        } else {
            val memMatch = Regex("mem\\[(\\d+)\\] = (\\d+)").find(line)
            if (memMatch != null) {
                val (address, value) = memMatch.destructured
                val currentAddress = address.toLong()
                val currentValue = value.toLong()
                println("Current value = $currentValue")
                // Convert address to binary string
                val addressInBinary = Integer.toBinaryString(currentAddress.toInt())
                // Apply mask to get the floating mask

                val onMask = currentMask.replace("X", "0").toLong(2)
                val offMask = currentMask.replace("X", "1").toLong(2)

                var maskedValue = currentValue or onMask and offMask
                memoryMap[currentAddress] = maskedValue
            }
        }
    }
    // Sum all the values in the memory map
    val sum = memoryMap.values.toList().sum()
    println("Result is $sum")
}
