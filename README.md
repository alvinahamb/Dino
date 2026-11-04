# 🦖 Dino

Un clone du célèbre jeu du dinosaure de Chrome, développé en **Java** avec **Swing / AWT**.
Sautez par-dessus les cactus, battez votre record et essayez de survivre le plus longtemps possible !

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/GUI-Swing%20%2F%20AWT-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/status-playable-brightgreen?style=for-the-badge)

---

##  Fonctionnalités

- 🏃 **Dinosaure animé** : GIF de course, sprite de saut et sprite de défaite
- 🌵 **Cactus générés aléatoirement** (plusieurs tailles) toutes les 1,2 seconde
- 💥 **Détection de collision** avec une hitbox ajustée pour un jeu équitable
- 🏆 **Score en temps réel** et **meilleur score sauvegardé** entre les parties
- 🔁 **Redémarrage instantané** après un Game Over
- 🎞️ Boucle de jeu fluide à **60 images par seconde**

##  Commandes

| Touche     | Action                                      |
|------------|---------------------------------------------|
| `Espace`   | Faire sauter le dinosaure                   |
| `Espace`   | Relancer la partie après un *Game Over*     |

##  Lancer le jeu

### Prérequis

- **JDK 8 ou supérieur** ([Adoptium](https://adoptium.net/) ou [Oracle](https://www.oracle.com/java/technologies/downloads/))

Vérifiez votre installation :

```bash
java -version
javac -version
```

### Installation et exécution

```bash
# 1. Cloner le dépôt
git clone <url-du-depot>
cd Dino

# 2. Compiler
javac *.java

# 3. Lancer
java Main
```

>  **Important :** lancez la commande `java Main` depuis la **racine du projet**.
> Les images (`Images/`) et la sauvegarde (`Save/`) sont chargées via des chemins relatifs.

##  Structure du projet

```
Dino/
├── Main.java        # Point d'entrée de l'application
├── Game.java        # Fenêtre principale (JFrame)
├── Dino.java        # Panneau de jeu : boucle, rendu, cactus, collisions
├── Listener.java    # Gestion du clavier (saut / redémarrage)
├── Block.java       # Entité de base (position, taille, image)
├── Score.java       # Lecture / écriture du meilleur score
├── Images/          # Sprites : dino, cactus, sol, game over...
└── Save/
    └── score.txt    # Historique des scores
```

##  Comment ça marche ?

- **Boucle de jeu** : un `javax.swing.Timer` déclenche un `repaint()` environ 60 fois par seconde.
  À chaque rendu, le jeu dessine les éléments, déplace les cactus et applique la gravité au dinosaure.
- **Saut** : appuyer sur `Espace` donne une vitesse verticale initiale au dinosaure, puis une gravité constante le ramène au sol.
- **Obstacles** : un second `Timer` génère un cactus aléatoire à intervalle régulier ; les plus anciens sont supprimés pour limiter la mémoire utilisée.
- **Collisions** : test de chevauchement de rectangles (AABB) entre le dinosaure et chaque cactus.
- **Scores** : chaque score est ajouté dans `Save/score.txt` ; le meilleur est relu au démarrage.

##  Pistes d'amélioration

- [ ] Augmentation progressive de la vitesse
- [ ] Ajout des gros cactus et des oiseaux
- [ ] Sauts de hauteur variable selon la durée d'appui
- [ ] Nuages en arrière-plan et cycle jour / nuit
- [ ] Sons (saut, mort)
- [ ] Packaging en `.jar` exécutable

##  Technologies

- **Java**
- **Swing / AWT** pour l'interface et le rendu 2D

##  Auteur

Projet réalisé par **KASSI**.
