Mist 0.0.2 
Komponent składający się z części serwerowej oraz prostego interfejsu użytkownika.
Część backendowa komunikuje się z dwoma mikroserwisami CryptoKey oraz CryptoMsg.
Jest to pośrednik przetwarzający odpowiedzi z bazy danych i poleceń przesyłanych przez klienta
aplikacji.
Implementacja funkcjonalności warstwy klienckiej została wykonana przy pomocy frameworka Vue. 
Aplikacja Mist umożliwia tworzenie wiadomości, które po określonym czasie lub po przeczytaniu znikają z bazy danych.
Dla każdej wiadomości generowany jest specjalny identyfikator, który umożliwia odczytanie wiadomości przez innego użytkownika.
