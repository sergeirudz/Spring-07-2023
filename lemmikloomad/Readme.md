Tee uus veebiprojekt. Tee klass Lemmikloom (nimetus, kaal) ning võimalda teda andmebaasi lisada. Lisa klass Omanik, kes seo Lemmikloomaga üks-mitmele seose kaudu. Võimalda Omanikule juurde lisada lemmikloomi.

Võimalda küsida Lemmikloomade koguarvu ühe omaniku osas (sisendiks omanik ja väljundiks arv). Võimalda ühe omaniku kõige suurema kaaluga lemmiklooma leida ja kõige väiksema kaaluga. Võimalda sisestada minimaalne kaal ja maksimaalne kaal ning väljasta kõik lemmikloomad selles vahemikus.

Te
Tee uus andmebaasitabel Kliinik, mis omab üks-mitmele seost lemmikloomaga. Võimalda kliinikust otsida kindlat lemmiklooma tema nimetuse järgi. Võimalda API otspunktist anda vaid üks kliinik - kellel on kõige rohkem lemmikloomi.


1. add pet to db
2. add class owner
3. add pet to owner
4. get the number of pets for one owner /owner/{id}/pets
5. get the heaviest pet for one owner
6. get the lightest pet for one owner
7. option to insert min and max weight and get all pets in that range
8. new DB table Kliinik
9. Kliinik has one to many relationship with pet
10. API to get only one Kliinik - who has the most pets
