package edu.dat076.yep.repositories;

import edu.dat076.yep.models.Round;
import org.springframework.data.repository.CrudRepository;

/**
 * Persistence interface for the round class.
 *
 * is implemented by Spring at runtime.
 *
 * Created by marcus on 2016-03-07.
 */
public interface RoundRepository extends CrudRepository<Round, Long> {
}
