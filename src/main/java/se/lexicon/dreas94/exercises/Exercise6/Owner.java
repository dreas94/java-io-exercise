package se.lexicon.dreas94.exercises.Exercise6;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Owner implements Serializable
{
    private final String ownerId;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate birthdate;

    public Owner()
    {
        this.ownerId = UUID.randomUUID().toString();
    }

    public Owner(String ownerId, String name, LocalDate birthdate)
    {
        this();
        setName(name);
        setBirthdate(birthdate);
    }

    public String getOwnerId()
    {
        return ownerId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getBirthdate()
    {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate)
    {
        this.birthdate = birthdate;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Owner)) return false;
        Owner owner = (Owner) o;
        return getOwnerId().equals(owner.getOwnerId()) && getName().equals(owner.getName()) && getBirthdate().equals(owner.getBirthdate());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getOwnerId(), getName(), getBirthdate());
    }
}
