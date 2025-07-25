## Category Microservice

To run it:

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

5. Run the Docker container:

   ```
    docker run -dit -p 8082:8003 --name category-service --network test-network -e PORT=8003 -e DB_HOST=test-db:3306 vierpaspuel/category-microservice:v2
    # v2 is the version tag, change it as needed
   ```
6. Access it at http://localhost:8082/api/categories# category-microservice
