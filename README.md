# HackNC_2024

## Glutten
A mobile application where you can search by product or by restaurant to search whether they are gluten free or not. These databases were taken from Nutritionix and FDC (csv files were downloaded and manually added to a database). The backend application (in the main branch) is in Java and uses the JDBC Driver from Java to connect to pgadmin.

Users will be able to select from the menu whether they would like to search by product or by restaurant. If it's by product, they will enter a keyword and all possible items in the database with that keyword are returned. Users can also enter a specific ID to find if a certain product is gluten-freee, may containt gluten, or not gluten free. If a user searches by database, the user can enter a restaurant and it will return their menu items that are gluten-free and have gluten-free options. The database currently only contains menu items for Red Robin, Daniel's, and Rock 'N' Roll Sushi. 

The front_end branch contains code for a potential React Native application for the product. We instead have a [Figma](https://www.figma.com/design/dNBL64IM0YbTg3IGyOFeuo/glutten?node-id=0-1&t=UjPgm3IRM0ERmCiJ-1) mock-up to show what our application would have looked like.

# Dependencies and Requirements:
- pgadmin
- Java (version 17 or higher)
- Java IDE (Eclipse, IntelliJ, etc.) 
