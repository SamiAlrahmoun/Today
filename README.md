# Today Project
Today est un ecommerce projet qui a 3 clients et un producer 
Le producer a déjà crée des produits par defauts que les trois client vont consommer.
Les 3 clients vont acheter les même article a peu pres et le producers va essayer de  modifier ou supprimer certaines produits en meme temps.
On a 4 threads qui nous permettent d'executer cela en conccurence.
- 1 pour le producer.
- 3 pour les clients.
- 10 produits dans la quantités varies en 3-10, pour executé le client plusiers fois.

### Assumptions
- Les produits sont déjà presents dans ma base de donnée.
- Le client ne peut qu'acheté le même produit qu'une seul fois, donc ne peut pas choisir la quantité lors de l'ajout dans sont panniers.
- Lorsque la quantité d'un produit bascule a zero, c'est que produit a été épuisé ou supprimé par le propriétaire. Donc on ne peut l'acheté.

### Observation 
 Plus on execute le client on remarque:
 - No deadlock le Système ne bloque pas.
 - No Starvation car tous les clients effectués bien achats tant qu'il reste de produit.
 - Vivacité : y'a toujours un different thread(client) qui a plus d'articles acheté que d'autres car il est plus rapide.
 - Plus on execute le client la quantité d'articles diminue et se rapproche de zero. 
# Outils
RMI
Database mongodb Atlas
# Requirements

- Java JDK 8 to 14.
- Maven 3.6.3.

# Command lines

- Execute depuis le jar

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
Mamadou Oury DIALLO
Marvel OYOGHO LAWSON
Sami AL RAHMOUN
