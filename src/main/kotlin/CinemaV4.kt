var rows = 0
var seat = 0
var hall = mutableListOf<MutableList<Char>>()
var exit = true
var soldPlace = 0
var monney = 0
var percentage = 0.0



fun main() {
    println("Enter the number of rows:")
    rows = readln().toInt()
    println("Enter the number of seats in each row:")
    seat = readln().toInt()

    hall = MutableList(rows) { MutableList(seat) { 'S' } }


    while (exit) {
        info()
        val choicePersone = readln().toInt()

        when (choicePersone) {
            1 -> {
                showSeats(rows, seat)

            }

            2 -> {
                var order = true
                while (order) {
                    println("Enter a row number:")
                    val currentRow = readln().toInt()
                    println("Enter a seat number in that row:")
                    val currentSeat = readln().toInt()
                    val cost: Int
                    if (rows * seat <= 60) cost = 10
                    else if (currentRow * 2 >= rows) cost = 8
                    else cost = 10
                    try {
                        if (hall[currentRow - 1][currentSeat - 1] == 'B') {
                            println("That ticket has already been purchased!")
                        } else {
                            hall[currentRow - 1][currentSeat - 1] = 'B'
                            print("Ticket price:")
                            println("$$cost")
                            monney += cost
                            soldPlace+=1
                            order = false
                        }
                    } catch (e: Exception) {
                        println("Wrong input!")
                    }

                }


            }

            3 -> {
                println("Number of purchased tickets:$soldPlace")

                percentage = (soldPlace.toDouble())/((seat*rows).toDouble())
                var formatPercentage = "%.2f".format(percentage)
                println(
                    "Percentage:${formatPercentage
                    }%"
                )
                println("Current income:$$monney")
                println("Total income: $${count(rows, seat)}")
            }

            0 -> exit = false
            else -> println("Uncorrect value!")
        }
    }

}


fun showSeats(row: Int, seat: Int) {
    println("Cinema:")

    print("  ")
    for (i in 1..seat) {
        print("$i ")
    }
    println("")
    for (j in 1..row) {
        println("$j ${hall[j - 1].joinToString(" ")}")
    }
}


fun info() {
    println("1. Show the seats \n2. Buy a ticket\n3. Statistics\n0. Exit")
}

fun count(rows: Int, seat: Int): Int {
    var cost = 0
    if (rows * seat <= 60) cost = rows * seat * 10
    else cost = (rows / 2 * seat) * 10 + ((rows - (rows / 2)) * seat) * 8
    return cost
}