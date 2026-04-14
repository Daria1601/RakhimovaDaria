package academy.tochkavhoda.school;

public class TrainingException extends Exception {
    private final TrainingErrorCode errorCode;

    public TrainingException(TrainingErrorCode errorCode) {
        super(errorCode.name());
        this.errorCode = errorCode;
    }

    public TrainingErrorCode getErrorCode() {
        return errorCode;
    }
}
