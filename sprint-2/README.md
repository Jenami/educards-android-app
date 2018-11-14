## Notas iniciales:

- El equipo tuvo conflictos para decidir las tareas que se debía priorizar para la entrega por lo que fue dificil un trabajo coordinado.
- Las tareas estimadas para el próximo Sprint no se decidieron de manera acoorde.

## Tareas Comprometidas
|  Tarea | Participantes | Tiempo aproximado | Sprint correpondiente | Estado |
|  ------ | ------ | ------ | ------ | ------ | ------ |
|  Documento de Sprint | Jimena | 3hs | 2 | Completo |
|  Subir Sprint como MD | Joaquin | 2hs | 2 | Completo |
|  Agregar Travis | Liza + Jimena | 9hs | 2 | Incompleto |
|  Agregar Codecov | Liza + Jimena | 9hs | 2 | Incompleto |
| Arrastrar las carta a su posición | Joaquin + Jimena | 3hs | 1 | Incompleto |
| CICD en GitLab | Jimena + Brian | 10hs | 1 | Completo |

## Otras tareas realizadas
| Descripción de tarea | Quien lo hizo | Tiempo en horas | Estado |
|  ------ | ------ | ------ | ------ | ------ |
|  Logo | Joaquin | 2hs | 2 | Completo |
|  Estilos de la app | Joaquin | 3hs | 2 | Completo |
| Inicialización API | Liza + Brian | 8hs | 1 | Completo |
| Reordenar los repositorios de trabajo | Brian | 1,5hs | Completo |
| Modelo de casos de uso del juego | Camila | 4hs | Completo |
| Refactor del modelo | Camila | 2hs | Completo |
|  Review de VSM | Liza + Jimena | 5hs | 1 | En proceso |

## Retrospectivas

| 😢 | 😀 | 💫 |
| ------ | ------ | ------ |
| Falta de comunicación | Uso de nuevas tecnologías |  | 
| Problemas de ego |  |  |

## Tareas estimadas para el próximo Sprint

 - Integrar el Modelo con la Aplicación
    - Definir el Modelo de estado para la aplicación, que pueda guardar el Player y el Game.
    - Asignar el Player en la primera pantalla con el input.
    - Asignar el Game en la pantalla del juego al estado.

 - Interfáz parte de las cartas (requiere Datos)
    - Armar La carta como objeto que extiende un fragmento.
    - Refactorizar el juego para que use este nuevo objeto.
    - Armar Sector donde se dejan las cartas (mesa) (extiende de fragment y puede recibir Fragments de cartas).
    - Armar deck (contiene las cartas en la mano).
    - Agregar intercambio de cartas de *Mesa* a *Deck*.
    - Refactor con estas 3 nuevas clases.

