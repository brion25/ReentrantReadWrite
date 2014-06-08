ReentrantReadWrite
==================

Ahora les entrego un ejemplo sencillo del uso de la clase ReentrantReadWrite, espero les sea de utilidad.

Basicamente el programa cuenta con 2 "Lectores" y 2 "Escritores". Este programa es meramente demostrativo, Solo 1 "escritor" puede escribir a la vez, mientras este este escribiendo, ningun "escritor" ni "lector" puede acceder, sin embargo si no hay nadie escribiendo, ambos "lectores" pueden acceder.
