#########
#READ ME#
#########

Zunächst muss die IDE ausreichend mit Plugins ausgestattet werden.

	1. NetBeans runterladen und installieren (oder Portable)
	2. JDK runterladen und installieren
	3. Apache Tomcat runterladen und installieren
	3. Um nun entwickeln zu können, muss NetBeans erst die JDK hinzugefügt werden.
	   Dazu die Datei "../NetBeans/etc/netbeans.conf" öffnen und nach dem Eintrag
	   "netbeans_jdkhome" suchen. Sollte dieser auskommentiert sein die Kommentarzeichen
	   entfernen und den Pfad auf die runtergeladene JDK ändern ("../JDK")
	4. Wenn nötig, Java und Java EE Plugins installieren

Nun ist NetBeans zum generellen Entwickeln in Java bereit, wir müssen
also nurnoch das Projekt aus dem Repository bekommen.

	5. Bei Git registrieren und von dem Repositoryinhaber berechtigen lassen
	6. Im NetBeans in der Menüleiste "Team"->"Git"->"Clone" auswählen.
	7. Repository URL ist "https://github.com/Smadback/KMitSystem.git", dann nurnoch die
	   Benutzerdaten von Git eintragen und auf "weiter" klicken. Abschließend ein neues Projekt
	   anlegen lassen.
	8. Rechtsklick auf das Projekt und "Resolve Problems", dort dann einen 
	   neuen Server hinzufügen (als Pfad den Installationsordner von dem Apache Tomcat Server)
	   und diesen dem Projekt zuweisen.
	9. Fertig
	
Folgendermaßen werden commits bei Git getätigt:
	
       10. Wichtig zu wissen ist, dass man zunächst nur ein lokales Git-Repository hat. Das bedeutet,
       	   dass Dateien die per "Rechtsklick->Git->Commit" auch nur lokal erfasst werden. Um sie in das
	   Repository auf dem Server zu bekommen ist nun noch ein "Rechtsklick->Git->Remote->Push" nötig.
       11. Dateien oder ganze Ordner werden per "Rechtsklick->Git->Checkout->Checkout Files" aus dem
           Repository geholt und dann lokal aktualisiert.

