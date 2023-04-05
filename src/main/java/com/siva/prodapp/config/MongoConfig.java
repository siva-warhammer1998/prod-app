package com.siva.prodapp.config;
import com.mongodb.ConnectionString;
import com.mongodb.*;
import com.mongodb.client.MongoClient;

import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.siva.prodapp.dao")
public class MongoConfig {

    ConnectionString connectionString = new ConnectionString("mongodb+srv://siva:SIVAhari1!@production-cluster.acswo4j.mongodb.net/?retryWrites=true&w=majority");
    MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
 

    @Bean
    public MongoClient mongoClient() {
        MongoClient mongoClient = MongoClients.create(settings);
        return mongoClient;
    }

    @Bean
    public MongoDatabaseFactory mongoDatabaseFactory(){
            return new SimpleMongoClientDatabaseFactory(mongoClient(), "test");
        }            


    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDatabaseFactory());
    }
}
