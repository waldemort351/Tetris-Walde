* Jeg synes oppgaven var veldig lærerik og interessant. Særlig siden den har gått gjennom mange viktige prinsippier i objektorientert programmering og hvordan alle elementene henger sammen. Jeg føler at jeg har fått terpet mye av det viktige som er å gå gjennom, og samtidig at jeg er bedre forberedt til den neste semesteroppgaven og ikke minst eksamen.


* Noe jeg føler jeg kunne endret kunne blant annet vært å lage en egen "Location" - klasse, istedenfor å opprette variabler for (row, col) hver gang. Det er noe jeg skal ta med inn i neste oppgave. Jeg føler derimot at ved bruk av generiske typer (eksempelvis i grid, med getters og setters) fikk jeg gjenbrukt koden effektivt.

Jeg føler generelt at ettersom jeg fulgte guiden ganske til punkt og prikke at det var ganske god kodestil. Jeg har også prøvd å bruke så mye innkapsling som mulig, da særlig ved å sette hjelpemetoder og ulike feltvariabler til private.



* Det finnes flere grep man kan ta i bruk for å øke modulariteten i koden. Eksempelvis er kohesjon (hvor stort ansvar et objekt har) noe som er viktig. Dette innebærer at et objekt utfører et begrenset antall oppgaver innen et funksjonelt område. Det er lettere å gjennomføre vedlikehold hvis koden er delt opp, og man oppnår derfor høyere modularitet.

Modularitet består av å dele koden inn i moduler. Det gjør det blant annet lettere å for utviklere å bruke forhåndsskrevet kode og endre den slik det passer. Modulene er ikke avhengige av hverandre, og derfor kan nye funksjoner enkelt programmeres i separate moduler. Generelt ønsker man ikke gjenbruk av kode, for det vil gjøre andre deler av programmet avhengig av det. Ved bruk av høy modularitet vil det være enklere å videreutvikle programmet.


Noen ting vi kan gjøre for å øke modulariteten i koden:
- Holde variabler i så smale "scopes" som mulig. Helst unngå globale variabler (så lenge det lar seg gjøre).

- Unngå å vise implementasjon som ikke er nødvendig for brukeren. Implementasjonsdetaljer burde ikke være "public" dersom det ikke er nødvendig. Eksempelvis vil innkapsling være noe som kan gjøre at scopes blir mindre og at man i større grad kan kontrollere koden.


 - Dele koden inn i relevante deler (moduler), slik at det blir lett å endre noe i koden uten at hele programmet endres.





