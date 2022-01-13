# Ejemplos-Utilidades

En este repositorio encontrarás ejemplos, utilidades y código de prácticas para diferentes tecnologías como Maven, Java o JavaFX.
Hay proyectos que repasan ciertos conceptos de Java y otros que sirven a modo de ejercicio práctico (recordatorio de como se hacen
las cosas) como configuraciones de perfiles de Maven, mútiples POM, ejemplos de consumo de Apis, etc...

Intentará estar ordenado y con su correspondiente documentación para cada proyecto.

#### Creado por carky12

## Índice

- [ApiRest en Android](#apirest-en-android).
- [ApiRest Android Firebase](#apirest-android-firebase).
- [ApiRest Express MongoDB Async-Await](#apirest-express-mongodb-async-await).
- [ApiRest MongoDB](#apirest-mongodb).
- [Colecciones en Java](#colecciones-en-java).
- [Ejemplo Básico con Spring](#ejemplo-básico-con-spring).
- [Ejemplos Básicos con SpringBoot](#ejemplos-básicos-con-springboot).
- [Expresiones Lambda](#expresiones-lambda).
- [Programación Genérica en Java](#programación-genérica-en-java).
- [Maven con JavaFX](#maven-con-javafx).
- [Múltiple POM en Maven](#múltiple-pom-en-maven).
- [Perfiles en Maven](#perfiles-en-maven).
- [Pilas Stack en Java](#pilas-stack-en-java).
- [RegEX](#regex).
- [Scratch](#scratch).
- [Sockets en Java](#sockets-en-java).
- [Threads en Java](#threads-en-java).

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

## Ejemplo Básico con Spring

Proyectos de ejemplo de creación de un proyecto muy básico con Spring. Se definen dos controladores que capturan las peticiones para mostrar
el contenido de una lista a modo de BBDD en la parte del JSP.

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

## Maven con JavaFX

Proyecto en el que lo importante está en el POM, ya que se utiliza un plugin de compilación javafx-maven-plugin para realizar el empaquetado del proyecto JavaFX.

El plugin es:

```
<plugin>
	<groupId>com.zenjava</groupId>
	<artifactId>javafx-maven-plugin</artifactId>
	<version>8.8.3</version>
	<configuration>
		<vendor>MyVendor</vendor>
		<mainClass>app.AppMain</mainClass>
		<appName>MyApp</appName>
		<bundleArguments>
			<icon>${project.basedir}/src/main/resources/img/app.ico</icon>
		</bundleArguments>
	</configuration>
</plugin>
```

Y para las configuraciones de Maven build tenemos 3 opciones:

- jfx:jar: Se realiza el empaquetado en un archivo .jar.
- jfx:native: Se realiza el empaquetado del proyecot en un archivo .exe.
- jfx:run: Se raliza una ejecución del proyecto compilado.

Opcionalmente se puede utilizar el plugin maven-antrun-plugin para realizar configuraciones adicionales antes de realizar el compilado, tales
como crear directorios, cargar datos iniciales, etc...

Con respecto a la aplicación es una simple ventana FXML diseñada con SceneBuilder y una gestión de datos con una base de datos H2.

La página de GitHub del proyecto es la siguiente https://github.com/javafx-maven-plugin/javafx-maven-plugin

## Múltiple POM en Maven

En este proyecto tenemos 3 proyectos. A modo de ejemplo están los proyectos core y web que son proyectos Maven vacíos. En tercer lugar tenemos
un proyecto "EjemploProyectos" en el que tenemos un POM en el que están definidos los dos proyectos anterioes como dependencias de módulo.

```
  <packaging>pom</packaging>
  <name>Ejemplo de varios proyectos</name>
  <description>Ejemplo de varios proyectos</description>
  <modules>
  	<module>proyecto-core</module>
  	<module>proyecto-web</module>
  </modules>
```

Si el proyecto cuenta con diferentes archivos pom se podrá indicar cual usar a la hora de la construcción del proyecto. 
Para ello, desde el IDE Eclipse se ejecuta Run As Maven build... y en el apartado goals se pondrá -f "nombre del pom a usar".xml "acción a realizar". 

Podemos tener varios proyectos agrupados en un mismo proyecto Maven. La ventaja es que se tendrán funcionalidades modularizadas en diferentes proyectos.
Para generar el proyecto padre se creará un proyecto Maven normal. La particularidad es que seleccionaremos pom en la opción <package>.
Para agregar proyectos hijos se crearán proyectos tipo Maven Module, seleccionando el proyecto padre en la configuración inicial del proyecto. 
En el proyecto hijo seleccionaremos jar en la opción <package>
En el pom del proyecto hijo aparecerá la etiqueta <parent> haciendo referencia la proyecto padre.

```
 <parent>
   <groupId>com.example.projects</groupId>
   <artifactId>EjemploProyectos</artifactId>
   <version>0.0.1-SNAPSHOT</version>
 </parent>
```

Será necesario referenciar a los proyectos que sean dependencias en el pom de la aplicación principal. Por ejemplo si tenemos un proyecto padre y uno de 
los hijos tiene arquetipo webapp, podremos indicar en el pom del proyecto webapp las referencias a los otros proyectos hijos. Esto hará que cuando se haga un 
Maven build (goals = package) se generen los jar o war de cada proyecto hijo.

#### Generación de un EAR multiproyecto

Veamos un ejemplo sencillo de un proyecto maven para generar un fichero EAR que tenga un módulo ejb que a su vez depende de librerías java normales.

Para generar todo esto necesitamos estrictamente dos proyectos maven: Encapsularemos todo en 3 proyectos:

- Un proyecto maven con nuestro código, que sea capaz de generar un jar/war con nuestros EJBs. Este proyecto tendrá dependencias de librerías java normales. Llamaremos a este proyecto ejb-module.
- Un proyecto maven que generará el fichero ear para desplegar en nuestro servidor de aplicaciones. Este fichero ear tendrá dentro el jar con nuestra aplicación (el ejb-module) y los jar de las distintas librerías de las que depende. Llamaremos a este proyecto ear-module.
- Para facilitar el proceso de compilado, meteremos estos dos proyectos maven como proyectos hijos de un proyecto maven padre, al que llamaremos ear-project-example. De esta forma, compilando el proyecto maven padre, se compilarán los dos proyectos hijos, primero nuestra aplicación ejb-module, y luego el ear-module que genererá el ear con todo.

En el POM del proyecto EJB tendremos

```
 <parent>
   <groupId>com.examples</groupId>
   <artifactId>ear-project-example</artifactId>
   <version>0.0.1-SNAPSHOT</version>
 </parent>
 <artifactId>ejb-module</artifactId>
 <packaging>ejb</packaging>
 
 <plugin>
   <groupId>org.apache.maven.plugins</groupId>
   <artifactId>maven-ejb-plugin</artifactId>
   <version>2.5.1</version>
   <configuration>
     <ejbVersion>3.1</ejbVersion>
     <archive>
       <manifest>
         <addClasspath>true</addClasspath>
         <classpathPrefix>lib/</classpathPrefix>
       </manifest>
     </archive>
   </configuration>
 </plugin>
```

En primer lugar vemos la referencia al proyecto padre. Y en segundo lugar vemos el plugin para la generación de EJB.

Para el POM del proyecto EAR:

```
 <parent>
   <groupId>com.examples</groupId>
   <artifactId>ear-project-example</artifactId>
   <version>0.0.1-SNAPSHOT</version>
 </parent>
 <artifactId>ear-module</artifactId>
 <packaging>ear</packaging>
 
 <dependencies>
   <dependency>
     <groupId>com.examples</groupId>
     <artifactId>ejb-module</artifactId>
     <version>0.0.1-SNAPSHOT</version>
     <type>ejb</type>
   </dependency>
 </dependencies>
 
 <plugin>
   <artifactId>maven-ear-plugin</artifactId>
   <version>2.10.1</version>
   <configuration>
     <defaultLibBundleDir>lib</defaultLibBundleDir>
     <modules>
       <ejbModule>
         <groupId>com.chuidiang.examples</groupId>
         <artifactId>ejb-module</artifactId>
       </ejbModule>
     </modules>
   </configuration>
 </plugin>
```

Donde vemos en primer lugar la referencia al proyecto padre, en segundo lugar la dependencia al proyecto EJB y en tercer lugar el plugin de generación EAR.

El POM del proyecto padre:

```
 <artifactId>ear-project-example</artifactId>
 <version>0.0.1-SNAPSHOT</version>
 <packaging>pom</packaging>
 <modules>
   <module>ejb-module</module>
   <module>ear-module</module>
 </modules>
```

Vemos las referencias a los proyectos hijos (EJB y EAR).

Para generar el archivo EAR bastará con realizar un mvn package sobre el proyecto padre.

## Perfiles en Maven

Proyecto vacío de funcionalidad pero en el que podemos ver un ejemplo de utilización de los perfiles de Maven aplicado a distintos entornos
de trabajo. Se definen 3 archivos .properties, uno por cada entorno de trabajo en los cuales tendríamos definidos por ejemplo las bases de datos
a utilizar en cada entorno (desarrollo, pruebas y producción por ejemplo).

En estos ficheros de propiedades tenemos configurada una variable de entorno ${env} que nos indicará el entorno en el que trabajar en función
del perfil de Maven seleccionado para la compilación.

Se podrán parametrizar las compilaciones (builds) del proyecto en función de los perfiles definidos en el archivo pom.
Esto es especialmente útil cuando se tienen que parametrizar diferentes configuraciones en función del entorno de desarrollo en el que se esté trabajando.
Se definirán tantos archivos de propiedades (properties o xml) como entornos se deseen usar.

En el archivo pom se definirá una propiedad para el entorno:

```
 <properties>
   <maven.compiler.source>1.8</maven.compiler.source>
   <maven.compiler.target>1.8</maven.compiler.target>
   <env>enviroment.des</env>
 </properties>
```

Esta es la propiedad que se asignará por defecto al proyecto a la hora de hacer build. En la sección build:

```
 <build>
   <filters>
     <filter>src/main/resources/${env}.properties</filter>
   </filters>
   <defaultGoal>install</defaultGoal>
   <resources>
     <resource>
       <directory>src/main/resources</directory>
       <filtering>true</filtering>
       <includes>
         <include>*.properties</include>
       <include>*.xml</include>
       </includes>
     </resource>
   </resources>
   <finalName>sample-eclipse-carlos</finalName>
 </build>
```
 
En esta sección <build> estamos indicando la ruta donde estarán los ficheros de propiedades, además de que se tengan en cuenta tanto archivos properties como xml. 
Adicionalmente se establece el nombre final del artefacto generado.
En la sección <profiles> es donde se definirán los diferentes perfiles. A continuación podemos ver como se establece la propiedad <env> al valor del archivo 
de propiedades adecuado en función del perfil. Opcionalmente se utiliza el p plugin antrun de maven con el objetivo de mostrar un mensaje en la generación del artefacto.
```

<profiles>
   <profile>
     <id>pru</id>
     <properties>
       <env>enviroment.pru</env>
     </properties>      
     <build>
       <plugins>
         <plugin>
           <groupId>org.apache.maven.plugins</groupId>
           <artifactId>maven-antrun-plugin</artifactId>
           <version>1.1</version>
           <executions>
             <execution>								
               <phase>test</phase>
               <goals>
                 <goal>run</goal>
               </goals>
               <configuration>
                 <tasks>
                   <echo>****USANDO ENVIROMENT.PRU.PROPERTIES****</echo>
                 </tasks>									
               </configuration>
             </execution>
           </executions>
         </plugin>
       </plugins>
     </build>
   </profile>
   
   <profile>
     <id>pro</id>
     <properties>
       <env>enviroment.pro</env>
     </properties>      
     <build>
       <plugins>
         <plugin>
           <groupId>org.apache.maven.plugins</groupId>
           <artifactId>maven-antrun-plugin</artifactId>
           <version>1.1</version>
           <executions>
             <execution>								
               <phase>test</phase>
               <goals>
                 <goal>run</goal>
               </goals>
               <configuration>
                 <tasks>
                   <echo>****USANDO ENVIROMENT.PRO.PROPERTIES****</echo>
                 </tasks>									
               </configuration>
             </execution>
           </executions>
         </plugin>
       </plugins>
     </build>
   </profile>
 </profiles>
 ```

## Colas y Stack en Java

Proyecto en el que se usan ejemplos básicos para comprender el uso de las colas (Queue) y las pilas (Stack) en Java.

Una pila puede albergar elementos duplicados, lo importante es el orden de entrada. Para buscar un elemento en la pila (cuenta desde el final de la pila al principio).
Los elementos se eliminan en orden descendente de entrada en la pila (LIFO).

En las colas para un objeto necesitamos indicarle a la cola la prioridad del campo para ello podemos implementar en nuestra clase Persona la interfaz comparable.
Los elementos se eliminan por orden ascendente de entrada en la cola (FIFO).

## RegEx

Proyecto en el que se ven ejemplos de uso de expresiones regulares. Para la parte de JavaScript se puede usar la página https://regexr.com/

Se implementan ejemplos para las siguientes funcionalidades:

- Validación de NIF
- Validación de Email
- Validación de números enteros
- Validación de números reales
- Validación de IP
- Validación de patrón numérico de matrícula
- Validación de URL
- Validación de texto sin espacios al principio y al final
- Validación de etiequetado HTML
- Validación de un nombre de usuario
- Validación de una password fuerte
- Validación de formatos de fechas

Una expresión regular es una secuencia de caracteres que conforma un patrón de búsqueda. Se utilizan principalmente para la búsqueda de patrones de cadenas de caracteres 
u operaciones de sustituciones. Las expresiones regulares son patrones utilizados para encontrar una determinada combinación de caracteres dentro de una cadena de texto. 
Las expresiones regulares proporcionan una manera muy flexible de buscar o reconocer cadenas de texto.

###### Coincidencias Básicas

- .	Cualquier Caracter, excepto nueva linea
- \d	Cualquier Digitos (0-9)
- \D	No es un Digito (0-9)
- \w	Caracter de Palabra (a-z, A-Z, 0-9, _)
- \W	No es un Caracter de Palabra
- \s	Espacios de cualquier tipo. (espacio, tab, nueva linea)
- \S	No es un Espacio, Tab o nueva linea.
###### Limites

- \b	Limite de Palabra
- \B	No es un Limite de Palabra
- ^	Inicio de una cadena de texto
- $	Final de una cadena de texto

###### Cuantificadores

- *	0 o Más
- +	1 o Más
- ?	0 o Uno
- {3}	Numero Exacto
- {3,4}	Rango de Numeros (Minimo, Maximo)

###### Conjuntos de Caracteres

- []	Caracteres dentro de los brackets
- [^]	Caracteres que NO ESTAN dentro de los brackets

###### Grupos

- ()	Grupo
- 		Uno u otro

## Scratch

Proyectos de Scratch a nivel educativo.

- Adivina un número: juego de adivinar un número con funciones de iniciación a las estructuras alternativas y secuenciales de código.
- Juego de Fútbol: juego de pasar una pelota entre dos campos. Se trabajan detalles de interfaz, estructuras alternativas, bucles y lógica para implementar el juego y las colisiones de los objetos.

## Sockets en Java

Proyecto completo de Sockets en Java en el que se crea una aplicación de chat completa (cliente-servidor). Se crea un cliente con su interfaz completa. 
La interfaz está hecha con Java Swing directamente en código (JFrame y JPanel con componentes de interacción para el usuario como cajas de texto y botones).

Además se implementa un Servidor con su interfaz, que lo único que tiene es una caja de texto en el que se van recibiendo los mensajes y desde que clientes.

Para probar el proyecto se tiene que distribuir a otro ordenador y ejecutar la clase Cliente y en uno de los ordenadores ejecutar la clase que hace de Servidor.

Al hacer click en el botón Enviar del Cliente se crea el socket a una dirección IP de la red local y a un puerto determinado, se crea el paquete de envío y se
genera un ObjectOutputStream para enviar los datos.

Además se crea un hilo que está permanentemente a la escucha de recibir nuevos mensajes desde el servidor.

En el servidor también tenemos un hilo de ejecución a modo de proceso cron que está permanentemente a la escucha de mensajes desde algún cliente. En el momento que 
recibe un mensaje lo procesa, pintando en la caja de texto de la interfaz del servidor el mensaje y el origen y creando un socket para enviar la información 
al destino.

## Threads en Java

Proyecto en el que podemos ver ejemplos básicos de utilización de Hilos en Java. Son ejemplos para entender la teoría de los hilos y poder
aplicarla en otros proyectos de mayor embergadura.

La computación concurrente es una forma de cómputo en la cual varios cálculos se realizan concurrentemente, y no uno a la vez de forma secuencial.
Es una característica propia de un sistema, ya sea un programa, una computadora o una red, en la cual existe un punto separado de ejecución o "hilo de control" para cada proceso. Un sistema concurrente es aquel donde un cálculo puede avanzar sin esperar a que el resto de los cálculos se completen.

#### Creación de hilos
Se tendrá que crear una clase que implemente la interfaz Runnable. Esto nos obligará a sobrescribir el método run() en nuestra clase. Escribir el código con la lógica del programa dentro del método run(). Instanciar la clase creada y almacenar la instancia en una variable de tipo Runnable. Crear una instancia de la clase Thread pasando como parámetro al constructor de Thread el objeto Runnable anterior. Poner en marcha el hilo de ejecución con el método start() de la clase Thread
Otra forma de crear una aplicación multitarea con hilos es que la clase que realiza la lógica herede de Thread, sobrescribiendo el método run() en dicha clase. Al crear una instancia de esa clase ya podremos utilizar el método start() para arrancar el hilo.

#### Interrupción de hilos
Para retardar la ejecución de un hilo se puede hacer uso del método estático sleep() perteneciente a la clase Thread. Al utilizar sleep() sobre un hilo, dicho hilo queda bloqueado. No se puede hacer nada con el hilo, ni siquiera solicitar su interrupción, aún así si se solicita a través del método interrupt() se lanza una excepción InterruptException.

Se puede interrumpir el hilo utilizando la instancia que realiza el start() y llamar al método stop(). Este método está obsoleto, aunque funciona. La interrupción se podrá llevar a cabo con el método interrupt(), sin embargo si el hilo utiliza el método sleep() se lanzará una excepción InterruptedException y no se podrá detener el hilo. Al capturar la excepción en el catch se puede hacer una salida del programa para solucionar el problema. Para la interrupción de un hilo se puede utilizar los métodos:

- interrupt(): método de clase (se utiliza sobre la clase Thread)
- isInterrupted(): método de instancia (se utiliza sobre la instancia de un hilo que se ha iniciado con el método start())

Se puede acceder al hilo actual en ejecución a través de Thread.currentThread

#### Trabajar con varios hilos
Para trabajar con varios hilos la clave es tener una instancia de la clase que implementa Runnable por cada hilo que se quiera ejecutar, con ello también podremos detener cada hilo de forma independiente.

#### Estado de los hilos
- Nuevo: cuando se instancia el hilo pero aún no se ha llamado al método start()
- Ejecutable: cuando se llama al método start()
- Bloqueado: cuando está en ejecución y se llama al método sleep()
- Muerto: cuando ocurre una excepción y no se captura o cuando termina de forma correcta

#### Sincronización de hilos
Puede ser deseable que no comience la ejecución de un hilo hasta que termine el anterior. Para realizar esto se utiliza el método join() de la clase Thread. Se puede realizar la llamada al método join() después de la ejecución del método start(). Esta forma de sincronizar los hilos depende del programador, ya que es el encargado de decirle al programa el orden de ejecución de los hilos con la instrucción join(). Si queremos que los hilos se sincronicen de forma automática y no estar obligados a indicarlo de forma explicita podemos utilizar la clase ReentrantLock correspondiente a la interfaz Lock. Tendremos que rodear el método que queremos proteger de la concurrencia de hilos con las instrucciones lock() y unlock() correspondientes a la instancia de clase ReentranLock.

**Condiciones en los bloqueos**
Para establecer condiciones en los bloqueos utilizando la clase ReentranLock podemos utilizar el método newCondition() que devuelve un objeto de tipo Condition, que es una interfaz que implementa el método await() y signalAll() que son los encargados de poner el hilo a la espera de que se satisfaga la condición y de avisar al resto de hilos de que se ha liberado la condición de bloqueo respetivamente.

**Synchronized**
Para realizar una sincronización se puede utilizar la palabra reservada synchronized. Para ello basta saber que cada clase va a tener disponible los métodos wait() y notifyAll() ya que son métodos pertenecientes a la clase Object. Estos métodos son análogos a los métodos await() y signalAll() de la interfaz Condition.
