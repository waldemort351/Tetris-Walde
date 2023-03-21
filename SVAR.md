* Jeg synes oppgaven var svært lærerik og interessant. Dette gjelder spesielt fordi den dekket mange essensielle prinsipper innen objektorientert programmering og hvordan alle elementene er sammenkoblet. Jeg føler at jeg har dekket mye av det viktige materialet grundig, samtidig som jeg er bedre forberedt for neste semesteroppgave og, ikke minst, eksamen.

* En ting jeg føler jeg kunne gjort annerledes er å opprette en separat "Location"-klasse i stedet for å opprette variabler for (rad, kolonne) hver gang. Dette er noe jeg vil vurdere for neste oppgave. Likevel føler jeg at jeg ved å bruke generiske typer (for eksempel i rutenett med getters og setters) var i stand til å gjenbruke koden effektivt.

Generelt sett føler jeg at siden jeg fulgte guiden ganske nøye, var kode stilen ganske god. Jeg har også forsøkt å bruke så mye inkapsling som mulig, spesielt ved å sette hjelpemetoder og ulike feltvariabler som private.

* Det finnes flere tiltak vi kan ta for å øke modulariteten i koden. Kohesjon (hvor mye ansvar et objekt har) er for eksempel viktig. Dette betyr at et objekt utfører et begrenset antall oppgaver innen et funksjonelt område. Det er enklere å vedlikeholde koden hvis den er delt opp, og dermed oppnås høyere modularitet.
Modularitet innebærer å dele koden inn i moduler. Dette gjør det enklere for utviklere å bruke forhåndsskrevet kode og endre den etter behov. Modulene er ikke avhengige av hverandre, og dermed kan nye funksjoner enkelt programmeres i separate moduler. Generelt sett ønsker vi ikke å gjenbruke kode, da dette vil gjøre andre deler av programmet avhengige av den. Med høy modularitet vil det være enklere å utvikle programmet videre.

Noen tiltak vi kan ta for å øke modulariteten i koden inkluderer:

Holde variabler i så smale "scopes" som mulig. Unngå helst globale variabler så langt det lar seg gjøre.

Unngå å vise implementasjonsdetaljer som ikke er nødvendige for brukeren. Implementasjonsdetaljer bør ikke være "public" med mindre det er nødvendig. Inkapsling kan for eksempel hjelpe til med å gjøre scopes mindre og tillate større kontroll over koden.

Dele koden inn i relevante deler (moduler), slik at det blir enkelt å endre noe i koden uten å måtte endre hele programmet.





