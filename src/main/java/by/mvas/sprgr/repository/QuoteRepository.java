package by.mvas.sprgr.repository;

import by.mvas.sprgr.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mvas
 */
public interface QuoteRepository extends JpaRepository<Quote, Integer> {
}
