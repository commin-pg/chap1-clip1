package com.fastcampus.chap1clip1;

import com.fastcampus.chap1clip1.producer.ClipProducer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class Chap1Clip1Application {

	public static void main( String[] args ) {
		SpringApplication.run( Chap1Clip1Application.class , args );
	}

	@Bean
	public ApplicationRunner runner(
			ClipProducer producer,
			KafkaMessageListenerContainer kafkaMessageListenerContainer
	){
		return args -> {
			producer.async("clip4", "Hello Clip4 Async");
			kafkaMessageListenerContainer.start();
			Thread.sleep(1_000);

			System.out.println("Pause");
			kafkaMessageListenerContainer.pause();
			Thread.sleep(5_000);


			producer.async("clip4", "Secondly Hello Clip4 Async");
			System.out.println("Resume");
			kafkaMessageListenerContainer.resume();
			Thread.sleep(1_000);


			System.out.println("Stop");
			kafkaMessageListenerContainer.stop();

		};
	}


//	@Bean
//	public ApplicationRunner runner(Kafka)
}
