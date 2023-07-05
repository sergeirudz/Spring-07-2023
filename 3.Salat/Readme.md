
# Assignment 3

Salat
Tee uus veebiprojekt. Koosta klass Toiduaine tarbeks (nimetus, valkude, rasvade ja süsivesikute protsent). Protsent kokku ei saa ületada 100 - muidu antakse veateade - tee see API otspunktist andmeid võttes. Loo API otspunktist brauseri või Postmani abil mõni toiduaine ja pane ta andmebaasi (nt. kartul, hapukoor, vorst). Andmed saab nt (https://tka.nutridata.ee/et/). Sealt kartul (https://tka.nutridata.ee/et/toidud/280). Koosta klass Toidukomponendi tarbeks (kogus, viide toiduainele - võõrvõtmena). Loo mõned toidukomponendid (nt. 100 g kartuleid, 30 g hapukoort, 50 g vorsti). Lisa toidukomponendile API otspunkt selle sees leiduva rasvakoguse arvutamiseks.

Koosta klass Toidu jaoks (koosneb nimetusest ja toidukomponentidest - võõrvõtmete list). Lisa toidule käsklused küsimaks sisalduvate valkude, rasvade ja süsivesikute kogust. Loo brauseri või Postmani abil retsepti järgi toit (nt. kartulisalat).

Võimalda otsida Toiduainet, Toidukomponenti kui ka Toitu nimetuse järgi (3 erinevat API otspunkti). Tee uus API otspunkt, mis küsib sisendiks rasva protsendi algväärtust ja lõppväärtust ning tagastab kõik Toidud kellel on rasvaprotsent sellest vahemikus.


1. endpoint food (protein, fat, carbs)
2. It should add up to 100%. If exceeds 100 then error message
3. Food item should be added to the DB
4. Create food recipe 100g potatoes, 30g sour cream, 50g sausage
5. Create endpoint for calculating fat amount in food recipe
6. Create endpoint for Food, get protein, fat, carbs for the given food
7. Create endpoint to search by Food name, food component
8. Create endpoint to return Food items with fat percentage between given values