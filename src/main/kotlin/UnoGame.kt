import java.util.*

class UnoGame(var numberPlayers: Int) {

    var deck = mutableListOf<Card>()                            // * variable fürs deck erstellt mit einer mutablelist der Klasse Card als Datentyp.
    var playerHands = mutableListOf<MutableList<Card>>()        // * playerHands wird mit 2 mutableLists of deklariert, weil es eine Liste an Listen von den Spieler Händen ist.
    var currentCard: Card? = null                                // * Ist die gelegte Karte auf dem Stapel, die eine Aktion erfordert vom nächsten Spieler. ? = null fängt einen möglich crash ab für einen jetzt nicht existierenden Wert. // ? null wert eingebaut arbeite aber nicht mit 0 evlt try catch stattdessen benutzen?
    var stack = mutableListOf<Card>()                           // * Stack ist der Kartenstapel, der gelegten Karten und wird mit Card befüllt
    var gameOver: Boolean = false                               // *  standartmäßiug falsch gesetzt, da dass Spiel fortlaufend ist
    var currentPlayer: Int = 0                                 // * sttandartmäßig auf 0 gesetzt um den Spieler zu initialisieren

    init {                                                      // *  initialisierung vom Start des Kartenspiels
        val colors = listOf(
            "Rot",
            "Grün",
            "Blau",
            "Gelb"
        )
        val values = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9")

        for (color in colors) {                                   // * hier läuft die schleife für jede Farbe durch
            for (value in values) {                               // *  hier läuft die schleife für jeden Wert durch
                deck.add(Card(color, value))                     // * und hier wird jede Karte mit Farbe und wert kombiniert und dem Deck als Card hinzugefügt.
            }
        }

        Collections.shuffle(deck)                                // * collections ist auf der util Bibiliothek von Java enthalten und mit .shuffle greift man auf dies Methode der  Klasse zu und Mischt in meinem Fall das Deck
        for (i in 0 until numberPlayers) {                   // * schleife für kartenasugabe an anzahl der Spieler
            val hand = mutableListOf<Card>()                     // * variable für die Hand des Spielers erstellen. Hier wird Eine mutableListOf (Card) verwendet.
            for (j in 0 until 7) {                           // * schleife für Kartenausgabe an die Spieler (7 Karten)
                hand.add(deck.removeAt(0))                 // * der Spieler bekommt dann 7 karten aus dem Deck und jede Karte wird am Index 0 aus dem Deck entfernt.

            }
            playerHands.add(hand)                                // * die hand wird mit playerHands.add(hand) zur Liste playerHands hinzugefügt und somit Teil der Liste der Spielerhände.

        }

        val initialCard = deck.removeAt(0)                  // *  start Karte wird vom 0. Index bzw vom Anfang der "Liste" bzw des Decks entfernt
        stack.add(initialCard)                                       // * start Karte zum Anfang des Spiels kommt auf den Stapel(Stack)
        currentCard = initialCard           // * hier ist ein Fehler der immer wieder die initial card statt die currentcard anzeigen lässt // GELÖST // initialcard steht für die initialisierungsKarte des Spiels, quasi zum Anfang hin
        println("Start Karte $initialCard")
    }

    fun startGame() {                                                                                        // * Eigentliche Beginn des Spiels

        while (!gameOver) {
            println("$currentPlayer ist jetzt am Zug.")                                                     // * Namensausgabe des ersten Spielers
            println("$currentCard")

            val playerHandWithIndex = playerHands.get(currentPlayer).withIndex()                                         // *  mit playerhands.get(currentplayer) wird das deck des momentanen spielers angezeigt. .withindex fügt die information des Index hinzu.

            for ((index, card) in playerHandWithIndex) {                                                                  // * index, card sind in klammern, weil es ein syntax fehler geben würde. Es beinhaltet 2 informationen.
                println("$index. $card")                                                                        // *  Anzeige auf der Konsole der Karten des momentan Spielers
            }
            val playerHand = playerHands.get(currentPlayer)                                         // * mit playerhands.get(currentplayer) wird das deck des momentanen spielers angezeigt.

            var isPlayable = playerHand.any { card -> currentCard?.color == card.color || currentCard?.value == card.value }   // * lambda benutzt, um eine Legbare Karte aus der Spielerhand zu finden
            if (isPlayable) {
                val chosenCardIndex = readln().toInt()                                                                  // * Kartenauswhal vom Spieler seiner Hand über Konsole
                var chosenCard = playerHand.elementAt(chosenCardIndex)                                                  // ? Ausgewählte Karte vom Spieler aus seiner Hand über Index
                stack.add(chosenCard)
                currentCard = chosenCard                                                                                // * currengcard als chosencard deklariert um die aktuelle karte auf dem stapel aufzuzeigen
                playerHand.remove(chosenCard)                                                    // * Karte wird zum Stapel hinzugefügt und aus der Spielerhand entnommen

            } else {
                println("bitte ziehe eine Karte")
                playerHand.add(deck.elementAt(0))
                deck.removeAt(0)

            }
// ! ich hatte vorher nur currentPlayer + 1 da stehen, was mir die Fehlermeldung Index 2/3 out of bounds for length 2/3 ausgab.
// ! das hat die jedes mal versucht, einen weiteren Spieler hinzuzufügen, auch wenn es keinen weiteren gab.
// ! chatgpt hat mir daraufhin erklärt, dass
             currentPlayer =  (currentPlayer + 1) % numberPlayers
                if (playerHand.size == 0){
                    gameOver = true

                }
            println("################################")
        }


    }


}