package se.lexicon.dreas94.exercises.Exercise6.dao.impl;

import se.lexicon.dreas94.exercises.Exercise6.Car;
import se.lexicon.dreas94.exercises.Exercise6.Owner;
import se.lexicon.dreas94.exercises.Exercise6.dao.OwnerDAO;
import se.lexicon.dreas94.exercises.Exercise6.exception.ObjectNotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OwnerDAOImpl implements OwnerDAO
{
    private List<Owner> storage;

    public OwnerDAOImpl()
    {
        this.storage = new ArrayList<>();
    }

    @Override
    public Owner create(Owner owner)
    {
        if(owner == null) throw new IllegalArgumentException("owner data is null");
        storage.add(owner);
        return owner;
    }

    @Override
    public Optional<Owner> findById(String id)
    {
        if (id == null) throw new IllegalArgumentException("Id is null");
        return storage.stream().filter(owner -> owner.getOwnerId().equalsIgnoreCase(id)).findFirst();
    }

    @Override
    public List<Owner> findByName(String name)
    {
        if (name == null) throw new IllegalArgumentException("name is null");
        return storage.stream().filter(owner -> owner.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    @Override
    public List<Owner> findByBirthdate(LocalDate birthdate)
    {
        if (birthdate == null) throw new IllegalArgumentException("model is null");
        return storage.stream().filter(owner -> owner.getBirthdate().equals(birthdate)).collect(Collectors.toList());
    }

    @Override
    public List<Owner> findAll()
    {
        return new ArrayList<>(storage);
    }

    @Override
    public void remove(String id) throws ObjectNotFoundException
    {
        Optional<Owner> optionalOwner = findById(id);
        if (optionalOwner.isPresent())
        {
            storage.remove(optionalOwner.get());
        }
        else
        {
            throw new ObjectNotFoundException("Owner id (" + id + ") does not exist");
        }
    }
}
