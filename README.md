# structure-images
Das Programm verschiebt oder kopiert die Dateien des konfigurierten Source-Ordner (structure-images.source-folder) in ein Unterverzeichnis des konfigurierten root-target-Ordners (structure-images.target-parent-folder). Das Unterverzeichnis wird
anhand des Aufnahmedatums des jpegs ermittelt (default pattern:yyyy_MM_dd). Bei Bedarf kann kopiert statt verschoben werden

Bsp.-Call aus Windowes heraus: 
Batch-File mit:
---
d:
cd\
cd structure-images
call C:\Programme\Java\java-se-8u40-ri\bin\java.exe -Dstructure-images.source-folder=d:\\temp\\Bilder -Dstructure-images.target-parent-folder=d:\\temp\\Bilder -jar structure-images-0.0.1-SNAPSHOT.jar
pause
---