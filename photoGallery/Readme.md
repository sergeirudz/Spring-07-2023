# Task
Sul on fotode kogumik, mida hoiab hoopis teine rakendus enda sees. Pead tagastama front-endile kõik pildid, mis fotode kogumikus selles teises rakenduses on. Pole mõtet neid vahepeal meie andmebaasi panna, sest sina ei muuda, lisa ega kustuta neid OMA rakenduses – sinu ülesanne on võtta neid nii nagu on.
Aadress fotode saamiseks: https://jsonplaceholder.typicode.com/photos
Tee olemasolevasse projekti (või ka uus projekt) kõikide fotode võtmine API endpointi kaudu.
Selleks tee uus Controller ja sinna sisse GetMapping.
Testi enne GET päringut Postmanis. Meil EI OLE vaja anda body ega muuta headereid -> seega HttpEntity võib olla tühi (null).
Tagastusklass loo aga täpselt nii nagu peab, võid kasutada ka converteri abi:
https://www.site24x7.com/tools/json-to-java.html
Pane tähele, et tagastuses on seekord tegemist Listiga, mitte ühe objektiga:
Kui pead määrama tagastuse restTemplate.exchange() sees, siis tee UusKlass[].class
(me tegime OmnivaParcelMachine[].class)

Tagasta Controlleri lõpus front-endile kõik albumid, mida sa sellest rakendusest saad, front-end juba tegeleb seejärel nende kasutajale kuvamisega.

## TODO
1. get all photos from https://jsonplaceholder.typicode.com/photos
2. Create new GET endpoint to return all photos
3. Response should be a list of photos in JSON format