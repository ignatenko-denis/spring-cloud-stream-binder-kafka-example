package com.sample.cloud.subscribe;

import com.sample.cloud.publish.CreditWorthyPublisher;
import com.sample.dao.ClientRepository;
import com.sample.dto.ClientRq;
import com.sample.dto.ClientRs;
import com.sample.entity.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CreditRatingSubscribeListenerServiceImpl implements CreditRatingSubscribeListenerService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CreditWorthyPublisher publisher;

    @Override
    public void creditRating(ClientRq rq) {
        Client entity = new Client();
        entity.setName(rq.getName());
        entity.setCreditRating(rq.getCreditRating());

        clientRepository.save(entity);

        ClientRs rs = new ClientRs();
        rs.setName(entity.getName());
        rs.setCreditWorthy(isCreditWorthy(entity));

        log.info("send: {}", rs);
        publisher.creditWorthy(rs);
    }

    /**
     * If you have a FICO score above 760, you're going to be getting the best rates and opportunities.
     */
    private boolean isCreditWorthy(Client entity) {
        return entity.getCreditRating() > 760;
    }
}
