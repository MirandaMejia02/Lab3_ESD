import kotlin.system.measureTimeMillis

fun main() {
    while (true) {
        println("Seleccione una opción:")
        println("1. Ordenar una lista usando Bubble Sort")
        println("2. Ordenar una lista usando Quick Sort")
        println("3. Calcular el factorial de un número")
        println("4. Resolver las Torres de Hanói")
        println("5. Salir")

        when (readLine()?.toIntOrNull()) {
            1 -> bubbleSortOption()
            2 -> quickSortOption()
            3 -> factorialOption()
            4 -> hanoiOption()
            5 -> {
                println("Saliendo del programa...")
                break
            }
            else -> println("Por favor, seleccione una opción válida.")
        }
    }
}

// Bubble Sort
fun bubbleSort(arr: IntArray): IntArray {
    val n = arr.size
    for (i in 0 until n - 1) {
        for (j in 0 until n - i - 1) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
    return arr
}

fun bubbleSortOption() {
    println("Ingrese una lista de números separados por comas:")
    val input = readLine()
    val numbers = input?.split(",")?.mapNotNull { it.trim().toIntOrNull() }?.toIntArray()
    if (numbers != null) {
        val time = measureTimeMillis {
            val sorted = bubbleSort(numbers)
            println("Lista ordenada usando Bubble Sort: ${sorted.joinToString(", ")}")
        }
        println("Tiempo de ejecución: $time ms")
    } else {
        println("Entrada no válida.")
    }
}

// Quick Sort
fun quickSort(arr: IntArray, low: Int, high: Int) {
    if (low < high) {
        val pi = partition(arr, low, high)
        quickSort(arr, low, pi - 1)
        quickSort(arr, pi + 1, high)
    }
}

fun partition(arr: IntArray, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1
    for (j in low until high) {
        if (arr[j] < pivot) {
            i++
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
    }
    val temp = arr[i + 1]
    arr[i + 1] = arr[high]
    arr[high] = temp
    return i + 1
}

fun quickSortOption() {
    println("Ingrese una lista de números separados por comas:")
    val input = readLine()
    val numbers = input?.split(",")?.mapNotNull { it.trim().toIntOrNull() }?.toIntArray()
    if (numbers != null) {
        val time = measureTimeMillis {
            quickSort(numbers, 0, numbers.size - 1)
            println("Lista ordenada usando Quick Sort: ${numbers.joinToString(", ")}")
        }
        println("Tiempo de ejecución: $time ms")
    } else {
        println("Entrada no válida.")
    }
}

// Factorial
fun factorial(n: Int): Int {
    return if (n == 0) 1 else n * factorial(n - 1)
}

fun factorialOption() {
    println("Ingrese un número entero positivo:")
    val input = readLine()?.toIntOrNull()
    if (input != null && input >= 0) {
        val result = factorial(input)
        println("El factorial de $input es: $result")
    } else {
        println("Entrada no válida. Por favor, ingrese un número entero positivo.")
    }
}

// Torres de Hanói
fun hanoi(n: Int, source: String, target: String, auxiliary: String) {
    if (n == 1) {
        println("Mover disco 1 de $source a $target")
        return
    }
    hanoi(n - 1, source, auxiliary, target)
    println("Mover disco $n de $source a $target")
    hanoi(n - 1, auxiliary, target, source)
}

fun hanoiOption() {
    println("Ingrese el número de discos:")
    val input = readLine()?.toIntOrNull()
    if (input != null && input > 0) {
        hanoi(input, "A", "C", "B")
    } else {
        println("Entrada no válida. Por favor, ingrese un número entero positivo.")
    }
}
