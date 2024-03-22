package pl.bartus.benzo.enzo.cryptoMsgService.domain.data.repository.h2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.entity.Msg;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.entity.h2.MsgH2;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.repository.MsgRepository;
import pl.bartus.benzo.enzo.cryptoMsgService.resource.util.IDGenerator;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("atom")
@Transactional()
public class RepositoryJPA implements MsgRepository {
    private final EntityManager entityManager;

    @Autowired
    public RepositoryJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Msg msg) {
        final String id = IDGenerator.generateId();
        msg.setId(id);
        MsgH2 jpaMsg = new MsgH2(msg);
        entityManager.merge(jpaMsg);
    }

    @Override
    public Optional<Msg> findById(String id) {
        TypedQuery<MsgH2> query = entityManager.createQuery("SELECT m FROM MsgH2 m WHERE m.id = :id", MsgH2.class);
        query.setParameter("id", id);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Msg> findAll() {
        TypedQuery<Msg> query = entityManager.createQuery("SELECT m FROM MsgH2 m", Msg.class);
        return query.getResultList();
    }

    @Override
    public void deleteById(String id) {
        findById(id).ifPresent(entityManager::remove);
    }
}
