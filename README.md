# PROJET SCALA 2018-2019
### Par SHAFIE Ichem - M2 Logiciel (Apprenti)

## Installation

* Soit créer le projet via "File > New > Project from version control" soit en ligne de commande :
* git clone https://github.com/ishafie/scala-upem-mow.git
* Lancer le projet via IntelliJ IDEA de préférence
* Cliquer sur le fichier build.sbt et synchroniser le projet.
* Une fois installé, un clic droit sur le projet puis "Run Scala Test" pour lancer les différents test.
* Vous pouvez également lancer le projet depuis src/main/scala/fr.upem.projet/Main (clic droit)

A la racine du dossier vous trouverez un fichier "test.txt", celui-ci contient les données à traiter, donc modifiez
le par vos propres données formattées selon le sujet pour éxécuter le programme comme vous le souhaitez.

(Le fichier donttouch.txt est celui utilisé par les Scala Test, donc à ne pas supprimer.)

## Choix d'implémentation

J'ai eu beaucoup de mal à créer un réel programme et pas seulement des simples fonctions étant donné qu'on a assez
survolé en cours les créations de classe et de programme en entier.
Donc j'hésitais constamment sur l'implémentation de chaque classe.

Une fois dans le développement de fonction je me suis dit que je devais limiter les effets de bord et la création
de variable au maximum de sorte à avoir une application en programmation fonctionnelle.
Donc je me suis dit que c'était plus efficace de ne rien stocker dans des classes et de tout envoyer en paramètre de fonction.
De la sorte, je m'éloignais de la programmation Java pour me rapprocher d'un paradigme un peu plus orienté Scala.

J'ai ainsi choisi d'éxécuter mon programme à chaque ligne de fichier lue plutôt que de tout lire et ensuite éxécuter.

Mon objectif à partir de là était d'utiliser un maximum de notions vues en cours, j'ai abusé un maximum du pattern matching,
j'ai créé des implicits qui m'ont servi au debugging et à sécuriser l'application (SafeBufferedReader).