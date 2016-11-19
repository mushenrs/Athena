package me.mushen.athena.springdata.es.config;

import me.mushen.athena.springdata.es.core.ElasticEntityMapper;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.EntityMapper;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-10-31
 */
@Configuration
@ComponentScan(basePackages = {"me.mushen.athena.springdata.es.service"})
@EnableElasticsearchRepositories(basePackages = {"me.mushen.athena.springdata.es.repository"})
public class ApplicationESConfiguration {
    @Bean
    public ElasticsearchOperations elasticsearchTemplate(){
        // Elasticsearch Cluster name
        Settings settings = ImmutableSettings.settingsBuilder()
                .put("cluster.name", "gensokyo")
                .put("client.transport.sniff", true).build();
        // create Elasticsearch TransportClient
        TransportClient client = new TransportClient(settings);
        client.addTransportAddress(new InetSocketTransportAddress("127.0.0.1", 9300));

//        Client client = NodeBuilder.nodeBuilder().clusterName("gensokyo").node().client();

        EntityMapper entityMapper = new ElasticEntityMapper();

        return new ElasticsearchTemplate(client, entityMapper);
    }
}
