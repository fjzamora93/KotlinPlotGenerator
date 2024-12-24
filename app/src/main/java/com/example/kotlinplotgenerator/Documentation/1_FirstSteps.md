# Primeros pasos con JetpackCompose

### Separación de lógica y elementos visuales

- La parte lógica de la actividad está dentro de una Clase de Kotlin denominada "NombreAcitivyt.kt" y se crea como clase.
- Los elementos visuales (screen) irán en un archivo de kotlin denominado "NombreScreen.kt" y se crea como archivo de kotlin.


De esta forma, las actividades se encargan de orquestar y preparar las pantallas, mientras que las clases con el sufijo Screen se encargan de la definición de los elementos visuales.

Siempre y cuando el Screen y la Activity estén en la misma carpeta, no será necesario importar nada.