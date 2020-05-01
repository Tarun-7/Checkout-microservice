/**
 @author  Tarun
 @version  1.3
 */
package com.ecommerce.Checkoutmicroservice.StrategyPattern;

public class StrategyContext {

        private Strategy strategy;

        public StrategyContext(Strategy strategy){

            this.strategy = strategy;
        }

        public double executeStrategy(double carttoal){
            return strategy.setShippingcharges(carttoal);
        }
    }
