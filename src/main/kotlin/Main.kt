fun main() {

    println("Hallo, hast du lust auf ne Runde? Bitte antworte mit \"ja\" oder \"nein\"")
    var userInput = readln().lowercase()
    println("Bitte geben sie noch die Anzahl an Spielern an (2-4)")
    var userInputPlayers = readln().toInt()

    val unoGame: UnoGame = UnoGame(userInputPlayers)
    if (userInput == "ja"){
        println("Viel Glück und viel erfolg")
        unoGame.startGame()

    }else{
        println("Angst, Potter? Dann ein andern Mal.")
    }


}
