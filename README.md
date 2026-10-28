# Simpson-Trapecio-Metodos-Numericos
Implementación en Java de los métodos Simpson 1/3 Compuesto y Trapecio Compuesto, con análisis comparativo de convergencia.  Copiar


# Simpson 1/3 Compuesto vs. Trapecio Compuesto

## Descripcion

Proyecto desarrollado en Java para la materia de Metodos
Numericos del Instituto Tecnologico Superior de Xalapa.

El objetivo es implementar los metodos de integracion
numerica Trapecio Compuesto y Simpson 1/3 Compuesto,
analizando su precision, convergencia y eficiencia.

## Metodos implementados

### Trapecio Compuesto

Aproxima el area bajo una curva mediante trapecios.

Formula:

T = (h/2) [f(x0) + 2*sum(f(xk)) + f(xn)]

Donde:

- h = (b-a)/n
- a y b son los limites de integracion
- n es el numero de subintervalos

### Simpson 1/3 Compuesto

Aproxima el area mediante segmentos parabolicos.

Formula:

S = (h/3) [f(x0) + 4*sumaImpares
            + 2*sumaPares + f(xn)]

El numero de subintervalos debe ser par.

## Funcion de prueba

f(x) = x^2

Intervalo: [0, 2]

Tolerancia: 0.000001

Valor exacto de la integral: 8/3

## Estructura del proyecto

Simpson-Trapecio-Metodos-Numericos/
    src/
        dif_e_Integracion/
            Main.java
            TrapecioCompuesto.java
            SimpsonCompuesto.java
    README.md

## Requisitos

- Java JDK 17 o superior
- Visual Studio Code o cualquier IDE compatible
- Terminal de Windows, Linux o macOS

## Compilacion y ejecucion

1. Descargar o clonar el repositorio.

2. Abrir una terminal en la carpeta principal.

3. Compilar los archivos Java:

```bash
javac -d . src/dif_e_Integracion/*.java
```

4. Ejecutar el programa:

```bash
java dif_e_Integracion.Main
```

En Windows PowerShell tambien pueden utilizarse
los comandos anteriores.

## Ejemplo de salida esperada

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
```

Los resultados son ilustrativos y deben verificarse
mediante la ejecucion del programa.

## Analisis comparativo

Simpson 1/3 Compuesto utiliza aproximaciones
parabolicas y requiere un numero par de subintervalos.

Trapecio Compuesto utiliza aproximaciones lineales.

Para funciones polinomicas de grado dos, Simpson
puede obtener resultados exactos salvo errores
de redondeo, mientras que Trapecio presenta
un error de aproximacion.

## Autor

Proyecto academico de Metodos Numericos.

## Repositorio

https://github.com/MichellOroP/Simpson-Trapecio-Metodos-Numericos
