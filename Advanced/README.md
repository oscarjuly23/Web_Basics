# Advanced exercices
## Exercice a)
- [ExerciceA](https://github.com/oscarjuly23/Web_Basics/tree/main/Advanced/ExerciceA):
1. El objetivo de esta actividad es utilizar expresiones XPATH para extraer resultados de un documento XML. Dado el documento XML books.xml que tienes en SALLENET, escribe las expresiones XPATH que permitan acceder a la siguiente información.
2. El objetivo de esta actividad es utilizar expresiones XPATH para extraer resultados de un documento XML. Dado el documento XML notas_alumnos.xml que tienes en SALLENET, escribe las expresiones XPATH que respondan a las siguientes preguntas.
3. El objetivo de esta actividad es utilizar expresiones XPATH para extraer resultados de un documento XML. A partir del documento prevision.xml que dispones en SALLENET que contiene información sobre la previsión meteorológica en distintas poblaciones de Cataluña en Mayo 2018, escribe las expresiones XPATH que respondan a las siguientes preguntas:
- ¿Qué tiempo hará en Girona el 23 Mayo 14.00h?
- ¿Qué cantidad de agua caerá en Salt el día 22 Mayo?
- ¿Qué días lloverá en Olot?
- Nombre de las poblaciones donde habrá 24 grados a las 08.00h
- ¿Media de temperaturas del Alt Empordá?

## Exercice b)
- [ExerciceB](https://github.com/oscarjuly23/Web_Basics/tree/main/Advanced/ExerciceB):
El objetivo de esta actividad es utilizar la base de datos BASEX y realizar consultas XQUERY. Crea una nueva base de datos denominada productos, que contenga el fichero productos.xml.
Este documento contiene los datos de los productos de una distribuidora de material informático. Por cada producto tenemos código, denominación, precio, stock actual, stock mínimo y el código de la zona.
La siguiente tabla muestra la asociación entre códigos y tipo de producto.
- Código=TC.32700-> productos de almacenamiento
- Código=NB.32500->netbooks
- Código=TB.32800->tablets
Realiza las siguientes consultas XQUERY:
1. Obtén por cada zona, el número de productos que tiene
2. Obtén la denominación de los productos entre las etiquetas <zona15></zona15> si son de la zona 15, <zona20></zona20> sin son de la zona 20.
3. Obtén por cada zona la denominación de los productos más caros
4. Obtén la denominación de los productos contenida entre las etiquetas
<almacenamiento></almacenamiento> para los productos en cuyo código aparece
TC.32700, <netbook></netbook> para los productos en cuyo código aparece
NB.32500, <tablet></tablet> para los productos en cuyo código aparece TB.32800

Sube a la base de datos productos el documento zonas.xml. Este fichero contiene información
de las zonas donde se venden los productos del documento productos.xml. Utilizando estos
dos documentos realiza las siguientes consultas XQUERY:
1.  De cada producto: denominación, precio y nombre de la zona, ordenado por nombre de la zona
2.  De cada zona: nombre de la zona y número de productos que tiene
3.  Visualiza la denominación de los productos con su nombre de la zona. Utiliza dos for en la consulta
4.  Visualiza los nombres de los productos con stock mínimo>10, su código de zona, el nombre de la zona, el director de la zona. Utiliza dos for en la consulta

## Exercice c)
- [ExerciceC](https://github.com/oscarjuly23/Web_Basics/tree/main/Advanced/ExerciceC):
El objetivo de esta actividad es ver la relación entre ficheros XML y bases de datos relacionales.
En este ejercicio guiado vamos a practicar el acceso a ficheros XML desde Java usando SAX
(Simple API for XML). Esta técnica se puede utilizar para tratar cualquier documento XML,
tanto online como local. En la demo de clase se ha trabajado la lectura de un documento XML
local, y en este ejercicio vamos a trabajar con un documento XML online
Como puede observarse, se compone de un elemento principal <channel> seguido de varios
datos relativos al canal y posteriormente una lista de elementos <item> para cada noticia con
sus datos asociados (title, link, description, guid, pubDate)
Lo primero que vamos a hacer es definir una clase java (New) para almacenar los datos de una
noticia (new). Nuestro objetivo final será devolver una lista de objetos de este tipo, con la
información de todas las noticias.
En el modelo SAX, el tratamiento de un XML se basa en un analizador (parser) que a medida
que lee secuencialmente el documento XML va generando diferentes eventos con la
información de cada elemento leído. Así, por ejemplo, a medida que lee el XML, si encuentra el
comienzo de una etiqueta <title> generará un evento de comienzo de etiqueta, startElement(),
con su información asociada, si después de esa etiqueta encuentra un fragmento de texto
generará un evento characters() con toda la información necesaria, y así sucesivamente hasta
el final del documento. Nuestro trabajo consistirá por tanto en implementar las acciones
necesarias a ejecutar para cada uno de los eventos posibles que se pueden generar durante la
lectura del documento XML.
Los principales eventos que se pueden producir son los siguientes:
- startDocument(): comienza el documento XML.
- endDocument(): termina el documento XML.
- startElement(): comienza una etiqueta XML.
- endElement(): termina una etiqueta XML.
- characters(): fragmento de texto.

Todos estos métodos están definidos en la clase org.xml.sax.helpers.DefaultHandler, de la cual
deberemos derivar una clase propia donde se sobrescriban los eventos necesarios. En nuestro
caso vamos a llamarla RssHandler
Lo primero que haremos será incluir como propiedad de la clase, la lista de noticias que
pretendemos construir, List<New> news, y un método getNews() que permita obtenerla
cuando la lectura del documento XML se haya completado.
Además necesitaremos dos propiedades auxiliares: currentNew de tipo New que permitirá
registrar los datos de cada noticia según se vaya leyendo el ficheroXML; y sb de tipo
StringBuilder que permitirá ir almacenando el contenido de cada noticia.
Tras esto, implementamos directamente los eventos SAX necesarios: startDocument(),
startElement(), endElement(), characters(). Comencemos por startDocument(), este evento
indica que se ha comenzado a leer el documento XML, por lo que lo aprovecharemos para
inicializar la lista de noticias y las variables auxiliares.
Tras éste, el evento startElement() se lanza cada vez que se encuentra una nueva etiqueta de
apertura. En nuestro caso, la única etiqueta que nos interesará será <item>, momento en el
que inicializaremos currentNew donde almacenaremos posteriormente los datos de la noticia
actual.
El siguiente evento relevante es characters(), que se lanza cada vez que se encuentra un
fragmento de texto en el interior de una etiqueta. La técnica aquí será ir acumulando en la
variable auxiliar, sb, todos los fragmentos de texto que encontremos hasta detectarse una
etiqueta de cierre.
Por último, en el evento de cierre de etiqueta, endElement(), lo que haremos será almacenar
en el atributo apropiado (title, description, etc) del objeto currentNew (que conoceremos por el parámetro localName devuelto por el evento) el texto que hemos ido acumulando en la
variable sb y limpiaremos el contenido de dicha variable para comenzar a acumular el
siguiente dato. El único caso especial será cuando detectemos el cierre de la etiqueta <item>,
que significará que hemos terminado de leer todos los datos de la noticia y por tanto
aprovecharemos para añadir la noticia actual a la lista de noticias que estamos construyendo.
Una vez implementado nuestro handler, vamos a crear una nueva clase que haga uso de él
para parsear mediante SAX un documento XML concreto. A esta clase la llamaremos
RssParserSax. Esta clase tendrá únicamente un constructor que reciba como parámetro la URL
del documento a parsear.
La clase RssParserSax, dispondrá además de un método público llamado parse() para ejecutar
la lectura del documento, y que devolverá como resultado una lista de noticias.
Con esto ya tenemos nuestra aplicación Java preparada para parsear un documento XML
online utilizando el modelo SAX. Veamos lo simple que sería ahora llamar a este parser desde
nuestra clase Main.
En este ejercicio guiado vamos a practicar el acceso a ficheros XML desde Java usando DOM
con DOM la estrategia cambia radicalmente respecto de SAX. Con DOM, el documento XML se
lee completamente antes de poder realizar ninguna acción en función de su contenido. Esto es
posible gracias a que, como resultado de la lectura del documento, el parser DOM devuelve
todo su contenido en forma de una estructura de tipo árbol, donde los distintos elementos del
XML se representa en forma de nodos y su jerarquía padre-hijo se establece mediante
relaciones entre dichos nodos.
Vamos a crear la clase RssParserDom que permita parsear mediante DOM un documento XML
concreto. Esta clase tendrá únicamente un constructor que reciba como parámetro la URL del
documento a parsear.
Igual que con SAX, está clase dispondrá del método parse() para ejecutar la lectura del
documento, y que devolverá como resultado una lista de noticias.
Al igual que hacíamos para SAX, el primer paso será instanciar una nueva fábrica, esta vez de
tipo DocumentBuilderFactory, y posteriormente crear un nuevo parser a partir de ella
mediante el método newDocumentBuilder().
A partir del objeto Document, podremos navegar para realizar el tratamiento necesario del
XML. Vamos a buscar todos los nodos cuya etiqueta sea <item>. Esto lo conseguimos
utilizando el método de búsqueda por nombre de etiqueta
getElementsByTagName(“nombre_de_etiqueta“), que devolverá una lista (de tipo NodeList)
con todos los nodos hijos del nodo actual cuya etiqueta coincida con la pasada como
parámetro. Una vez tenemos localizados todos los elementos <item>, que representan a cada
noticia, los vamos a recorrer uno a uno para ir generando todos los objetos New necesarios
Para cada nodo <ítem>, se obtendrán los nodos hijos del elemento
mediante getChildNodes() y se recorrerán éstos obteniendo su texto y almacenándolo en el
atributo correspondiente del objeto New. Para saber a qué etiqueta corresponde cada nodo
hijo utilizamos el método getNodeName().
Haciendo uso de la función getElementText obtendremos el contenido textual de los nodos.
Implementamos esta función en la clase RssParserDom
Terminamos de completar el método parse() de la clase RssParserDom
Con esto ya tenemos nuestra aplicación Java preparada para parsear un documento XML
online utilizando el modelo DOM. Veamos lo simple que sería ahora llamar a este parser desde
nuestra clase Main.
