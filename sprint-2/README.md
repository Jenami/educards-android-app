## Tareas Comprometidas y status
|  Tarea | Quien lo hizo | Puntaje | Cuanto tardó | Sprint | Estado |
|  ------ | ------ | ------ | ------ | ------ | ------ |
|  Documento de Sprint | Jimena | 3 |  | 2 | Listo |
|  Subir sprint como MD | Pato | 2 |  | 2 | Listo |
|  VSM | Jimena | 3 |  | 2 | Listo |
|  Logo | Pato | 2 |  | 2 | Listo |
|  Estilos de la app | Pato | 3 |  | 2 | Listo |
|  Agregar Travis y Codecov | Liza + Jimena | 7 | 9hs | 2 | En proceso |
|  Review de VSM | Liza | 3 |  | 2 | En proceso |
## Tareas para el siguiente Sprint
Tareas y subtareas:
 - Integrar el Modelo con la Aplicación
    - Definir el Modelo de estado para la aplicación, que pueda guardar el Player y el Game (2pts)
    - Asignar el Player en la primera pantalla con el input (2pts)
    - Asignar el Game en la pantalla del juego al estado (3pts)

 - Modelo
    - revertir el borrado de los tests, y agregar mockito como requisito de el modulo (3pts)

 - Datos
    - Guardar los datos de las cartas en algun formato (json) y levantar la lista en forma de Cards (5pts)

 - Interfáz parte de las cartas (requiere Datos)
    - Armar La carta como objeto que extiende un fragmento (4pt)
    - Refactorizar el juego para que use este nuevo objeto (2pts)
    - Armar Sector donde se dejan las cartas (mesa) (extiende de fragment y puede recibir Fragments de cartas)(3pts)
    - Armar deck (contiene las cartas en la mano) (2pts)
    - agregar intercambio de cartas de *Mesa* a *Deck* y  (6pts)
    - Refactor con estas 3 nuevas clases (3pts)

## Estado del servidor de Integración Continua
Travis activado en la App de Android, falta CodeCov
## Retrospectiva del sprint
High: Puntos sobresalientes que buscamos seguir ejecutando.
Low: Puntos flojos que nos perjudicaron en la entrega de lo comprometido.