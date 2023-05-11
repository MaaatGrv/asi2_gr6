# ATELIER 2 - GROUPE 6

## Membres du groupe :
- Chloe Baillivet
- Souad Gouriach
- Mathis Gorvien

## Éléments réalisés du cahier des charges :
- Création d'utilisateur et connexion :
    - Création d'un compte via la page http://localhost:8081/login.html
    - Connexion via la même page
    - Il est déjà possible de se connecter avec un utilisateur existant :
        - login : 'admin'
        - password : 'admin'
    - Redirection vers la page d'accueil après connexion ou création de compte
    - Déconnexion via le bouton en haut à droite de la page d'accueil

- Achat/vente des cartes sur la plateforme :
    - Achat de cartes via la page http://localhost:8081/buy.html :
        - Il faut cliquer sur une des colonnes des cartes disponibles puis cliquer sur le bouton pour acheter une carte
        - L'utilisateur doit être connecté pour pouvoir acheter une carte (sinon il est redirigé vers la page de connexion)
        - L'utilisateur doit avoir assez de crédits pour pouvoir acheter une carte 
        - La balance du compte est mise à jour après l'achat
        - La carte achetée est ajoutée à la collection de l'utilisateur
        - La carte achetée est retirée de la liste des cartes disponibles
    - Vente de cartes via la page http://localhost:8081/sell.html :
        idem que pour l'achat de cartes mais dans l'autre sens

## Éléments non réalisés du cahier des charges :
- Les 5 cartes ne sont pas ajoutées à l'inscription d'un utilisateur
- L'utilisateur n'a pas de crédits à l'inscription

## Éléments éventuels réalisés en plus du cahier des charges :
- Stockage des données (utilisateurs, cartes, vente avec API REST)

Lien vers le repository GitHub :
https://github.com/MaaatGrv/asi2_gr6
