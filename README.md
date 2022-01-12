# Ejemplos-Utilidades

En este repositorio encontrarás ejemplos, utilidades y código de prácticas para diferentes tecnologías como Maven, Java o JavaFX.
Hay proyectos que repasan ciertos conceptos de Java y otros que sirven a modo de ejercicio práctico (recordatorio de como se hacen
las cosas) como configuraciones de perfiles de Maven, mútiples POM, ejemplos de consumo de Apis, etc...

Intentará estar ordenado y con su correspondiente documentación para cada proyecto.

#### Creado por carky12

## Índice

- [ApiRest en Android](#apirest-en-android).


## ApiRest Android

Utilizamos la mítica api de pokemon (https://pokeapi.co/) para consumir los resultados y cargarlos en un RecyclerView. El proyecto se contruye
en las capas de servicio, modelo y otra capa a mayores para realizar el adaptador y la gestión desde el MainActivity.

En la capa de modelo definimos la entidad Pokemon y otra entidad para moldear la respuesta recibida desde la API (la moldearemos en un ArrayList de entidades
Pokemon).
En la capa de servicio definimos el Call de la librería retrofit para ser invocado desde el Activity.

La lógica desde el activity constará de la creación de la llamada utilizando retrofit y cargar desde el offset 0 al iniciar la aplicación.
También constará de un evento en el Scroll del RecyclerView para cargar más elementos desde el offset anterior y sumando de 20 en 20 en cada carga.

Además se utilizará GsonConverterFactory.create() para parsear la respuesta de la API.

## ApiRest Android Firebase

Proyecto en el que se implementa un CRUD en Android utilizando como base de datos Firebase de Google.

Se crea una colección Persona para una base de datos Realtime Database de Firebase. La colección estará vinculada a las clases del modelo de la aplicación. 
El objeto Persona tendrá 5 atributos (uuid, nombre, apellido, correo y contraseña). El uuid será el id que utilizaremos para realizar las operaciones CRUD.

Desarrollo sobre el Main Activity. Se implementa un menú superior para realizar las operaciones del CRUD. Se implementan 4 campos en pantalla además 
de un ListView para listar los registros de la base de datos. Cuando se pulse en algún elemento de la lista se rellenan los textview con los valores del registro pulsado.

Se implementan los métodos del CRUD a través de la API databaseReference de Firebase. Se inicializa Firebase en el método "iniciarFirebase" del activity main.

Opcionalmente se prepara la aplicación para que reciba notificaciones tanto en primer plano como en segundo plano utilizando la tecnología 
**Cloud Messaging de Firebase** :+1. Se prepara la aplicación para recibir mensajes personalizados por token o por tema al que los usuarios estén suscritos.

## ApiRest Express MongoDB Async-Await

Ejemplo en el que se utiliza la librería Express para, de forma asíncrona, realizar el consumo de una Api creada sobre una base de datos
en local usando el motor de MongoDB.

Para el ejemplo se modelan las entidades usuario y coche, con una relación 1-n desde usuarios a coches, es decir un usuario puede contener
una lista de coches y un coche sólo puede tener un usuario asignado.

Es imprescindible tener instalado MongoDB en local, además se utiliza el puerto 3000 para la aplicación. 

La lógica de la aplicación se encuentra en el route correspondiente al users.js en el que se definen todas las operaciones del CRUD para
dar forma a la API y proveer la información. La forma de hacer los métodos es a través de async await para romper la funcionalidad asíncrona.

## ApiRest MongoDB

Proyecto de Spring Boot para desarrollo de una API Rest sobre MongoDB. Necesario tener instalado MongoDB en local.

Guía **resumen** de uso de MongoDB:

- Para aplicaciones de crecimiento rápido.
- Para aplicaciones con servidor en la nube.
- Cuando necesitamos montar una base de datos lo más rápido posible.
- Cuando los datos no van a tener la misma estructura.
- Cuando la información es muy dinámica.
- Cuando nuestra aplicación presente muchos usuarios al mismo tiempo.

Mongo Server está compuesto por bases de datos, dentro de las cuales se encuentran las colecciones y dentro de éstas es donde tenemos los documentos.
Las colecciones son los equivalentes NO-SQL a las tablas de las bases de datos relacionales. Los documentos serían los registros de esas tablas.
Los documentos son pares de datos clave-valor. Los nombres de los campos siempre son cadenas de texto y los valores pueden ser string, number, 
array (listas), date, boolean, object, etc...

Los documentos son una abstracción de una entidad/objeto de la vida real.

Ejemplo de documento Persona:

```
{
"nombre":"Ronaldo",
"apellido":"Nazario",
"eddad":21
}
		
```

Las colecciones representan un conjunto de documentos de una misma entidad. Por ejemplo una colección va a tener todos los usuarios, personas, productos, etc...

###### Gestión de BBDD

- use nombre bbdd: nos posicionamos en la base de datos. Si la base de datos no está creada el motor la crea.
- db: saber en que base de datos estamos posicionados.
- show dbs: muestra una lista con todas las bases de datos (solo muestra bases de datos no vacías).
- db.usuarios.insert({}): esta es la forma implícita de crear la colección usuarios. Si no existe se crea.
- db.createCollection("productos"): esta es la forma explícita de crear la colección productos.
- show collections: muestra todas las colecciones que tenemos en la base de datos.
- db.productos.drop(): borra la colección productos.
- db.dropDatabase(): borra la base de datos en la que estamos situados.

###### Consultas

- db.productos.find(): devuelve los documentos de la colección productos.
- db.productos.find().pretty(): devuelve los documentos de la colección productos de forma formateada (como si fuese un JSON formateado).
- db.producgtos.update({"id": "1"}, {$set: {'valor': 20.45}}): sentencia para actualizar el campo valor del documento con primer campo "id" cuyo valor es "1".
- db.producgtos.update({"id": "1"}, {$set: {'valor': 20.45}}, {multi: true}): sentencia para actualizar todos los documentos que cumplan la condición del primer campo.
- db.productos.deleteOne({"id": "1"}): borra un documento cuyo campo "id" tenga valor "1".

###### Consultas con parámetros

- db.products.find({"valor": 15}): devuelve todos los productos que tienen valor 15.
- db.productos.find({"valor": {$lt: 16}}): devuelve los productos que tienen valor menor que 16.
- db.productos.find().limit(1): se limita la consulta a un resultado.
- db.productos.find().sort({valor: 1}): devuelve los documentos ordenados de menor a mayor. Para ordenar de menor a mayor habría que indicar -1

Las operaciones básicas son:

- igualdad: {"campo": 0}
- menor que: {"campo": {$lt: 15}}
- menor o igual que: {"campo": {$lte: 15}}
- mayor que: {"campo": {$gt: 15}}
- mayor o igual que: {"campo": {$gte: 15}}
- no es igual: {"campo": {$ne: 15}}
- and: { {key: value1, key2: value2} }
- or: {$or: [{key1: value1}, {key2: value2}]}
- and + or: {key1: value1, $or: [{key2: {$lt: value2}, {key3: value 3}}]}

## Colecciones en Java

Proyecto de ejemplo de uso de la API collections en Java.

Vemos el uso de la interfaz para ordenar listas de enteros y listas de Strings. Además vemos ejemplos de ordenación de listas de objetos sobreescribiendo el método
CompareTo en la definición del objeto. En este método es donde implementamos la condición y campo de comparación.

Hay ejemplos de HashMap que no permite almacenar dos valores con la misma clave, y la ordenación es de forma aleatoria, aunque si la clave
es un integer lo ordenará ascendentemente por valor de clave. De los valores duplicados se queda con el último.

Hay ejemplos con TreeMap que no admite duplicados y ordena los valores de mapa de forma ascendente y hay ejemplos con LinkedHashMap que no admite duplicados 
y ordena los valores en función de en qué orden se agregan a la lista.

A modo de resumen podemos ver los siguientes elementos de la API Collections:

###### SET: 
 
- No permiten duplicados
- Uso sencillo de add
- No tienen acceso aleatorio
- Poco eficientes ordenando
- Los iterators sólo modifican hacia adelante
- Tipos: 
  - TreeSet: ordenado pero poco eficiente. De igual implementación que el hashset pero permite ordenar los elementos aunque no de forma eficiente. Por defecto se ordenan alfabéticamente.
  - LinkedHashSet: ordenación por entrada, eficiente al acceder, no eficiente al agregar 
  - HashSet: es de rápido acceso, no permite duplicados (utiliza los métodos equals y hashCode del objeto contenido en la lista), no permite ordenar los elementos, no tiene acceso aleatorio y no se puede borrar elementos de la lista mientras estamos recorriendolo con un bucle for (se podría borrar si iteramos los elementos de la lista con un iterador.
  - EnumSet: para tipos enumerados

###### LIST:

- No hay restricción con agregar y eliminar elementos
- Permiten ordenar (.sort())
- Tienen acceso aleatorio
- ListIterator modifica en cualquier dirección (no sólo hacia adelante)
- Tipos: 
  - ArrayList: poco eficientes en la eliminación de elementos. Al eliminar un elemento se desplazan todos los posteriores
  - LinkedList: almacena los elementos en nodos que no tienen por que estar adyacentes. Los nodos guardan el dato y 
    un enlace al elemento posterior y anterior). Si se elimina un elemento sólo hay que actualizar los enlaces del nodo. Son
    listas más eficientes. Muy eficiente para la eliminación y modificación de elementos. Soportan listIterator para iterar los elementos

###### MAPS:
		
- Asocian clave-valor
- No se pueden repetir las claves
- Tienen acceso aleatorio
- ListIterator modifica en cualquier dirección (no sólo hacia adelante)
- Tipos: 
  - HashMap: muy eficiente en lectura y escritura pero no permite ordenación
  - LinkedHashMap: ordenado por inserción, perimte ordenar por uso, eficiente lectura y poca eficiente de escritura
  - HashTable: obsoleto
  - TreeMap: ordenado por clave y poco eficiente en sus operaciones

## Ejemplos Básicos con SpringBoot

Proyectos de ejemplo de creación de dos proyectos con SrpingBoot.

Uno para un arquetipo de proyecto web y otro para un arquetipo de proyecto de consola.

## Expresiones Lambda

Proyecto con la sintáxis básica introducida en Java 8 para expresiones lambda. Los ejemplos comparan la sintaxis clásica con las ventajas de las
expresiones lambda. Los ejemplos son básicos y se centran en una operación aritmética básica y en la ordenación de una lista.

Las ventajas de las expresiones lambda no sólo son a nivel de sintaxis si no que se prodría profundizar en que son parte del paradigma de programación
declarativa versus al paradigma de programación imperativo. Java 8 se basa fuertemente en las expresiones lambda que son funciones anónimas, esenciales para 
entender la programación declarativa.

## Programación Genérica en Java

Proyecto en el que se ven ejemplos muy básicos del uso de tipos genéricos en Java. 

La convención de nombres para los tipos de parámetros es:
- E:  Elemento
- K: Key
- N: Number
- T: Tipo
- V: Value
- S, U, V, etc: Más tipos...

El objetivo de los genericos es introducir seguridad del tipado y evitar casteos innecesarios. Por ejemplo las listas por defecto
no son safety type (seguras frente al tipado), es decir se pueden guardar Strings o enteros. Con los genéricos evitamos esto y 
añadimos la ventaja de no tener que hacer un casteo al recuperar un elemento de la lista. En contraposición los arrays por defecto si que son safety type.

## Ejemplo Básico con Spring

Proyectos de ejemplo de creación de un proyecto muy básico con Spring. Se definen dos controladores que capturan las peticiones para mostrar
el contenido de una lista a modo de BBDD en la parte del JSP.

