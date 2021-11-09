package app.commerceio.spring.data.search.mongo.demo;

import app.commerceio.spring.data.search.mongo.demo.converter.BigDecimalReadConverter;
import app.commerceio.spring.data.search.mongo.demo.converter.BigDecimalWriteConverter;
import app.commerceio.spring.data.search.mongo.demo.converter.OffsetDateTimeReadConverter;
import app.commerceio.spring.data.search.mongo.demo.converter.OffsetDateTimeWriteConverter;
import app.commerceio.spring.data.search.mongodb.SearchRepositoryImpl;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.IOException;
import java.time.Clock;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableMongoRepositories(repositoryBaseClass = SearchRepositoryImpl.class)
public class DemoConfiguration {

    @Bean
    public MongodConfig embeddedMongoConfiguration() throws IOException {
        int port = Network.getFreeServerPort();
        return MongodConfig.builder()
                .version(Version.Main.PRODUCTION)
                .net(new Net(port, Network.localhostIsIPv6()))
                .build();
    }

    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(new OffsetDateTimeReadConverter());
        converters.add(new OffsetDateTimeWriteConverter());
        converters.add(new BigDecimalReadConverter());
        converters.add(new BigDecimalWriteConverter());
        return new MongoCustomConversions(converters);
    }

    @Bean
    @ConditionalOnMissingBean
    public Clock clock() {
        return Clock.system(ZoneOffset.UTC);
    }

}
