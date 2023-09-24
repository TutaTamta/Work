fun main(args: Array<String>) {

    print("Введите кол-во рёбер: ")
    val edges: String = readln()
    print("Введите кол-во вершин: ")
    val nodes: String = readln()
    var a: String?
    var b: String?

    val grafs = mutableMapOf<Int, List<Int>>()

        for (i in 1..edges.toInt()) {
            println("Введите пары вершин по отдельности: ")
            println("e${i}: ")
            a = readln()
            b = readln()
            //val listOfNodes: List<Int> = listOf(a.toInt(), b.toInt())
            grafs.put(i, listOf(a.toInt(), b.toInt()))
        }

    println("Какой граф?")
    println("1: неориентированный")
    println("2: ориентированный")


    val switch: String = readln()

    when (switch.toString()) {
        "1" -> {
            println("Список смежности")
            println("-------------------------------------------")
            for (i in 1..nodes.toInt()) {
                var filtredGrafs = grafs.filter {it.value.contains(i)}
                print("v${i}:\t")
                for ((key, value) in filtredGrafs) {
                    if (value[0] == i) print("v${value[1]}\t")
                    else print("v${value[0]}\t")
                }
                println()
                println()
            }

/////////////////////////////////////////////////////////////////////////////////////////

            println("Матрица смежности")
            println("-------------------------------------------")
            for(i in 1..nodes.toInt()) {
                print("v${i}:\t")
                for (j in 1..nodes.toInt()) {
                    run loop@ {
                        grafs.forEach{
                            if ((it.value == listOf(i, j)) || (it.value == listOf(j, i))) {
                                print("1\t")
                                return@loop
                            }
                        }
                        print("0\t")
                    }
                }

                println()
                println()
            }

//////////////////////////////////////////////////////////////////////////////////////////////////
            println("Матрица индентичности")
            println("-------------------------------------------")
            for (i in 1..nodes.toInt()){
                print("v${i}:\t")
                for ((key, value) in grafs) {
                    if (value[0] == i || value[1] == i) print("1\t")
                    else print("0\t")
                }
                println()
            }
        }
        "2" -> {
            println("Список смежности")
            println("-------------------------------------------")
            for (i in 1..nodes.toInt()) {
                var filtredGrafs = grafs.filter {it.value.contains(i)}
                print("v${i}:\t")
                for ((key, value) in filtredGrafs) {
                    if (value[0] == i) print("v${value[1]}\t")
                }
                println()
                println()
            }
////////////////////////////////////////////////////////////////////////////////

            println("Матрица смежности")
            println("-------------------------------------------")
            for(i in 1..nodes.toInt()) {
                print("v${i}:\t")
                for (j in 1..nodes.toInt()) {
                    run loop@ {
                        grafs.forEach{
                            if (it.value == listOf(i, j)) {
                                print("1\t")
                                return@loop
                            }
                        }
                        print("0\t")
                    }
                }

                println()
                println()
            }
////////////////////////////////////////////////////////////

            println("Матрица индентичности")
            println("-------------------------------------------")
            for (i in 1..nodes.toInt()){
                print("v${i}:\t")
                for ((key, value) in grafs) {
                    if ((value[0] == i) && (value[1] == i)) print("1\t")
                    if ((value[0] == i) && (value[1] != i)) print("1\t")
                    if ((value[1] == i) && (value[0] != i)) print("-1\t")
                    if ((value[0] != i) && (value[1] != i)) print("0\t")
                }
                println()
            }
        }
    }
}

