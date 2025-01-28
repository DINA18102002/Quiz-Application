🎯 Quiz-Application

🚀 Quiz Application (BackEnd)

This is a Java-based application utilizing Microservices architecture.

🏗️ Services Structure

Quiz Service 📝

Question Service ❓

📌 Eureka Server & Client

Eureka Server 🗂️: A registry where all microservices register themselves.

Eureka Client 🔗: A microservice that registers with the Eureka Server and fetches other services.

🔥 Feign (Declarative REST Client)

A Web service client in Spring Cloud that simplifies inter-service communication.

Integrates with Eureka for service discovery.

Supports load balancing with Ribbon. ⚖️

⚙️ How Eureka and Feign Work Together

✅ question-service and quiz-service register with Eureka Server 📡.
✅ quiz-service uses Feign to call question-service without needing a direct URL. 🔗
✅ Feign + Eureka automatically discover available instances and perform load balancing. 🔄


🎯 Which One to Use?\

🗂️ Eureka

Service Discovery (microservices find each other dynamically) 🔍

🔗 Feign

Calls other microservices by just defining an interface 📞




