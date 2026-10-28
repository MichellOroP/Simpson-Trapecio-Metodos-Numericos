# Simpson-Trapecio-Metodos-Numericos
Implementación en Java de los métodos Simpson 1/3 Compuesto y Trapecio Compuesto, con análisis comparativo de convergencia.  Copiar


# Simpson 1/3 Compuesto vs. Trapecio Compuesto

## Información del proyecto

**Institución:** Instituto Tecnológico Superior de Xalapa  
**Carrera:** Ingeniería en Sistemas Computacionales  
**Materia:** Métodos Numéricos (SCC-1017)  
**Actividad:** Tarea 1 - Unidad 4  
**Docente:** Víctor Hugo Vásquez Herrera  

## 1. Descripción

Este proyecto consiste en la implementación en Java de dos
métodos de integración numérica: Trapecio Compuesto y
Simpson 1/3 Compuesto.

El propósito es comparar la precisión, el número de
iteraciones y la cantidad de subintervalos necesarios
para alcanzar una tolerancia determinada.

La implementación utiliza un proceso iterativo que
duplica el número de subintervalos hasta que la
diferencia absoluta entre dos aproximaciones
consecutivas sea menor o igual a la tolerancia.

## 2. Métodos implementados

### Trapecio Compuesto

Este método aproxima el área bajo una curva mediante
la suma de áreas de trapecios.

Su expresión matemática es:

T = (h/2) [f(x0) + 2*f(x1) + ... + 2*f(xn-1) + f(xn)]

Donde:

- h = (b-a)/n
- a: límite inferior de integración.
- b: límite superior de integración.
- n: número de subintervalos.

Los puntos interiores tienen coeficiente 2 porque
son compartidos por dos trapecios consecutivos.

### Simpson 1/3 Compuesto

Este método aproxima la función mediante segmentos
parabólicos que pasan por tres puntos consecutivos.

Su expresión matemática es:

S = (h/3) [f(x0) + 4*f(x1) + 2*f(x2)
           + 4*f(x3) + ... + 4*f(xn-1) + f(xn)]

El número de subintervalos debe ser par y positivo.

Los coeficientes siguen el patrón:

1, 4, 2, 4, 2, ..., 4, 1

Los puntos interiores impares tienen coeficiente 4.
Los puntos interiores pares tienen coeficiente 2.

## 3. Función utilizada

Para comparar ambos métodos se utiliza:

f(x) = x^2

Intervalo de integración:

a = 0
b = 2

Tolerancia:

0.000001

La integral exacta es:

Integral de x^2 desde 0 hasta 2 = 8/3

Valor exacto aproximado:

2.6666666667

## 4. Estructura del proyecto

```text
Simpson-Trapecio-Metodos-Numericos/
|
|-- src/
|   |-- dif_e_Integracion/
|       |-- Main.java
|       |-- SimpsonCompuesto.java
|       |-- TrapecioCompuesto.java
|
|-- README.md
```

Descripción de los archivos:

- Main.java: ejecuta ambos métodos y compara resultados.
- SimpsonCompuesto.java: implementa Simpson 1/3 Compuesto.
- TrapecioCompuesto.java: implementa Trapecio Compuesto
  y proporciona la función matemática compartida.
- README.md: contiene la documentación del proyecto.

## 5. Requisitos

Para ejecutar el proyecto se necesita:

- Java JDK 17 o superior.
- Visual Studio Code o un IDE compatible con Java.
- Terminal PowerShell, CMD o equivalente.

El proyecto fue probado con:

- Java JDK 21.0.11 LTS.
- Compilador javac 21.0.11.
- Visual Studio Code.
- Windows con PowerShell.

## 6. Instrucciones de compilación y ejecución

### Paso 1. Descargar el repositorio

Abrir el repositorio en GitHub:

https://github.com/MichellOroP/Simpson-Trapecio-Metodos-Numericos

Seleccionar:

Code > Download ZIP

Extraer el archivo descargado.

### Paso 2. Abrir en Visual Studio Code

Abrir Visual Studio Code.

Seleccionar:

Archivo > Abrir carpeta

Elegir la carpeta que contiene src y README.md.

### Paso 3. Abrir la terminal

