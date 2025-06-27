# Sistema de Peaje 🚗🏍️🚚

Este proyecto Java implementa un sistema de gestión de peaje con una interfaz gráfica (GUI) en Swing. Permite registrar vehículos (carros, motos, camiones), calcular el total recaudado por peaje y guardar la información en un archivo JSON usando la biblioteca Gson.

---

## 📁 Estructura del Proyecto

```
SistemaPeaje/
├── Vehiculo.java
├── Carro.java
├── Moto.java
├── Camion.java
├── Peaje.java
├── SistemaPeajeGUI.java
├── gson-2.x.jar          <- debes añadir esta librería a tu classpath
└── vehiculos.json        <- se generará automáticamente al guardar datos
```

---

## ✅ Requisitos

- Java JDK 8 o superior
- Gson 2.x (descargar desde: https://github.com/google/gson)

---

## 📦 Instrucciones de Compilación

1. **Ubica todos los archivos `.java` en el mismo directorio.**

2. **Descarga `gson-2.x.jar`** y colócalo en el mismo directorio.

3. **Compila todos los archivos Java desde terminal:**

### En macOS / Linux:

```bash
javac -cp ".:gson-2.x.jar" *.java
```

### En Windows:

```bash
javac -cp ".;gson-2.x.jar" *.java
```

---

## ▶️ Ejecución del Programa

### En macOS / Linux:

```bash
java -cp ".:gson-2.x.jar" SistemaPeajeGUI
```

### En Windows:

```bash
java -cp ".;gson-2.x.jar" SistemaPeajeGUI
```

---

## 💾 Uso del Programa

- Selecciona un **peaje** de la lista.
- Automáticamente se mostrará su **cantón** y **total recolectado**.
- Ingresa la **placa del vehículo** y su **tipo**.
- Si es un camión, indica también el **número de ejes**.
- Presiona **GUARDAR** para registrar y actualizar.
- Los datos se guardan automáticamente en `vehiculos.json`.

---

## 📂 Archivo JSON

Todos los datos se almacenan en el archivo `vehiculos.json`, el cual se sobreescribe con cada guardado.

---

## ✍️ Autor

Proyecto creado por Jhonnatan Francisco Salazar Cadena.
