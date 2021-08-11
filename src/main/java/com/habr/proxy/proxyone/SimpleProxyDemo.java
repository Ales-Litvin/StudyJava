package com.habr.proxy.proxyone;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SimpleProxyDemo {
    interface Quoter {
        void sayQuote();
    }

    static class TerminatorQuoter implements Quoter {
        private final String quote;

        public TerminatorQuoter(String quote) {
            this.quote = quote;
        }

        @Override
        public void sayQuote() {
            System.out.println(quote);
        }
    }

    static class QuoterHandler implements InvocationHandler {
        private final Quoter original;

        public QuoterHandler(Quoter original) {
            this.original = original;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            System.out.println("He says quote!");
            method.invoke(original, args);
            System.out.println("He break!");
            return null;
        }
    }

    public static void main(String[] args) {
        TerminatorQuoter terminator = new TerminatorQuoter("How are you?");
        QuoterHandler quoterHandler = new QuoterHandler(terminator);
        Quoter proxyQuoter = (Quoter) Proxy.newProxyInstance(
               terminator.getClass().getClassLoader(),
                terminator.getClass().getInterfaces(),
                quoterHandler);
        proxyQuoter.sayQuote();
    }
}
