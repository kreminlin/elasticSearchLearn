package com.kuang.service;

import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author 28711
 */
public interface ElasticsearchTask {

    /**
     * SlasticSearch工具类
     * @param client
     * @throws Exception
     */
    void doSomething(RestHighLevelClient client) throws Exception;

}

