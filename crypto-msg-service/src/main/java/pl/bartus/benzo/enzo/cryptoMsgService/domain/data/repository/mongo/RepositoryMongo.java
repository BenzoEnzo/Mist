package pl.bartus.benzo.enzo.cryptoMsgService.domain.data.repository.mongo;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.entity.Msg;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.repository.MsgRepository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("integration")
public class RepositoryMongo implements MsgRepository {
    private final MongoTemplate mongoTemplate;

    public RepositoryMongo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void save(Msg msg) {
        mongoTemplate.save(msg);
    }

    @Override
    public Optional<Msg> findById(String id) {
        return Optional.ofNullable(mongoTemplate.findById(id, Msg.class));
    }

    @Override
    public List<Msg> findAll() {
        return mongoTemplate.findAll(Msg.class);
    }

    @Override
    public void deleteById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Msg.class);
    }
}
