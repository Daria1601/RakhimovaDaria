package academy.tochkavhoda.school;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.util.HashSet;
import java.util.Set;

public class TraineeBidiMap {
    private final BidiMap<String, Trainee> trainees;

    public TraineeBidiMap() {
        this.trainees = new DualHashBidiMap<>();
    }

    public void addTrainee(Trainee trainee, String passport) throws TrainingException {
        if (trainees.containsValue(trainee)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        }
        if (trainees.containsKey(passport)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_PASSPORT);
        }
        trainees.put(passport, trainee);
    }

    public void replaceTraineePassport(Trainee trainee, String passport) throws TrainingException {
        if (!trainees.containsValue(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        if (trainees.containsKey(passport)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_PASSPORT);
        }
        String oldPassport = trainees.getKey(trainee);
        trainees.remove(oldPassport);
        trainees.put(passport, trainee);
    }

    public void removeTrainee(Trainee trainee) throws TrainingException {
        if (!trainees.containsValue(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        trainees.removeValue(trainee);
    }

    public void removeTraineeByPassport(String passport) throws TrainingException {
        if (!trainees.containsKey(passport)) {
            throw new TrainingException(TrainingErrorCode.PASSPORT_NOT_FOUND);
        }
        trainees.remove(passport);
    }

    public Trainee getTraineeByPassport(String passport) throws TrainingException {
        Trainee trainee = trainees.get(passport);
        if (trainee == null) {
            throw new TrainingException(TrainingErrorCode.PASSPORT_NOT_FOUND);
        }
        return trainee;
    }

    public String getPassportByTrainee(Trainee trainee) throws TrainingException {
        String passport = trainees.getKey(trainee);
        if (passport == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        return passport;
    }

    public Set<Trainee> getAllTrainees() {
        return new HashSet<>(trainees.values());
    }

    public Set<String> getAllPassports() {
        return new HashSet<>(trainees.keySet());
    }

    public Set<String> getAllpassports() {
        return getAllPassports();
    }

    public boolean hasAnybodyPassport(String passport) {
        return trainees.containsKey(passport);
    }

    public int getTraineesCount() {
        return trainees.size();
    }
}
