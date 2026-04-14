package academy.tochkavhoda.school;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;

import java.util.Collection;

public class TraineeMultiValuedMap {
    private final MultiValuedMap<Integer, Trainee> trainees;

    public TraineeMultiValuedMap() {
        this.trainees = new HashSetValuedHashMap<>();
    }

    public boolean addTrainee(Trainee trainee) {
        return trainees.put(trainee.getRating(), trainee);
    }

    public boolean removeTrainee(Trainee trainee) {
        return trainees.removeMapping(trainee.getRating(), trainee);
    }

    public Collection<Trainee> getTraineesByRating(int rating) {
        return trainees.get(rating);
    }

    public boolean hasAnyBodyRating(int rating) {
        return !trainees.get(rating).isEmpty();
    }

    public int getTraineesCount() {
        return trainees.size();
    }
}
