# ***********************************************************************************************
#								= PONTIFICIA UNIVERSIDAD JAVERIANA =
#
#	Autor: J. Corredor Franco
#	Fecha: 8 mayo 2026
#	Introducción a los Sistemas Distribuidos
#
#	Archivo de automatización de compilación Makefile <JAVA>
# ***********************************************************************************************

JAVAC = javac
JAVA = java
PKG = tallerThreads
BIN = bin
SOURCES = *.java

All:
	@mkdir -p $(BIN)
	$(JAVAC) -d $(BIN) $(SOURCES)

secuencial:
	@echo "\n >>> EJECUCIÓN versión Secuencial: <<< \n"
	$(JAVA) -cp $(BIN) $(PKG).Main
	@echo ""


clean:
	$(RM) -r $(BIN)
