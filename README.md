# Zadanie 1 - Strelené kačky lite
B-OOP 2022

Vašou úlohou je naprogramovať zjednodušenú verziu kartovej hry Strelené Kačky ako konzolovú JAVA aplikáciu.

## Úvod do hry
Kačky si plávajú v rybníku. Netušia však, že sa k rybníku približujú strelci, ktorý keď začnú stielať, tak sa nezastavia pokiaľ netrafia všetky kačky. Avšak niektorí strelci musia niektoré kačky chrániť a naopak snažiť sa streliť čo najviac súperových kačiek.

## Cieľ hry
Chránťe svoje vlastné kačky a zlikvidujte všetky kačky vašich súperov. Vyhráva hráč, ktorému ako jedinému prežili kačky (zjednodušene je, že každý hráč bude mať na začiatku 5 životov a za každú zastrelenú kačku príde o život).

## Karty
* 5 Kariet kačka pre každého hráča
* 5 Kariet vody
* 6 Kariet zameriavačov
* XX Akčných kariet

## Príprava hry
Hru môže hrať 2-6 hráčov. Každý hráč dostane 5 kariet kačiek. Karty kačiek všetkých hráčov sa zamiešajú spolu s kartami vody a tento balíček si odložíme a budeme používať na vykladanie do Rybníka (Hracie pole o veľkosti 6).
Z balíčka, v ktorom sú zmiešané karty kačiek a vody, vyložíme 6 kariet na stôl. Prvá kačka sa nachádza Vľavo (prípadne Hore, pre zjednodušenie zobrazovania rybníka). Nad každou vyloženou kartou potrebujeme mať prázdne miesto, kde vieme vkladať zameriavače (Druhé hracie pole o velkosti 6).
Následne zamiešame balíček akčných kariet a každému hrácovi rozdáme 3.
Výpis hracieho poľa môže vyzerať nasledovne (Vertikálne zobrazenie hracieho pola):

Rybníček 
 1. - Nezamierené - Kačka hráča 1
 2. - Zamierené - Kačka hráča 2
 3. - Nezamierené - Kačka hráča 3
 4. - Zamierené - Voda
 5. - Nezamierené - Voda
 6. - nezamierené - Kačka hráča 1

Samozrejme hracie pole môže byť aj Horizontálne položené ako je to v pôvodnej hre, je pri ňom však tažšie udržať čitateľne, ktorý zameriavač patrí ku ktorému políčku v rybníku.

## Priebeh hry
Hru začína prvý hráč. Každý hráč musí vo svojom tahu zahrať práve jednu akčnú kartu. Poradie jednotlivých akcií v priebehu ťahu hráča je nasledovný:
* Najskôr hráč, ktorý je na ťahu, musí zahrať jednu kartu z ruky, a to i vtedy, pokiaľ by ho jeho karta poškodila.
* Vykoná akciu, ktorú určuje zahraná karta.
* Hráč, ktorý kartu zahral, si znova doberie kartu tak, aby mal na ruke 3 karty.

POZOR: Kartu musí zahrať aj v prípade, ak by musel zastreliť svoju kačku. Pokiaľ sa žiadna karta nedá logicky zahrať (hráč ma na ruke 3 karty Strieľaj ale nie je zamierené na žiadne políčko v rybníku), tak musí jednu kartu zahodiť na spodok balíčka akčných kariet , a vziať si z neho inú.

Vo chvíli, keď zastrelítie niekoho kačku, odstránite ju z rybníka a odoberiete život hráčovi, ktorému patrila (5 kačiek = 5 životov). Hráč, ktorý prišiel o všetky kačky je vyradený z hry.

## Koniec hry
Vyhráva hráč, ktorému ako jedinému prežily kačky (zjednodušenie je, že každý hráč bude mať na začiatku 5 životov a za každú zastrelenú kačku príde o život).

## Prehľad akčných kariet
### Zamierenie a streľba
#### Zamieriť
Zahraním karty zamieriť si zvolíme, nad ktoré políčko v rybníku zamierime. Túto kartu vieme zahrať iba na políčko, nad ktorým už zameriavač nie je. Zamierime iba nad toto dané mieto v rybníku, nie na konkrétnu kačku. To znamená, že ak sa kačka z tohto miesta pohla, zameriavač stále ostáva na mieste, a zamierené bude na inú kačku alebo na kartu vody. Môžeme zamieriť aj na miesto, kde sa nachádza v rybníku voda.

#### Vystreliť
Zahraním karty vystreliť vieme streliť na zamierené políčko. Nie je podstatné , ktorý hráč zamieril na dané políčko. Hociktorú kačku, ktorá sa nachádza na zamierenom políčku môže zasteliť hociktorý hráč. Zastrelená kačka je odstránená z hry. Všetky karty, ktoré sa nachádzajú za touto kačkou posunte o jedno pole dopredu, a na koniec doplne kartu z balíčka. Kartu zameriavača, na poli na ktoré ste vystrelili môžete vrátiť medzi ostatné zameriavače. Kartu vystreliť ide zahrať aj keď je zamierené políčko s vodou. V tom prípade však karta vody ostáva na svojom mieste a vraciame spät iba zameriavač.

