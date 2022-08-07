package com.kuang.utils;

import com.kuang.service.impl.ConnectElasticsearch;

/**
 * @author 28711
 */
public class SomeClass {

    public static void main(String[] args) {
        ConnectElasticsearch.connect(client -> {
            //do something
        });
    }
}



