# Task
Tee uus projekt „Kümnevõistlus“
Ühtset lahenduskäiku pole, aga eesmärk on selline:
-Võimalda salvestada sportlane – nimi, riik, vanus.

-Järgmiseks tee 10 POST päringut Controlleris, mis võtavad vastu iga kergejõustiku ala tulemuse
Kõik päringud arvutavad tulemuse punktideks (guugelda kuidas arvutada, aga ülemäära aega ei pea kulutama – kui ei leia, siis tee tulemuse punktideks saamine tunde järgi).
Kõik tulemused peab ära salvestama andmebaasi.
Kõik tulemused peavad minema selle sportlase „külge“. Saada näiteks päringuga lisaks tulemusele kaasa ka ID.

-Võimalda saada sportlase kogusumma selleks hetkeks (kui on sisestatud 6 ala, siis 6 ala kogusumma)

## TODO
- add person to DB. name, country, age
- add 10 POST req that will add sport results to the person and convert it to points.
  - https://www.sportcalculators.com/decathlon-calculator 
- add GET req that will return the sum of all points for the person.
