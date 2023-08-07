class Card(val color: String, val value: String) {              // Hier wird eine Kotlin-Klasse "Card" definiert, die zwei Parameter im Konstruktor erwartet: "color" und "value".
    override fun toString(): String {                           // Die "toString()" Funktion wird überschrieben (override), um eine lesbare Darstellung der Karte zu erhalten.
        return "$color $value"                                  // Hier wird ein String zurückgegeben, der die Farbe und den Wert der Karte enthält.
                                                                // In diesem Fall werden die Werte der "color" und "value" Variablen in den String eingefügt.
                                                                // Beispiel: Wenn color = "Rot" und value = "3" ist, wird der Rückgabewert "Rot 3" sein.
    }
}                                                               // ? stattdessen eine map für die Liste der Karten verwenden, da ich hier nur einen Stgring als ausgabe habe.