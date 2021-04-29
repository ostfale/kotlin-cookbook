package de.ostfale.kotlin.functional.basicfunctions

data class Position(val row: Int, val col: Int)

fun main() {
    println("Depth-Search ")
    val lab = buildMaze(mazeStr)
    printMaze(lab)
    if (depthSearch(lab, findStart(lab))) printMaze(lab)
}

val mazeStr = """
    WWWsWWWWWWWWWWWWW
    W    W W     W  W
    W WWWWW W WWWWW W
    W          W    W
    W W W WWWWW WWWWW
    W W W W   W     W
    W W WWW W W WWW W
    W W     W   W   W
    WWWWWWWWWWWWWdWWW
""".trimIndent()

fun buildMaze(s: String) = s.lines().map { it.toMutableList() }

fun printMaze(maze: List<List<Char>>) {
    for (line in maze) println(line.joinToString("").replace('W', '\u2588'))
    println()
}

fun findStart(maze: List<List<Char>>): Position {
    for (row in maze.indices) {
        val col = maze[row].indexOf('s')
        if (col != -1) return Position(row, col)
    }
    return Position(-1, -1)
}

val directions = listOf(
    Position(1, 0), // bottom
    Position(-1, 0), // top
    Position(0, 1), // right
    Position(0, -1) // left
)

fun depthSearch(maze: List<MutableList<Char>>, start: Position): Boolean {
    val rows = maze.size
    val cols = maze[0].size

    // Grenzen des Suchgebiets überschritten ,Hindernis oder schon besucht ?
    if (start.row !in (0 until rows) ||
        start.col !in (0 until cols) ||
        maze[start.row][start.col] == 'W' ||
        maze[start.row][start.col] == '.'
    )
        return false
    // Zielpunkt gefunden ?
    else if (maze[start.row][start.col] == 'd')
        return true

    // aktuelles Feld als durchsucht markieren
    maze[start.row][start.col] = '.'

    // vier Nachbarfelder
    for (dir in directions) {
        val newrow = start.row + dir.row
        val newcol = start.col + dir.col

        // rekursiv weitersuchen
        if (depthSearch(maze, Position(newrow, newcol))) {
            // Weg wurde gefunden , markieren
            maze[newrow][newcol] = '*'
            return true
        }
    }
    return false
}