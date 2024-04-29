# rnt-parametros

## Descripción
Este es un proyecto de microservicio Spring Boot listo para ser desplegado en contenedores Docker. Está diseñado para ser simple, eficiente y fácil de escalar.

## Requisitos
- Docker

## Instalación y despliegue
Para obtener y ejecutar este proyecto, sigue los siguientes pasos:

```bash
# Clonar el repositorio
git clone http://gitlab.mtt.cl/rnt-api/rnt-parametros.git
cd rnt-parametros
git checkout develop

# Construir la imagen Docker
docker build -t rnt_parametros .

# Ejecutar el contenedor Docker
docker run -p 8083:8083 rnt_parametros
```

## Uso
Accede a la aplicación a través de http://localhost:8083/swagger-ui/index.html en tu navegador para verificar que está funcionando.