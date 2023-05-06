# Oscar díjas filmek
## Házi feladat Adatbázis-kezelés I. tantárgyhoz
### SZOFT I/2/E
Hozzon létre JDBC-s consolos java alkalmazást, amely Oscar-díjjal kitüntetett filmek adatait kezelő webalkalmazás előkészítését segíti.\
A consolos alkalmazás kapcsolódjon a MySQL szerverhez és ha még nem létezik hozzon létre adatbázist amelyben az Oscar-díjjal kitüntetett filmeket kíván tárolni! Az adatbázis neve _**oscar**_ legyen!\
Az adatbázis kódolását és alapértelmezett rendezését állítsa UTF-8, magyar kódolásra!\
Ha az adatbázisban nem létezik a filmek tábla akkor hozza létre a táblát, melynek szerkezete a következő legyen:\
* azon: a film azonosítója. Szöveg, Elsődleges kulcs (maximum 15 karakter)
* cim: A film angol címe Pl.: Grand Prix Szöveg
* ev: A díjazás éve Pl.: 1966 Egész szám
* dij: Az elnyert díjak száma Pl.:3 Egész szám
* jelol: A jelölések száma Pl.: 3 Egész szám

A táblába importálja a filmek.txt-ben található adatokat, a fájl elérési útvonalát és nevét parancssori argumentumból olvassa ki. (A fájl az oszlopfejléceket tartalmazza!)\
A consolos alkalmazása értelmezze a parancssorban megadható --force vagy -f kapcsolót, melynek a hatására törölje ez adattábla tartalmát és importálja a megadott fájlban található filmek adatait.