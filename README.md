# CallsApiRestFul

Una API RESTful en Java para gestionar datos de llamadas realizadas desde números de teléfono móvil.

## Funcionalidades

1. **Agregar una Nueva Llamada**  
   Permite agregar una llamada con los datos proporcionados y almacenarla.

2. **Calcular el Valor de una Llamada**  
   Calcula el valor de la llamada aplicando recargos según el tipo:
   - Mismo operador: sin recargo.
   - Otro operador: 5% de recargo.
   - Nacional: 10% de recargo.
   - Internacional: 15% de recargo.

3. **Totalizar el Valor de las Llamadas**  
   Suma el costo total de todas las llamadas, considerando los recargos aplicables.

4. **Totalizar Minutos Consumidos**  
   Calcula y muestra la cantidad total de minutos consumidos, clasificados por tipo de llamada.

5. **Visualizar Datos de Llamadas**  
   Permite la visualización de llamadas según diversos criterios de búsqueda.

## Instalación
1. Clona el repositorio:
    ```sh
    git clone https://github.com/tu_usuario/tu_repositorio.git
    ```
2. Navega al directorio del proyecto:
    ```sh
    cd tu_repositorio
    ```
3. Asegúrate de tener Java instalado (Java 8+).
4. Ejecuta la aplicación:
    ```sh
