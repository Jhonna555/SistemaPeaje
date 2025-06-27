Sistema de Peaje - Aplicación Java con Interfaz Gráfica
📝 Descripción
Este proyecto es una aplicación de escritorio desarrollada en Java con interfaz gráfica usando Swing. Permite gestionar una estación de peaje donde se pueden registrar vehículos (carros, motos, camiones), calcular el valor del peaje según el tipo de vehículo, mostrar el total acumulado por peaje y guardar la información en un archivo JSON usando la librería Gson.

🎯 Objetivo del programa
El objetivo principal es ofrecer una herramienta interactiva que permita:

Registrar vehículos por tipo y placa.
Calcular automáticamente el valor del peaje.
Asociar cada peaje a un cantón.
Ver el total acumulado por peaje.
Guardar los datos en formato JSON de forma automática.
⚙️ Principales funcionalidades
1. Registro de vehículos
Cada vehículo se ingresa con su placa.
El usuario puede seleccionar si es un Carro, Moto o Camión.
Si es camión, se debe ingresar también el número de ejes.
2. Cálculo del peaje
Carro: $2
Moto: $1
Camión: $1 por eje
3. Peajes asociados a cantones
El sistema tiene 10 peajes predefinidos (ej. Ambuqui → Ibarra, Machachi → Mejía, etc.).
4. Visualización automática
Al seleccionar un peaje se muestra:
Su cantón.
El total recaudado.
El listado de vehículos registrados.
5. Almacenamiento en JSON
Los datos son persistentes y se guardan automáticamente en vehiculos.json usando Gson.
▶️ Instrucciones para ejecutar el programa
✅ Requisitos previos
Tener Java JDK 8 o superior instalado.
Descargar la librería gson-2.x.jar desde:
https://github.com/google/gson
🧪 Compilación
Ubica todos los archivos .java en un mismo directorio junto con gson-2.x.jar.

En macOS / Linux:
javac -cp ".:gson-2.x.jar" *.java
En Windows:
javac -cp ".;gson-2.x.jar" *.java
🚀 Ejecución
En macOS / Linux:
java -cp ".:gson-2.x.jar" SistemaPeajeGUI
En Windows:
java -cp ".;gson-2.x.jar" SistemaPeajeGUI
📷 Ejemplo de uso
Peaje: Oyacoto – Cantón: Quito
Moto – PQH095 – $ 1
Carro – PBC362 – $ 2

Total Recolectado: $ 3
👨‍💻 Datos del desarrollador
Nombre: Jhonnatan Francisco Salazar Cadena
Institución: Universidad Internacional del Ecuador
Carrera: Ingeniería en Software (Modalidad En Línea)
Materia: Desarrollo de Software
Fecha: Junio 2025
🛠 Tecnologías utilizadas
Lenguaje: Java
Interfaz Gráfica: Java Swing
Persistencia de datos: Gson (Google JSON library)
🧠 Notas adicionales
Este proyecto fue desarrollado como práctica para reforzar el uso de programación orientada a objetos, diseño de interfaces gráficas y manejo de archivos en Java. Puedes contribuir o adaptar este código a tus necesidades.
