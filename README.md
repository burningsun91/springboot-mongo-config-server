# springboot-mongo-config-server

Spring Cloud Config Server with MongoDB backend

TechStack:
Spring Boot, Spring Cloud, MongoDB

To Run the apps , follow below steps:
1. Create any collection in MongoDB and add below document:

db.<collection_name>.insert({   
    "label" : "master",
    "profile" : "prod",
    "source" : {
        "user" : {
            "test1" : "test1_prod",
            "test2" : "test2_prod"
        }
    }
});


db.<collection_name>.insert({   
    "label" : "master",
    "profile" : "dev",
    "source" : {
        "user" : {
            "test1" : "test1_dev",
            "test2" : "test2_dev"
        }
    }
});

2. Run mongo-config-server application
3. Run spring-cloud-config-client application
