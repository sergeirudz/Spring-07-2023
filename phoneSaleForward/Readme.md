# Task
On mobiiltelefonide edasimüüja, kes palub teil enda telefonide müümise jaoks teha valmis veebipood. Alustame back-endist.
Telefonide andmebaasi soovitakse enda pool hoida, seega palutakse, et me midagi ENDA andmebaasi sisestama ei hakkaks.
Nende andmebaasi päringud on meile piiratud – me saame vaid võtta (GET päring).
Andmebaasi aadress on siin:
https://dummyjson.com/products
https://freecodegenerators.com/code-converters/json-to-pojo
Tee sellest mudel.
Kui pead määrama tagastuse restTemplate.exchange() sees, siis tee UusKlass.class
(me tegime NordpoolResponse.class)
Tee controller võtmiseks.
Teeme API otspunkti sees RestTemplate abil päringu, HttpEntity jääb tühjaks (null)  ja tagastame Frontendile objekti, mis tagastab omakorda massiivi mobiiltelefonidest.
Võimalda mobiiltelefonide võtmist ka muuta front-endi poolt (anna kaasa mingid kindlad parameetrid)

## TODO
1. create GET /products
2. create model for products
3. add optional parameters to GET /products