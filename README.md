# MovieFlex

La arquitectura que se utilizo en este proyecto se conforma de la siguiente manera:

1.- [Capa de Persistencia](https://github.com/ismalel/MovieFlexPersistence)\
      En esta capa se crearon las entidades y las clases para persistir la informacion dentro del sharedPreferences de Android\
2.- [Capa de API](https://github.com/ismalel/MovieFlexAPI)\
      Aqui se hizo el consumo de la api de [The Movie Database](https://www.themoviedb.org) utilizando la libreria Retrofit\
3.- [Capa de Seguridad]()\
      La capa de seguirdad se encarga de encriptar la informacion que se guarda en la capa de persistencia\
4.- [Capa de Logica de Negocio]()\
      Aqui se realizo la logica para detectar si el dispositivo tiene conexion a internet\
5.- [Capa de Controlador]()\
      Esta capa se encargo de comunicar todas las capas entre si, para enviar la informacion a la aplicacion\
6.- [Aplicacion]()\
      La enlista las peliculas y series mas populares, votadas y recomendadas de la actualidad.\
\
Lamentablemente no tuve oportunidad de trabajar los 3 dias en la prueba tecnica, hasta aqui pude llegar, pero me diverti realizando el proyecto y lo seguire actualizando en el futuro
    
