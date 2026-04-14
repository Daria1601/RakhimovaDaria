package academy.tochkavhoda.school;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class School {
    private String name;
    private int year;
    private final Set<Group> groups;

    public School(String name, int year) throws TrainingException {
        this.groups = new HashSet<>();
        setName(name);
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name == null || name.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        }
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) throws TrainingException {
        boolean hasSameName = groups.stream().anyMatch(g -> Objects.equals(g.getName(), group.getName()));
        if (hasSameName) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_GROUP_NAME);
        }
        groups.add(group);
    }

    public void removeGroup(Group group) throws TrainingException {
        if (!groups.remove(group)) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }
    }

    public void removeGroup(String name) throws TrainingException {
        Group found = groups.stream()
                .filter(g -> Objects.equals(g.getName(), name))
                .findFirst()
                .orElseThrow(() -> new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND));
        groups.remove(found);
    }

    public boolean containsGroup(Group group) {
        return groups.contains(group);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return year == school.year && Objects.equals(name, school.name) && Objects.equals(groups, school.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, groups);
    }
}
