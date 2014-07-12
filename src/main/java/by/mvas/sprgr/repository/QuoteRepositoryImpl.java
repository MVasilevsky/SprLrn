package by.mvas.sprgr.repository;

import by.mvas.sprgr.model.Quote;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mvas
 */
@Repository
public class QuoteRepositoryImpl implements QuoteRepository {

    @Override
    public Quote findById(int id) {
        return new Quote(5, null, null, null, 2.4, null);
    }

}
