package academy.tochkavhoda.school;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TraineeMap {
    private final Map<Trainee, String> trainees;

    public TraineeMap() {
        this.trainees = new HashMap<>();
    }

    public void addTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (trainees.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        }
        trainees.put(trainee, institute);
    }

    public void replaceTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (!trainees.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        trainees.put(trainee, institute);
    }

    public void removeTraineeInfo(Trainee trainee) throws TrainingException {
        if (!trainees.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        trainees.remove(trainee);
    }

    public int getTraineesCount() {
        return trainees.size();
    }

    public String getInstituteByTrainee(Trainee trainee) throws TrainingException {
        if (!trainees.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        return trainees.get(trainee);
    }

    public Set<Trainee> getAllTrainees() {
        return new HashSet<>(trainees.keySet());
    }

    public Set<String> getAllInstitutes() {
        return new HashSet<>(trainees.values());
    }

    public boolean isAnyFromInstitute(String institute) {
        return trainees.containsValue(institute);
    }
}
