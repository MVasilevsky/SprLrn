package by.mvas.sprgr.repository;

import by.mvas.sprgr.model.Quote;

/**
 *
 * @author mvas
 */
public interface QuoteRepository {

    Quote findById(int id);

}
