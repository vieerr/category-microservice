## Category Microservice

The image is available at:

https://hub.docker.com/r/vierpaspuel/category-microservice

To pull it:

1. Pull the image

   ```
    docker pull vierpaspuel/category-microservice
   ```
   or if you want the specific version 2

   ```
   docker pull vierpaspuel/category-microservice:v2
   ```
   You can go ahead and jump to the "To run it" section

To build it:

1. Compile the project:

   ```
   mvn clean package
   ```

2. Create a Docker network (if not already created):
   ```
   docker network create test-network
   ```
3. Create test-db
   ```
   docker run --name test-db -e MYSQL_ROOT_PASSWORD=admin123 -e MYSQL_DATABASE=test -p 3306:3306 -d --network test-network mysql
   ```
4. Build the Docker image:

   ```

   docker build -t categories-service .

   #Add version tag if needed
   ```

To run it:

1. Run the Docker container:

   ```
    docker run -dit -p 8082:8003 --name category-service --network test-network -e PORT=8003 -e DB_HOST=test-db:3306 vierpaspuel/category-microservice:v2
    # v2 is the version tag, change it as needed
   ```

2. Access it at http://localhost:8082/api/categories
