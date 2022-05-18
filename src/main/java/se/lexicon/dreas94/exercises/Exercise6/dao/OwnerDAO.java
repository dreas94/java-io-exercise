package se.lexicon.dreas94.exercises.Exercise6.dao;

import se.lexicon.dreas94.exercises.Exercise6.Owner;
import se.lexicon.dreas94.exercises.Exercise6.exception.ObjectNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OwnerDAO
{
    Owner create(Owner owner);

    Optional<Owner> findById(String id);

    List<Owner> findByName(String name);

    List<Owner> findByBirthdate(LocalDate birthdate);

    List<Owner> findAll();

    void remove(String id) throws ObjectNotFoundException;
}
