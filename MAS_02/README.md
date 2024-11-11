# Napisac program implementujący podane założenia
## Wybrany temat wypożyczalnia multimediów

# Asocjacja - oba obiekty moga zyc bez siebie
## implementowane za pomocą listy (licznosc 1-*)
### Właściciel - Nieruchomość

# Asocjacja z arybutem - utworzyc klasę asocjacji
## iplementowane za pomocą klasy asocjacyjnej (tylko gdy licznosc jest *-*)
### Nieruchomość - Cena

# Asocjacja kwalifikowana - atrybut jednoznacznie okreslajacy inna klase
## implementacja za pomocą kontenera mapującego (np. private Map<String, Movie> moviesQualif = new TreeMap<>(); )
### Nieruchomość - Dane techniczne - Wartość

# Kompozycja - Z koncepcyjnego punktu widzenia kompozycja oznacza, że "obiekt jest zawarty w innym obiekcie". Jest to relacja "całość – część"  ( B "zawiera" A).  Np. obiekty typu Lampa zawierają obiekty typu Żarówka.
## implementacja za pomocą Asocjacji, jednakże gdy całość jest tworzona/usuwana to i część jest tworzona.usuwana
### Budynek - Mieszkanie
