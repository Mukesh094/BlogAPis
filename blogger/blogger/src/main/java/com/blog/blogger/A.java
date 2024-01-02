package com.blog.blogger;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class A {
    public static void main(String[] args) {
  // it takes a input and produce a output  what input u take give the dataType what output u want mention the DataType in the functionalInterface.
//        Function<Integer,String> myFunction = i->"Result:" +i;
//        String val = myFunction.apply(100);
//        System.out.println(val);

//Function,FunctionalInterface
//        Function<Integer,Double> myFunction = i->i*1.3;
//        Double val = myFunction.apply(100);
//        System.out.println(val);


        //Supplier-->It is just producing output
//        Supplier<String> mySupplier = ()->"Supplied";
//        String s = mySupplier.get();
//        System.out.println(s);

        //Consumer-->it just giving input
        Consumer<String> myConsumer = s->System.out.println("Consumed:" +s);
        myConsumer.accept("Hello");
    }
}
