package com.rajanit.helloworld.HelloWorldProject;

import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;
@SpringBootTest	
public class ReactiveProgrammingExample {
	@Test
	public void test() {
		System.out.println("test started");
		Mono<String> monoPublisher= Mono.just("hello my world");
				monoPublisher.subscribe(new Subscriber<String>() { //anonymous inner class provide a quick implemenation of an interface/ abstract
					//class w/o needing to create a separate named class. They are particularly handy in situations where the implementation is needed
					// only once or is relatively simple, such as event handling, thread creation and custom implementation in reactive programming						
			@Override public void onSubscribe(Subscription s){
				System.out.println("onSubscribe called");
				s.request(1);
			}
			@Override
			public void onNext(String data) {
				System.out.println("data:: " +data);
			}
			@Override
			public void onError(Throwable t) {
				System.out.println("Error" +t.getMessage());
			}
			@Override
			public void onComplete() {
				System.out.println("onComplete called");
			}
					}			); 
				
		}
	}
			
	