Seleccionar:

Terminal > Nuevo terminal

Verificar Java:

```powershell
java -version
```

Verificar el compilador:

```powershell
javac -version
```

### Paso 4. Compilar el proyecto

Desde la carpeta que contiene src, ejecutar:

```powershell
javac -d . .\src\dif_e_Integracion\Main.java .\src\dif_e_Integracion\SimpsonCompuesto.java .\src\dif_e_Integracion\TrapecioCompuesto.java
```

Si no aparecen errores, la compilación fue exitosa.

### Paso 5. Ejecutar el programa

Escribir:

```powershell
java dif_e_Integracion.Main
```

El programa mostrará los resultados de ambos métodos.

## 7. Resultados de ejecución

Los siguientes resultados fueron obtenidos al ejecutar
el proyecto en Visual Studio Code.

```text
====================================
     METODOS DE INTEGRACION
====================================

Funcion: f(x) = x^2
Intervalo: [0.0, 2.0]
Tolerancia: 1.0E-6

--- TRAPECIO COMPUESTO ---
Iteraciones: 11
Subintervalos (n): 2048
Error estimado: 0.000000953674
Resultado: 2.6666669846

--- SIMPSON 1/3 COMPUESTO ---
Iteraciones: 1
Subintervalos (n): 4
Error estimado: 0.000000000000
Resultado: 2.6666666667

--- ANALISIS COMPARATIVO ---
Valor exacto: 2.6666666667
Error absoluto Trapecio: 0.0000003179
Error absoluto Simpson: 0.0000000000

Comparacion finalizada.
```

## 8. Comparación de resultados

| Característica | Trapecio | Simpson 1/3 |
|---|---:|---:|
| Iteraciones | 11 | 1 |
| Subintervalos | 2048 | 4 |
| Resultado | 2.6666669846 | 2.6666666667 |
| Error absoluto real | 0.0000003179 | Aproximadamente 0 |

Para esta función, Simpson requirió 512 veces menos
subintervalos que Trapecio Compuesto.

El método de Simpson también necesitó menos
iteraciones para cumplir el criterio de convergencia.

Estos resultados corresponden específicamente
a la función y tolerancia utilizadas.

## 9. Análisis conceptual

### ¿Por qué Simpson requiere un número par de subintervalos?

La Regla de Simpson 1/3 utiliza una parábola para
aproximar la función sobre cada pareja de
subintervalos consecutivos.

Cada aplicación necesita tres puntos:

x0, x1 y x2.

Por esta razón, el número total de subintervalos
debe ser par para que todos puedan agruparse
en parejas sin dejar intervalos incompletos.

### ¿Por qué se alternan los coeficientes?

En Simpson, los puntos interiores impares tienen
coeficiente 4 porque son los puntos centrales
de cada segmento parabólico.

Los puntos interiores pares tienen coeficiente 2
porque son extremos compartidos entre dos
segmentos parabólicos consecutivos.

En Trapecio Compuesto, cada punto interior
pertenece a dos trapecios, por lo que todos
los puntos interiores tienen coeficiente 2.

### ¿Qué método fue más eficiente?

Para f(x) = x^2, Simpson fue más eficiente porque
la aproximación parabólica representa exactamente
una función cuadrática, salvo errores de redondeo.

Trapecio Compuesto utiliza aproximaciones lineales,
por lo que necesita una mayor cantidad de
subintervalos para alcanzar una precisión comparable.

## 10. Conclusión

En esta práctica se implementaron y ejecutaron
correctamente los métodos Trapecio Compuesto y
Simpson 1/3 Compuesto utilizando Java.

Los resultados permitieron comprobar que Simpson
ofrece mayor precisión y requiere menos
subintervalos para la función cuadrática analizada.

También se verificó la importancia de utilizar
un número par de subintervalos y aplicar
correctamente los coeficientes de Simpson.

El proyecto permite observar cómo diferentes
métodos numéricos pueden aproximar una misma
integral con distinta eficiencia.

## 11. Repositorio de GitHub

https://github.com/MichellOroP/Simpson-Trapecio-Metodos-Numericos


https://github.com/MichellOroP/Simpson-Trapecio-Metodos-Numericos
