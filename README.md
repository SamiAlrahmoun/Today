# Today Project
Today est un projet E-commerce qui a 3 clients et un producer Le producer a déjà créé des produits par défauts, 
ces produits vont être consommés par les trois clients . Les clients vont acheter les mêmes articles à peu près et 
le producer va essayer de modifier ou supprimer certains produits en même temps. Nous avons  4 threads qui nous permettent d'exécuter cela en concurrence.

- 1 pour le producer.
- 3 pour les clients.
- 10 produits dans des quantités variées en 3-10, pour exécuter le client plusieurs fois.

### Assumptions
- Les produits sont déjà présents dans la base de données.
- Le client ne peut acheter le même produit qu'une seule fois, donc ne peut pas choisir la quantité lors de l'ajout dans sont panier
- Lorsque la quantité d'un produit bascule à zéro, c'est que le produit a été épuisé ou supprimé par le propriétaire. Donc on ne peut l'acheter.

### Observation 
 Plus on exécute le client on remarque:
 - Pas deadlock, le Système ne bloque pas.
 - Pas de Starvation car tous les clients effectuent bien achats tant qu'il reste de produit.
 - Vivacité : il y'a toujours un différent thread(client) qui a plus d'articles achetés que d'autres car il est plus rapide.
 - Plus on exécute le client la quantité d'articles diminue et se rapproche de zéro. 
# Outils
RMI
Database mongodb Atlas
# Requirements

- Java JDK 8 to 14.
- Maven 3.6.3.

# Command lines

- Exécuter depuis le jar

```sh
java -cp Today.jar fr.alma.today.Server

```

- Run the `Server` class: 

```sh
java -cp Today.jar fr.alma.today.Server
```

- Run the `Client` class: 

```sh
java -cp Today.jar fr.alma.today.Client
```



# Author
- Mamadou Oury DIALLO
- Marvel OYOGHO LAWSON
- Sami AL RAHMOUN
