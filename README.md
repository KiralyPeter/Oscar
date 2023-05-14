# Oscar program a "SZOFT I/2/E-Adatbázis-kezelés I." tantárgyhoz.

Az Oscar.jar program a **"SZOFT I/2/E-Adatbázis-kezelés I."** tantárgy házi feladatának készült.

A program futtatásához egy forrás fájlra van szükség, amiből az **"oscar"** adatbázis **"filmek"** adattáblájába tölt adatokat.
A program helyi (lokális) adatbázis kiszolgálóval működik.
Ha az **"oscar"** adtbázis nem létiezik, akkor létrehozza.
Ha a **"filmek"** adattábla létezik, akkor az _'-f'_ vagy _'--f'_ kapcsolókkal lehet töröltetni a létező táblát.

A program futtatása:

<code> java -jar Oscar.jar <forrás fáj> <-f vagy --f kapcsoló></code>

Például:\
<code>
java -jar Oscar.jar filmek.txt\
java -jar Oscar.jar filmek.txt -f