#### Divoký Bill
Funguje ako kombinácia kariet Zamieriť a Vystreliť. Odstráňte z rybníka ľubovoľnú kačku. Pokiaľ nad daným políčkom bol zameriavač, vráťte ho do kôpky.

### Pohyb Kačiek
#### Kačací pochod
Posuňte všetky karty v rade o jedno políčko dopredu. Prvú kartu vráťte späť na koniec balíčka s kačicami, a voľné pole na konci rybníka doplňte kartou z balíčka s kačicami.

#### Turbokačka
Posuňte ľubovoľnú kačku na políčko dopredu rybníka. Kačky, ktoré predbehla, posuňte o miesto dozadu.

#### Rošambo
Ľubovoľne premiešajte pozície všetkých kariet v rybníku. Zameriavače ostávajú na svojich miestach (spravte shuffle na kartách v rybníku)

#### Kačací tanec
Zoberte karty z rybníka a zamiešajte ich s balíčkom s kačicami. Potom vyložte nových 6 kariet do rybníka.

## Hodnotenie

Zadanie je hodnotené 10 bodmi. 5 bodov je za funkčnosť zadania, 5 bodov za Princípy OOP. **Odovzdaný program musí byť skompilovateľný, inak je
hodnotený 0 bodmi**. Skompilovateľnosť zadania kontroluje aj github pipeline. Hlavný dôraz v hodnotení sa kladie na objektový prístup a princípy,
okrem iného:

* vhodné pomenovanie tried a metód v jednotnom jazyku (názvy tried s veľkým počiatočným písmenom, názvy metód s malým),
* vhodné použitie modifikátorov prístupu (public, private, poprípade protected) na obmedzenie prístupu k metódam a atribútom,
* využitie dedenia a polymorfizmu,
* použitie výnimiek na ošetrenie nedovoleného správania (nehádzať a nezachytávať všeobecnú triedu Exception),
* nepoužívajte nested classy,
* vo vašich triedach nevytvárajte statické metódy (v zadaní nie sú potrebné),
* v hlavnej triede (main) nevytvárajte žiadnu logiku, iba vytvorte nový objekt.

Niektoré z vecí, za ktoré sme minulý rok strhli po 0,5 - 1 bode:

* Rozhodovanie použitia kariet cez If/Switch (nato treba použiť dedenie)
* Neošetrené vstupy
* Kód v Main triede (máme tam len zavolať triedu, ktorou spustíme hru, nič viac)
* Nevyužité dedenie
* Statické premenné
* Zlý package naming
* Nepoužívanie konvencíí pomenovania
* new Scanner alebo Random (stále vytváranie novej a novej inštancie, treba vytvoriť len jednu a používať tú)
* Nested class
* Logika iba v jednej triede
* Nevyuzitie polymorfizmu
* Spadnutie hry na nejakej Exception
* Inicializácia premenných priamo v triedach a nie v konštruktoroch
* Nevhodné modifikátory prístupu
* Nevypísanei vítaza na konci hry

Prípadne sú pri nedostatočnej implementácií struhnuté body za OOP za nedostatočnú implementáciu.

**Pri zadaní sa kontroluje originalita zadaní, a všetky zadania so zhodou vyššou ako 80% sú hodnotené 0 bodmi.**

## Odovzdávanie
Zadanie si naklonujte z repozitára zadania výhradne pomocou poskytnutej linky cez GitHub Classroom (pokiaľ si vygenerujete vlastný repozitár pomocou tlačidla "Use this template" z template repozitára, my váš repozitár neuvidíme a nebudeme ho hodnotiť!). Svoje vypracovanie nahrajte do pre vás vytvoreného repozitára pre toto zadanie pomocou programu Git (git commit + git push).
Skontrolujte si, či sa váš repozitár nachádza pod skupinov **Interes-Group**, inak nemáme prístup ku vášmu repozitáru a zadanie sa nepovažuje za odovzdané. Vypracovanie môžete "pusho-vať" priebežne. Hodnotiť sa bude iba _master_ branch. Zadanie je nutné vypracovať do **24.3.2021 23:00**.

V projekte upravujte iba súbory v priečinku _src/main_ a jeho podpriečinkoch. Ostatné súbory je upravovať zakázané (predovšetkým súbory _pom.xml_, súbory obsahujúce github pipeline-y a súbory obsahujúce automatizované testy).

Vo svojom github účte si nastavte svoje meno (settings > profile > name), aby bolo možné priradiť riešenie ku študentovy. **Pokiaľ nebude možné spárovať študenta s riešením je zadanie hodnotené 0 bodmi!**

# Assignment 1
B-OOP 2022