# : The Piano

VERSION JAVA SE / FX : 12

VERSION Netbeans : 10

Ce piano permet :

- de jouer des notes parmi 4 styles
- de sauvegarder partitions en jouant
- de lire des partitions

Vous pouvez jouer les notes en appuyant sur ALT + A/Z/E/R/T/Y/U/I/O/P

REC : Lance l'enregistrement et ecrase la partition en cours (MAX : 4 notes/seconde)
STOP : Arrete l'enregistrement
PLAY : Joue la partition en cours
RESET : Ecrase la partition
RESET STYLE : Definit le style de toutes les notes au style sélectionné

Format de sauvegarde :

Les notes sont sauvegardés sous le format suivant :

p100|0000p3#

"p1" : La lettre represente le type de note (p/j/b/s) et le numero la frequence (0 = 10)
"00" : La note est vide

'|' : Représente un nouveau morceau (un morceau = 20 notes pour 5 secondes)

'#' : fin du fichier


##############################################################

Les methodes loadGame et saveGame sont fonctionnelles

Les methodes StartGame et stopGame redirigent vers REC et STOP

pauseGame ne sert pas a grand chose

GITHUB : https://github.com/Angom8/info202
