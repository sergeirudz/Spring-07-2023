# Start

1. docker-compose up -d


# Test assignment

Introduction:
You are required to implement a Hi-Lo card game. Game Card deck is standard 52 cards https://en.wikipedia.org/wiki/Standard_52-card_deck. Each round player must guess if next card drawn from the deck is equal, higher or lower to the base card. Card ranks are from 2 to 10. Jack, Queen, King and Ace have rank 10.
Gameplay requirements:
When round is started frontend (Postman/Browser) sends to server (Spring) StartRoundRequest. Client receives and must display base card from StartRoundRequest.
Client has 10 seconds to make an action. During this time player has a choice of three actions - 'higher', 'lower' or 'equal'.
When countdown reaches zero backend stops accepting actions and responds „TIME_OUT“ to the following query
Server checks internally player action and compares base card rank to result card rank. - If player action was correct, player gets a correct answer point - If player action was incorrect, player does not get a correct answer point
Previous result card became new 'base card' and is again displayed to client as in step nr 1

1. Controller - POST /game. req: start. res: Receives card. Saves timestamp to DB.
   - Service: Get random card from deck. Save card to DB.
2. Controller - POST /game. req: 'higher', 'lower' or 'equal'. res: 'TIME_OUT' or 'CORRECT' or 'INCORRECT'. Saves timestamp to DB. Save current answer point to DB.
   - Service: New received card becomes the new base card.




