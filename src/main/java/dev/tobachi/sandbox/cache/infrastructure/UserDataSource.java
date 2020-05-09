package dev.tobachi.sandbox.cache.infrastructure;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import dev.tobachi.sandbox.cache.model.DataSourceException;
import dev.tobachi.sandbox.cache.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
@Slf4j
public class UserDataSource {

    @Cacheable(cacheNames = "users")
    public List<User> getAll() {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(User.class).withHeader();

        try {
            log.info("reading csv file");
            File file = new ClassPathResource("data/users.csv").getFile();
            MappingIterator<User> readValues = mapper.readerFor(User.class).with(schema).readValues(file);
            return readValues.readAll();
        } catch (IOException e) {
            throw new DataSourceException(e.getMessage());
        }
    }

}
