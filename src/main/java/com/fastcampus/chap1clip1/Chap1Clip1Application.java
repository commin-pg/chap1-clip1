package com.fastcampus.chap1clip1;

import com.fastcampus.chap1clip1.producer.ClipProducer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class Chap1Clip1Application {

	public static void main( String[] args ) {
		SpringApplication.run( Chap1Clip1Application.class , args );
	}

	@Bean
	public ApplicationRunner runner(

//			KafkaTemplate<String,String> kafkaTemplate
			ClipProducer producer

	){
		return args -> {
//			kafkaTemplate.send( "clip3", "hello, Clip3" );
			producer.async("clip3", "Hello Clip3 Async");
			producer.sync("clip3", "Hello!! Clip3 Sync");

			producer.routingSend("clip3", "Hello?? Clip3 Routing");
			producer.routingSendBytes("clip3-bytes", "Hello?? Clip3 Routing-bytes".getBytes(StandardCharsets.UTF_8));

			producer.replyingSend("clip3-request", "Ping Clip3");
		};
	}


//	@Bean
//	public ApplicationRunner runner(Kafka)
}
